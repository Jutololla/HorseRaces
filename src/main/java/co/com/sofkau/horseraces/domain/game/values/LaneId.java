package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class LaneId extends Identity {
    public LaneId(String uuid) {
        super(uuid);
    }

    public LaneId() {
    }

    public LaneId of(String uuid) {
        return new LaneId(uuid);
    }
}
