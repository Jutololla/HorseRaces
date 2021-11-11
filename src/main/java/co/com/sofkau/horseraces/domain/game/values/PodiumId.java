package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class PodiumId extends Identity {
    public PodiumId() {
    }

    public PodiumId(String uuid) {
        super(uuid);
    }
    public PodiumId of(String uuid) {
        return new PodiumId(uuid);
    }


}
