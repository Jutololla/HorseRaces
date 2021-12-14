package co.com.sofkau.horseraces.controller;

import co.com.sofkau.horseraces.domain.game.Game;
import co.com.sofkau.horseraces.domain.game.Horse;
import co.com.sofkau.horseraces.domain.game.Player;
import co.com.sofkau.horseraces.domain.game.commands.*;
import co.com.sofkau.horseraces.repositories.GameRepository;
import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;
import co.com.sofkau.horseraces.usecases.game.commands.*;
import co.com.sofkau.horseraces.usecases.game.queries.GetAllHorsesUseCase;
import co.com.sofkau.horseraces.usecases.game.queries.GetAllPlayersUseCase;
import co.com.sofkau.horseraces.usecases.game.queries.GetAllPodiumsUseCase;
import co.com.sofkau.horseraces.usecases.game.queries.GetLastGameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PodiumRepository podiumRepository;

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
        return new ResponseEntity(useCase.apply(playerRepository, horseRepository, command)
                , HttpStatus.OK);
    }

    @PostMapping(value = "addtrack")
    public ResponseEntity<Game> addTrack(@RequestBody AddTrack command) throws Exception {
        var useCase = new AddTrackUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "preparegame")
    public ResponseEntity<Game> prepareGame(@RequestBody PrepareGame command) {
        var useCase = new PrepareGameUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, playerRepository, command)
                , HttpStatus.OK);
    }

    @PostMapping(value = "runrace")
    public ResponseEntity<Game> runRace(@RequestBody RunRace command) {
        var useCase = new RunRaceUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, playerRepository
                , podiumRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "dorematch")
    public ResponseEntity<Game> doRematch(@RequestBody DoRematch command) {
        var useCase = new DoRematchUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, playerRepository
                , podiumRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "cleanlanes")
    public ResponseEntity<Game> cleanLanes(@RequestBody CleanLanes command) {
        var useCase = new CleanLanesUseCase();
        return new ResponseEntity(useCase.apply(gameRepository, playerRepository
                , podiumRepository, command), HttpStatus.OK);
    }

    @GetMapping(value = "gethorses")
    public ResponseEntity<Horse> getHorses() {
        var useCase = new GetAllHorsesUseCase();
        return new ResponseEntity(useCase.apply(horseRepository), HttpStatus.OK);
    }

    @GetMapping(value = "getplayers")
    public ResponseEntity<Horse> getPlayers() {
        var useCase = new GetAllPlayersUseCase();
        return new ResponseEntity(useCase.apply(playerRepository), HttpStatus.OK);
    }

    @GetMapping(value = "getpodiums")
    public ResponseEntity<Horse> getPodiums() {
        var useCase = new GetAllPodiumsUseCase();
        return new ResponseEntity(useCase.apply(podiumRepository), HttpStatus.OK);
    }

    @GetMapping(value = "getlastgame")
    public ResponseEntity<String> getLastGame() {
        var useCase = new GetLastGameUseCase();
        return new ResponseEntity(useCase.apply(gameRepository), HttpStatus.OK);
    }

    @PostMapping(value = "changeplayername")
    public ResponseEntity<Player> changeplayername(@RequestBody ChangePlayerName command) {
        var useCase = new ChangePlayerNameUseCase();
        return new ResponseEntity(useCase.apply(playerRepository, command), HttpStatus.OK);
    }

    @PostMapping(value = "deleteplayer")
    public ResponseEntity<Void> deletePlayer(@RequestBody DeletePlayer command) {
        var useCase = new DeletePlayerUseCase();
        useCase.apply(playerRepository, command);
        return new ResponseEntity(HttpStatus.OK);
    }



}
