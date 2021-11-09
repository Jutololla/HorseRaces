package co.com.sofkau.HorseRaces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.HorseRaces.domain.game.values.Length;
import co.com.sofkau.HorseRaces.domain.game.values.TrackId;

import java.util.Objects;

public class Track extends Entity<TrackId> {
    protected Length length;

    private Track(TrackId trackId){
        super(trackId);
    }

    protected Track(TrackId entityId, Length length) {
        super(entityId);
        this.length = length;
    }

    public static Track from (TrackId entityId,Length length) {
        var track = new Track(entityId);
        track.length=length;
        return track;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        if (!super.equals(o)) return false;
        Track track = (Track) o;
        return Objects.equals(getLength(), track.getLength());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLength());
    }
}
