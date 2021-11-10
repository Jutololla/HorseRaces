package co.com.sofkau.HorseRaces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Length implements ValueObject<Double> {
    private final Double value;

    public Length(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length length = (Length) o;
        return Objects.equals(value, length.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
