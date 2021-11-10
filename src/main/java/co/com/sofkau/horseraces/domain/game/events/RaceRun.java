package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;

public class RaceRun extends DomainEvent {
    public RaceRun() {
        super("co.com.sofkau.horseraces.entities.game.events.racerun");
    }
}
