package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class Player extends Entity<PlayerId> {
    protected Name name;
    protected HorseId horseId;
    protected Lane lane;


    private Player(PlayerId entityId) {
        super(entityId);
    }

    protected Player(PlayerId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public Player from(PlayerId entityId, Name name) {
        var player = new Player(entityId);
        player.name=name;
        return player;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public HorseId getHorseId() {
        return horseId;
    }

    public void setHorseId(HorseId horseId) {
        this.horseId = horseId;
    }

    public Lane getLane() {
        return lane;
    }

    public void setLane(Lane lane) {
        this.lane = lane;
    }
}
