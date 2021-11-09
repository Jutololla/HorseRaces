package co.com.sofkau.HorseRaces.entities.game;

import co.com.sofka.domain.generic.AggregateRoot;
import co.com.sofkau.HorseRaces.entities.game.values.DateTime;
import co.com.sofkau.HorseRaces.entities.game.values.GameId;

import java.util.ArrayList;

public class Game extends AggregateRoot<GameId> {
    protected ArrayList<Player> players;
    protected Track track;
    protected Podium podium;
    protected DateTime dateTime;


    public Game(GameId entityId) {
        super(entityId);
    }



}
