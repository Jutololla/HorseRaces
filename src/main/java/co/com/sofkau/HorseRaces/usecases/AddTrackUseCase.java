package co.com.sofkau.HorseRaces.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.HorseRaces.domain.game.Game;
import co.com.sofkau.HorseRaces.domain.game.commands.AddTrack;

public class AddTrackUseCase extends UseCase<RequestCommand<AddTrack>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTrack> addTrackRequestCommand) {
        var command = addTrackRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        game.addTrack(command.getTrackId(), command.getLength());

        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}
