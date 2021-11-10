package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetersRunned implements ValueObject<Double> {
    private final Double value;

    public MetersRunned(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetersRunned)) return false;
        MetersRunned that = (MetersRunned) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
