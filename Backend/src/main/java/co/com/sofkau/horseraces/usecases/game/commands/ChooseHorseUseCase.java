package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.ChooseHorse;
import co.com.sofkau.horseraces.domain.game.commands.CreatePlayer;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

import java.util.Objects;
import java.util.Optional;

public class ChooseHorseUseCase {
    public Object apply(PlayerRepository playerRepository, HorseRepository horseRepository, ChooseHorse command) {

        Optional<Horse> optionalHorse = horseRepository.findById(command.getHorseId());
        Optional<Player> optionalEntity = playerRepository.findById(command.getPlayerId());

        if (optionalEntity.isPresent()&&optionalHorse.isPresent()) {
            var entity = optionalEntity.get();
            entity.setHorseId(command.getHorseId());
            entity.setHorseMod(optionalHorse.get().getHorseMod());
            return Optional.of(playerRepository.save(entity));
        } else {
            throw new NullPointerException("The referenced player and/or horse doesn't exist");
        }
    }
}
