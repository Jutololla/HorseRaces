package co.com.sofkau.HorseRaces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class HorseId extends Identity {
    public HorseId(String uuid) {
        super(uuid);
    }

    public HorseId() {
    }

    public HorseId of(String uuid) {
        return new HorseId(uuid);
    }

}
