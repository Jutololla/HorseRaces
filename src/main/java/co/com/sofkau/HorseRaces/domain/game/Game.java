package co.com.sofkau.HorseRaces.domain.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.HorseRaces.domain.game.events.GameCreated;
import co.com.sofkau.HorseRaces.domain.game.events.TrackAdded;
import co.com.sofkau.HorseRaces.domain.game.values.DateTime;
import co.com.sofkau.HorseRaces.domain.game.values.GameId;
import co.com.sofkau.HorseRaces.domain.game.values.Length;
import co.com.sofkau.HorseRaces.domain.game.values.TrackId;

import java.util.ArrayList;
import java.util.List;

public class Game extends AggregateEvent<GameId> {
    protected ArrayList<Player> players;
    protected Track track;
    protected Podium podium;
    protected DateTime dateTime;


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

    public void addTrack(TrackId trackId, Length length){
        appendChange(new TrackAdded(trackId,length)).apply();
    }
}
