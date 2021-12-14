package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.domain.game.commands.CreatePlayer;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

import java.util.Objects;
import java.util.Optional;

public class CreatePlayerUseCase{
    public Object apply(PlayerRepository repository, CreatePlayer command) {
        Player player;
        if(Objects.isNull(command.getPlayerId())||command.getPlayerId().isEmpty()) {
            player = repository.save(new Player(command.getName()));
        }
        else{
            player = repository.save(new Player(command.getPlayerId(),command.getName()));
        }
        return Optional.of(player.getPlayerId());
    }
}
