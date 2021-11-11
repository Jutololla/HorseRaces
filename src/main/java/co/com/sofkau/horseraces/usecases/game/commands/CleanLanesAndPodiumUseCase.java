package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.CleanLanesAndPodium;

public class CleanLanesAndPodiumUseCase extends UseCase<RequestCommand<CleanLanesAndPodium>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CleanLanesAndPodium> doCleanRequestCommand) {
        var command = doCleanRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if (game.getActualState().value().equals("FINISHED")) {
            game.cleanLanesAndPodium();
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        } else {
            emit().onError(new BusinessException(game.identity().value(),
                    "The game has not finished"));
        }
    }
}
