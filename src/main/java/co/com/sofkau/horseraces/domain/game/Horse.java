package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;

import java.util.Objects;

public class Horse extends Entity<HorseId> {
    protected Name name;

    private Horse(HorseId entityId) {
        super(entityId);
    }

    protected Horse(HorseId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public static Horse from(HorseId horseId,Name name) {
        var horse = new Horse(horseId);
        horse.name=name;
        return horse;
    }

    public Name name() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
