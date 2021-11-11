package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;

public class LanesAndPodiumCleaned extends DomainEvent {
    public LanesAndPodiumCleaned() {
        super("co.com.sofkau.horseraces.entities.game.events.cleandone");
    }
}
