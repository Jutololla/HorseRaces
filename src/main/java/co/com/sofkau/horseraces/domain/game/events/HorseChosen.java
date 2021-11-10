package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class HorseChosen extends DomainEvent {
    private final HorseId horseId;
    private final PlayerId playerId;

    public HorseChosen(HorseId horseId, PlayerId playerId) {
        super("co.com.sofkau.horseraces.entities.game.events.horsechosen");
        this.horseId = horseId;
        this.playerId = playerId;
    }

    public HorseId getHorseId() {
        return horseId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }
}
