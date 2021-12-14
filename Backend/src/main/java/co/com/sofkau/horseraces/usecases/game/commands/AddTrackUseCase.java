package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.AddTrack;
import co.com.sofkau.horseraces.repositories.GameRepository;

import java.util.Optional;

public class AddTrackUseCase{
    public Object apply(GameRepository gameRepository, AddTrack command) throws Exception {
        Optional<Game> optionalEntity = gameRepository.findById(command.getGameId());

        if (optionalEntity.isPresent()&&optionalEntity.get().getActualState().equals("IDLE")) {
            var entity = optionalEntity.get();
            entity.setTrack(command.getLength());
            return Optional.of(gameRepository.save(entity));
        } else {
            throw new NullPointerException("The referenced game and/or horse doesn't exist");
        }
    }
}
