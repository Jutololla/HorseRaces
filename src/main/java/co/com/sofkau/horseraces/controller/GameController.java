package co.com.sofkau.horseraces.controller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.queries.GetHorses;
import co.com.sofkau.horseraces.services.EventService;
import co.com.sofkau.horseraces.usecases.game.commands.CreateGameUseCase;
import co.com.sofkau.horseraces.usecases.game.commands.CreateHorseUseCase;
import co.com.sofkau.horseraces.usecases.game.queries.GetHorsesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private EventService eventService;

    @PostMapping(value = "api/creategame")
    public void createGame(@RequestBody CreateGame command) {
        var useCase = new CreateGameUseCase();
        //act
        UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command));
    }

    @PostMapping(value = "api/createhorse")
    public void createHorse(@RequestBody CreateHorse command) {
        var useCase = new CreateHorseUseCase();
        UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getGameId().value())
                .syncExecutor(useCase, new RequestCommand<>(command));
    }

    @PostMapping(value = "api/gethorses")
    public Optional<ResponseEvents> getHorses(@RequestBody GetHorses command) {
        var useCase = new GetHorsesUseCase();
        return UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getGameId().value())
                .syncExecutor(useCase, new RequestCommand<>(command));
    }
}
