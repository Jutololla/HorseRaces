package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Lane;
import co.com.sofkau.horseraces.domain.game.Podium;
import co.com.sofkau.horseraces.domain.game.commands.CleanLanes;
import co.com.sofkau.horseraces.domain.game.utils.LaneComparator;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;

import java.util.Optional;

public class CleanLanesUseCase {
    public Object apply(GameRepository gameRepository, PlayerRepository playerRepository,
                        PodiumRepository podiumRepository, CleanLanes command) {
        Optional<Game> optionalEntity = gameRepository.findById(command.getGameId());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("FINISHED")) {
            var game = optionalEntity.get();
            for(Lane lane:game.getLanes()){
                playerRepository.findById(lane.getPlayerId()).ifPresent(player -> {
                    player.setHorseId(null);
                    playerRepository.save(player);
                });
            }
            game.getLanes().clear();


            game.setActualState("IDLE");
            return gameRepository.save(game);
        } else {
            throw new NullPointerException("The referenced game doesn't exist or the status game is not FINISHED");
        }





    }
//    @Override
//    public void executeUseCase(RequestCommand<CleanLanes> doCleanRequestCommand) {
//        var command = doCleanRequestCommand.getCommand();
//        var game = Game.from(command.getGameId(), retrieveEvents(command.getGameId().value()));
//
//        if (game.getActualState().value().equals("FINISHED")) {
//            game.cleanLanesAndPodium();
//            emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
//        } else {
//            emit().onError(new BusinessException(game.identity().value(),
//                    "The game has not finished"));
//        }
//    }
}
