package co.com.sofkau.horseraces.domain.game.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.values.Length;
import co.com.sofkau.horseraces.domain.game.values.TrackId;

public class TrackAdded extends DomainEvent {
    private final TrackId trackId;
    private final Length length;

    public TrackAdded(TrackId trackId, Length length) {
        super("co.com.sofkau.horseraces.entities.game.events.trackadded");
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
