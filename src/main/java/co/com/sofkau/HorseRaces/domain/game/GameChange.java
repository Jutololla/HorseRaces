package co.com.sofkau.HorseRaces.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.HorseRaces.domain.game.events.GameCreated;

public class GameChange extends EventChange {
    public GameChange(Game game){
        apply((GameCreated event)->
                game.dateTime=event.getDateTime());
    }
}
