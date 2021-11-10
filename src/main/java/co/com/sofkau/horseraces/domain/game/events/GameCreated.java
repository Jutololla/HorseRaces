package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.DateTime;

public class GameCreated extends DomainEvent {
    private final GameId gameId;
    private final DateTime dateTime;

    public GameCreated(GameId gameId, DateTime dateTime) {
        super("co.com.sofkau.horseraces.entities.game.events.gamecreated");
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
