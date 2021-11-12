package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Lane;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.PrepareGame;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PrepareGameUseCase {
    public Object apply(GameRepository gameRepository, PlayerRepository playerRepository,
                        PrepareGame command) {

        Optional<Game> optionalEntity = gameRepository.findById(command.getGameId());
        var players=playerRepository.findAllById(command.getPlayerIds());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("IDLE")
        &&havePlayersAHorse(players)&&isTrackValid(optionalEntity.get())&&command.getPlayerIds().size()>=3) {

            var game = optionalEntity.get();

            int counter = 1;
            for (Player iterable:players) {
                game.getLanes().add(new Lane(iterable.getPlayerId(),iterable.getHorseId(),
                        game.getTrack(),String.valueOf(counter)));
                counter+=1;
            }
            game.setActualState("PREPARED");
            return Optional.of(gameRepository.save(game));
        } else {
            throw new NullPointerException("The referenced game doesn't exist or is not ready to prepare lanes");
        }
    }
//    @Override
//    public void executeUseCase(RequestCommand<PrepareGame> prepareGameRequestCommand) {
//        var command = prepareGameRequestCommand.getCommand();
//        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));
//
//        if(isDataComplete(game)&&game.getActualState().value().equals("IDLE")){
//            game.prepareGame(command.getPlayerIds());
//            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
//        }
//        else{
//            emit().onError(new BusinessException(game.identity().value(),
//                    "The data is uncomplete (Need horses and valid track to setupGame)"));
//        }
//
//
//    }
//
    private boolean havePlayersAHorse(Iterable<Player> players) {
        boolean returnValue=true;
        for (Player player:players) {
            if(player.getHorseId().isEmpty()||player.getHorseId().isBlank()){
                returnValue=false;
            }
        }
        return returnValue;
    }

    private boolean isTrackValid(Game game){
        return !(game.getTrack().isNaN()||game.getTrack().isInfinite()||game.getTrack()<2000);
    }
}
