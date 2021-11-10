package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.RunRace;

public class RunRaceUseCase extends UseCase<RequestCommand<RunRace>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RunRace> runRaceRequestCommand) {
        var command = runRaceRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if(game.getActualState().value().equals("PREPARED")){
            game.runRace();
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        }
        else {
            emit().onError(new BusinessException(game.identity().value(),
                    "The game has not been prepared"));
        }
    }
}
