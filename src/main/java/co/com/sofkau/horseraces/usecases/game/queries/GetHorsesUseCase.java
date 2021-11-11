package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.commands.RunRace;
import co.com.sofkau.horseraces.queries.GetHorses;

import java.util.HashSet;

public class GetHorsesUseCase extends UseCase<RequestCommand<GetHorses>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<GetHorses> getHorsesRequestCommand) {
        System.out.println("this method is empty");
        executeQuery(getHorsesRequestCommand);
    }

    public HashSet<Horse> executeQuery(RequestCommand<GetHorses> getHorsesRequestCommand) {
        var command = getHorsesRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if(game.getActualState().value().equals("IDLE")){
            return game.getHorses();
        }
        else {
            throw new BusinessException(game.identity().value(),
                    "The game is not in IDLE state");
        }
    }
}
