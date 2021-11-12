package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.ChangePlayerName;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;

import java.util.Optional;

public class ChangePlayerNameUseCase {
    public Object apply(PlayerRepository playerRepository, ChangePlayerName command) {

        Optional<Player> optionalEntity = playerRepository.findById(command.getPlayerId());

        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            entity.setName(command.getName());
            return Optional.of(playerRepository.save(entity));
        } else {
            throw new NullPointerException("The referenced player doesn't exist");
        }
    }
}
