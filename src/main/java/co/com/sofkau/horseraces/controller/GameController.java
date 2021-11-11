package co.com.sofkau.horseraces.controller;

import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private EventService eventService;

    @PostMapping(value = "api/creategame")
    public void createGame(@RequestBody CreateGame createGame) {
        eventService.createGame(createGame);
    }

    @PostMapping(value = "api/createhorse")
    public void createHorse(@RequestBody CreateHorse createHorse) {
        eventService.createHorse(createHorse);
    }
}
