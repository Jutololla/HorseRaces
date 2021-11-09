package co.com.sofkau.HorseRaces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.HorseRaces.domain.game.values.GameId;
import co.com.sofkau.HorseRaces.domain.game.values.DateTime;

public class GameCreated extends DomainEvent {
    private final GameId gameId;
    private final DateTime dateTime;

    public GameCreated(GameId gameId, DateTime dateTime) {
        super("co.com.sofkau.HorseRaces.entities.game.events.GameCreated");
        this.gameId = gameId;
        this.dateTime = dateTime;
    }

    public GameId getGameId() {
        return gameId;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}
