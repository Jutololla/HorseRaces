package co.com.sofkau.HorseRaces.domain.game.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime implements ValueObject<Date> {
    private final LocalDateTime value;

    public DateTime() {
        this.value=LocalDateTime.now();
    }

    public DateTime(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public Date value() {
        return null;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateTimeFormatter.format(this.value);
    }
}
