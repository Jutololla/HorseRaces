package co.com.sofkau.HorseRaces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.HorseRaces.domain.game.values.Length;
import co.com.sofkau.HorseRaces.domain.game.values.TrackId;

public class TrackAdded extends DomainEvent {
    private final TrackId trackId;
    private final Length length;

    public TrackAdded(TrackId trackId, Length length) {
        super("co.com.sofkau.HorseRaces.entities.game.events.TrackAdded");
        this.trackId = trackId;
        this.length = length;
    }

    public TrackId getTrackId() {
        return trackId;
    }

    public Length getLength() {
        return length;
    }
}
