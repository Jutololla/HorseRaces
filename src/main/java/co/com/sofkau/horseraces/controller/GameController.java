package co.com.sofkau.horseraces.controller;

import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.*;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.usecases.game.commands.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping(value = "creategame")
    public ResponseEntity<String> createGame(@RequestBody CreateGame command) {
        var useCase = new CreateGameUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, command), HttpStatus.CREATED);
    }

    @PostMapping(value = "createhorse")
    public ResponseEntity<String> createHorse(@RequestBody CreateHorse command) {
        var useCase = new CreateHorseUseCase();
        return new ResponseEntity(useCase.apply(horseRepository, command), HttpStatus.CREATED);
    }

    @PostMapping(value = "createplayer")
    public ResponseEntity<String> createPlayer(@RequestBody CreatePlayer command) {
        var useCase = new CreatePlayerUseCase();
        return new ResponseEntity(useCase.apply(playerRepository, command), HttpStatus.CREATED);
    }

    @PostMapping(value = "choosehorse")
    public ResponseEntity<Player> chooseHorse(@RequestBody ChooseHorse command) {
        var useCase = new ChooseHorseUseCase();
        return new ResponseEntity(useCase.apply(playerRepository, horseRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "addtrack")
    public ResponseEntity<Game> addTrack(@RequestBody AddTrack command) throws Exception {
        var useCase = new AddTrackUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "preparegame")
    public ResponseEntity<Game> prepareGame(@RequestBody PrepareGame command) {
        var useCase = new PrepareGameUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, playerRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "runrace")
    public ResponseEntity<Game> runRace(@RequestBody RunRace command) {
        var useCase = new RunRaceUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, command), HttpStatus.OK);
    }
}
