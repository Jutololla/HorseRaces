package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.*;

import java.util.ArrayList;
import java.util.Objects;

public class Lane extends Entity<LaneId> {
    protected PlayerId playerId;
    protected Length length;
    protected ArrayList<MetersRunned> metersRunned = new ArrayList<>();
    protected Speed speed;

    private Lane(LaneId entityId) {
        super(entityId);
    }

    protected Lane(LaneId entityId, PlayerId playerId, Length length) {
        super(entityId);
        this.playerId = playerId;
        this.length = length;
    }

    public static Lane from (LaneId entityId, PlayerId playerId, Length length) {
        var lane = new Lane(entityId);
        lane.playerId=playerId;
        lane.length=length;
        return lane;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    public Length getLength() {
        return length;
    }

    public void setLength(Length length) {
        this.length = length;
    }

    public ArrayList<MetersRunned> getMetersRunned() {
        return metersRunned;
    }

    public void setMetersRunned(ArrayList<MetersRunned> metersRunned) {
        this.metersRunned = metersRunned;
    }

    public void run(){
        Double acumulator = 0d;
        while(acumulator<length.value()) {
            int diceValue = (int) (Math.random() * (6-1+1)+1); // (int)(Math.random()*(max-min+1)+min); the min value is inclusive while the max value is exclusive
            this.metersRunned.add(new MetersRunned(diceValue * 100d));
            acumulator += diceValue * 100d;
        }
        this.speed=new Speed((1d/6)*(acumulator/metersRunned.size()));  //velocidad en km/h
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lane)) return false;
        if (!super.equals(o)) return false;
        Lane lane = (Lane) o;
        return Objects.equals(getPlayerId(), lane.getPlayerId()) && Objects.equals(getLength(), lane.getLength()) && Objects.equals(getMetersRunned(), lane.getMetersRunned());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPlayerId(), getLength(), getMetersRunned());
    }
}
