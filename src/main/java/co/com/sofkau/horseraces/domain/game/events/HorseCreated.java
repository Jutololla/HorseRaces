package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;

public class HorseCreated extends DomainEvent {
    private final HorseId horseId;
    private final Name name;

    public HorseCreated(HorseId horseId, Name name) {
        super("co.com.sofkau.horseraces.entities.game.events.horsecreated");
        this.horseId = horseId;
        this.name = name;
    }

    public HorseId getHorseId() {
        return horseId;
    }

    public Name getName() {
        return name;
    }
}
