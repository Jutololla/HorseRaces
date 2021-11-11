package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.DoRematch;

public class DoRematchUseCase extends UseCase<RequestCommand<DoRematch>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<DoRematch> doRematchRequestCommand) {
        var command = doRematchRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if (game.getActualState().value().equals("FINISHED")) {
            game.doRematch();
            game.setPodium();
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        } else {
            emit().onError(new BusinessException(game.identity().value(),
                    "The game has not finished"));
        }
    }
}

