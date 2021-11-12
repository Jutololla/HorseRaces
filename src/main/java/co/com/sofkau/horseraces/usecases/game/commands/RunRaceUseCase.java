package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Lane;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.RunRace;
import co.com.sofkau.horseraces.repositories.GameRepository;

import java.util.Optional;

public class RunRaceUseCase{
    public Object apply(GameRepository gameRepository, RunRace command) {
        Optional<Game> optionalEntity = gameRepository.findById(command.getGameId());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("PREPARED")) {
            var game = optionalEntity.get();

            for (Lane iterable:game.getLanes()) {
                iterable.run();
            }
            game.setActualState("RUNNING");
            return Optional.of(gameRepository.save(game));
        } else {
            throw new NullPointerException("The referenced game doesn't exist");
        }
    }

//    @Override
//    public void executeUseCase(RequestCommand<RunRace> runRaceRequestCommand) {
//        var command = runRaceRequestCommand.getCommand();
//        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));
//
//        if(game.getActualState().value().equals("PREPARED")){
//            game.runRace();
//            game.setPodium();
//            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
//        }
//        else {
//            emit().onError(new BusinessException(game.identity().value(),
//                    "The game has not been prepared"));
//        }
//    }
}
