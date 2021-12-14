package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.ChangePlayerName;
import co.com.sofkau.horseraces.domain.game.commands.DeletePlayer;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

import java.util.Optional;

public class DeletePlayerUseCase {
    public void apply(PlayerRepository playerRepository, DeletePlayer command) {

        Optional<Player> optionalEntity = playerRepository.findById(command.getPlayerId());

        if (optionalEntity.isPresent()) {
            var entity = optionalEntity.get();
            playerRepository.delete(entity);
        } else {
            throw new NullPointerException("The referenced player doesn't exist");
        }
    }
}
