package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Speed implements ValueObject<Double> {
    private final Double value;

    public Speed(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Speed)) return false;
        Speed speed = (Speed) o;
        return Objects.equals(value, speed.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
