package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LaneNumber implements ValueObject<String> {
    private final String value;

    public LaneNumber(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaneNumber)) return false;
        LaneNumber that = (LaneNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
