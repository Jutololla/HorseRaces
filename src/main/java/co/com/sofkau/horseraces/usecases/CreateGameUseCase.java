package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;

public class CreateGameUseCase extends UseCase<RequestCommand<CreateGame>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateGame> createGameRequestCommand) {
        var command = createGameRequestCommand.getCommand();
        var game = new Game(
                command.getGameId(),
                command.getDateTime()
        );
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}