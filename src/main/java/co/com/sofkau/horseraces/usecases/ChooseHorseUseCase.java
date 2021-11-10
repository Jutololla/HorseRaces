package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.ChooseHorse;

public class ChooseHorseUseCase extends UseCase<RequestCommand<ChooseHorse>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChooseHorse> chooseHorseRequestCommand) {
        var command = chooseHorseRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        game.chooseHorse(command.getHorseId(), command.getPlayerId());
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}
