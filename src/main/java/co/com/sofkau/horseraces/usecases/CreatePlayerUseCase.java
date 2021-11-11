package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.domain.game.commands.CreatePlayer;

public class CreatePlayerUseCase extends UseCase<RequestCommand<CreatePlayer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePlayer> createPlayerRequestCommand) {
        var command = createPlayerRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if (game.getActualState().value().equals("FINISHED")) {
            game.createPlayer(command.getPlayerId(),command.getName());
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        } else {
            emit().onError(new BusinessException(game.identity().value(),
                    "The game has not finished"));
        }
    }
}