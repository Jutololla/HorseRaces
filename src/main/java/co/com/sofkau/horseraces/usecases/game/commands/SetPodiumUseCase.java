package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.SetPodium;

public class SetPodiumUseCase extends UseCase<RequestCommand<SetPodium>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SetPodium> setPodiumRequestCommand) {
        var command = setPodiumRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if(game.getActualState().value().equals("RUNNING")){
            game.setPodium();
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        }
        else {
            emit().onError(new BusinessException(game.identity().value(),
                    "The game actualState is not RUNNING"));
        }
    }
}
