package co.com.sofkau.horseraces.usecases.game.commands;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.HorseRepository;

import java.util.Objects;
import java.util.Optional;

public class CreateHorseUseCase{

    public Object apply(HorseRepository repository, CreateHorse command) {
        Horse horse;
        if(Objects.isNull(command.getHorseId())||command.getHorseId().isEmpty()) {
            horse = repository.save(new Horse(command.getName()));
        }
        else{
            horse = repository.save(new Horse(command.getHorseId(),command.getName()));
        }
        return Optional.of(horse.getHorseId());
    }
}

