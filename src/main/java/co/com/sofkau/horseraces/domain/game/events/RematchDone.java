package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;

public class RematchDone extends DomainEvent {
    public RematchDone() {
        super("co.com.sofkau.horseraces.entities.game.events.rematchdone");
    }
}
