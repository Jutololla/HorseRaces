package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Podium;
import co.com.sofkau.horseraces.domain.game.commands.AddTrack;
import co.com.sofkau.horseraces.domain.game.commands.SetPodium;
import co.com.sofkau.horseraces.domain.game.utils.LaneComparator;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;

import java.util.Collections;
import java.util.Optional;

public class SetPodiumUseCase{

    public Game apply(GameRepository gameRepository, PlayerRepository playerRepository,
                      PodiumRepository podiumRepository, Game game1) {
        Optional<Game> optionalEntity = gameRepository.findById(game1.getGameId());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("RUNNING")) {
            var game = optionalEntity.get();

            game.getLanes().sort(new LaneComparator());

            Podium podium = new Podium();
            podium.setFirstPlacePlayerId(game.getLanes().get(0).getPlayerId());
            podium.setSecondPlacePlayerId(game.getLanes().get(1).getPlayerId());
            podium.setThirdPlacePlayerId(game.getLanes().get(2).getPlayerId());
            podium.setTrack(game.getTrack());
            podium.setLanes(game.getLanes());
            podium.setGameId(game.getGameId());
            podiumRepository.save(podium);

            playerRepository.findById(podium.getFirstPlacePlayerId())
                    .ifPresent(e->{
                        e.getFirstPlacePodiumId().add(podium.getPodiumId());
                        playerRepository.save(e);
                    });
            playerRepository.findById(podium.getSecondPlacePlayerId())
                    .ifPresent(e->{
                        e.getSecondPlacePodiumId().add(podium.getPodiumId());
                        playerRepository.save(e);
                    });
            playerRepository.findById(podium.getThirdPlacePlayerId())
                    .ifPresent(e->{
                        e.getThirdPlacePodiumId().add(podium.getPodiumId());
                        playerRepository.save(e);
                    });

            game.setActualState("FINISHED");
            return gameRepository.save(game);
        } else {
            throw new NullPointerException("The referenced game doesn't exist or the status game is not RUNNING");
        }
    }
}
