package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.ChooseHorse;
import co.com.sofkau.horseraces.domain.game.commands.CreatePlayer;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

import java.util.Objects;
import java.util.Optional;

public class ChooseHorseUseCase {
    public Object apply(PlayerRepository playerRepository, HorseRepository horseRepository, ChooseHorse command) {

        Optional<Horse> optionalHorse = horseRepository.findById(command.getHorseId());
        Optional<Player> optionalEntity = playerRepository.findById(command.getPlayerId());

        if (optionalEntity.isPresent()&&optionalHorse.isPresent()) {
            var entity = optionalEntity.get();
            entity.setHorseId(command.getHorseId());
            return Optional.of(entity);
        } else {
            throw new NullPointerException("The referenced player and/or horse doesn't exist");
        }
    }
}

//    apply((HorseChosen event) -> {
//            if (game.players.containsKey(event.getPlayerId().value())) {
//                game.players.get(event.getPlayerId().value())
//                        .setHorseId(event.getHorseId());
//            } else {
//                throw new NullPointerException("The referenced player doesn't exist");
//            }
//            //<IDLE,IDLE>
//        });
