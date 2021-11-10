package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.events.*;
import co.com.sofkau.horseraces.domain.game.values.*;

import java.util.*;

public class Game extends AggregateEvent<GameId> {
    protected HashMap<String,Player> players = new HashMap<>();
    protected Track track;
    protected Podium podium;
    protected DateTime dateTime;
    protected ActualState   actualState;
    protected ArrayList<Lane> lanes = new ArrayList<>();
    protected HashSet<Horse> horses = new HashSet<>();


    public Game(GameId entityId, DateTime dateTime) {
        super(entityId);
        appendChange(new GameCreated(entityId, dateTime)).apply();
    }

    private Game(GameId gameId){
        super(gameId);
        subscribe(new GameChange(this));
    }

    public static Game from(GameId gameId, List<DomainEvent> events){
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        return game;
    }

    public DateTime DateTime() {
        return dateTime;
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public Track getTrack() {
        return track;
    }

    public Podium getPodium() {
        return podium;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public ActualState getActualState() {
        return actualState;
    }

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

    public HashSet<Horse> getHorses() {
        return horses;
    }

    public void addTrack(TrackId trackId, Length length)    {
        appendChange(new TrackAdded(trackId,length)).apply();
    }

    public void createHorse(HorseId horseId, Name name){
        appendChange(new HorseCreated(horseId, name)).apply();
    }

    public void createPlayer(PlayerId playerId, Name name){ appendChange(new PlayerCreated(playerId,name)).apply();}

    public void chooseHorse(HorseId horseId, PlayerId playerId) {appendChange(new HorseChosen(horseId,playerId)).apply();}

    public void prepareGame(List<PlayerId> playerIds) {appendChange(new GamePrepared((ArrayList<PlayerId>) playerIds)).apply();}

    public void runRace(){appendChange(new RaceRun()).apply();}

}
