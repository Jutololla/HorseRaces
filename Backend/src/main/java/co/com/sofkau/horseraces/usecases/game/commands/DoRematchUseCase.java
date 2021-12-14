package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Lane;
import co.com.sofkau.horseraces.domain.game.commands.DoRematch;
import co.com.sofkau.horseraces.domain.game.commands.RunRace;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;

import java.util.Optional;

public class DoRematchUseCase {
    public Object apply(GameRepository gameRepository, PlayerRepository playerRepository,
                        PodiumRepository podiumRepository, DoRematch command) {
        RunRaceUseCase runRaceUseCase = new RunRaceUseCase();
        Optional<Game> optionalEntity = gameRepository.findById(command.getGameId());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("FINISHED")) {
            var game = optionalEntity.get();
            for(Lane lane:game.getLanes()){
                lane.getMetersRunned().clear();
                lane.setSpeed(0d);
            }
            game.setActualState("PREPARED");
            gameRepository.save(game);
            return runRaceUseCase.apply(gameRepository,playerRepository,podiumRepository,new RunRace(game.getGameId()));
        } else {
            throw new NullPointerException("The referenced game doesn't exist or the game is not PREPARED");
        }



    }

//
//    @Override
//    public void executeUseCase(RequestCommand<DoRematch> doRematchRequestCommand) {
//        var command = doRematchRequestCommand.getCommand();
//        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));
//
//        if (game.getActualState().value().equals("FINISHED")) {
//            game.doRematch();
//            game.setPodium();
//            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
//        } else {
//            emit().onError(new BusinessException(game.identity().value(),
//                    "The game has not finished"));
//        }
//    }
}

