package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PodiumSet extends DomainEvent {
    public PodiumSet() {
        super("co.com.sofkau.horseraces.entities.game.events.podiumset");
    }
}
