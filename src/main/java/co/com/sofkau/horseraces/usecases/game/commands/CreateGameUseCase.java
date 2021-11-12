package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.GameBehavior;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.repositories.GameRepository;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class CreateGameUseCase{

    public Object apply(GameRepository repository, CreateGame command) {
        Game game;
        if(Objects.isNull(command.getGameId())||command.getGameId().isEmpty()) {
            game = repository.save(new Game());
        }
        else{
            game = repository.save(new Game(command.getGameId()));
        }
        return Optional.of(game.getGameId());
    }
}
