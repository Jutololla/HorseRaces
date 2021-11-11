package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SecondPlace implements ValueObject<Integer> {
    private final Integer value;

    public SecondPlace(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecondPlace)) return false;
        SecondPlace that = (SecondPlace) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
