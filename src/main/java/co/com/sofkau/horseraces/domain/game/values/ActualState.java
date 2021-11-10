package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActualState implements ValueObject<String> {
    private final String value;

    public ActualState(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String value() {
        return value;
    }

}
