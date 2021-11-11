package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FirstPlace implements ValueObject<Integer> {
    private final Integer value;

    public FirstPlace(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FirstPlace)) return false;
        FirstPlace that = (FirstPlace) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
