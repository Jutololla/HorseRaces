package co.com.sofkau.horseraces.domain.game.values;

import co.com.sofka.domain.generic.Identity;

public class GameId extends Identity {
    public GameId(String uuid) {
        super(uuid);
    }

    public GameId() {
        super();
    }

    public static GameId of(String id){
        return new GameId(id);
    }

}
