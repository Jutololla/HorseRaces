package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.Name;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class PlayerCreated extends DomainEvent {
    private final PlayerId playerId;
    private final Name name;

    public PlayerCreated(PlayerId playerId, Name name) {
        super("co.com.sofkau.horseraces.entities.game.events.playercreated");
        this.playerId = playerId;
        this.name = name;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Name getName() {
        return name;
    }
}
