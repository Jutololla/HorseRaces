package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

import java.util.ArrayList;

public class GamePrepared extends DomainEvent {
    private final ArrayList<PlayerId> playerIds;

    public GamePrepared(ArrayList<PlayerId> playerIds) {
        super("co.com.sofkau.horseraces.entities.game.events.gameprepared");
        this.playerIds = playerIds;
    }

    public ArrayList<PlayerId> getPlayerIds() {
        return playerIds;
    }
}
