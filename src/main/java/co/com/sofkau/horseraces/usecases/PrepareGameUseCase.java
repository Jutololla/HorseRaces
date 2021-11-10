package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.PrepareGame;

import java.util.Map;

public class PrepareGameUseCase extends UseCase<RequestCommand<PrepareGame>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<PrepareGame> prepareGameRequestCommand) {
        var command = prepareGameRequestCommand.getCommand();
        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));

        if(isDataComplete(game)&&game.getActualState().value().equals("IDLE")){
            game.prepareGame(command.getPlayerIds());
            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
        }
        else{
            emit().onError(new BusinessException(game.identity().value(),
                    "The data is uncomplete (Need horses and valid track to setupGame)"));
        }


    }

    private boolean isDataComplete(Game game) {
        boolean returnValue=true;
        for (Player player:game.getPlayers().values()) {
            if(player.getHorseId().value().isEmpty()||player.getHorseId().value().isBlank()){
                returnValue=false;
            }
        }

        if(!game.getTrack().isValid()){
            returnValue=false;
        }

        return returnValue;
    }
}
