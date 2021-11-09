package co.com.sofkau.HorseRaces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class TrackId extends Identity {
    public TrackId(String uuid) {
        super(uuid);
    }

    public TrackId() {
        super();
    }

    public static TrackId of(String id){
        return new TrackId(id);
    }
}
