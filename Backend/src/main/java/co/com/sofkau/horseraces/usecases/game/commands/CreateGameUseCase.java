package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.repositories.GameRepository;

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
