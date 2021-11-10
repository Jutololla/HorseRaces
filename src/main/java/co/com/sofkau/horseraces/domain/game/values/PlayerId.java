package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class PlayerId  extends Identity {
    public PlayerId(String uuid) {
        super(uuid);
    }

    public PlayerId() {
        super();
    }

    public static PlayerId of(String id){
        return new PlayerId(id);
    }
}

