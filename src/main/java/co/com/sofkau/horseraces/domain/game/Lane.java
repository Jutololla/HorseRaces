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
    protected LaneNumber laneNumber;

    private Lane(LaneId entityId) {
        super(entityId);
    }

    protected Lane(LaneId entityId, PlayerId playerId, Length length) {
        super(entityId);
        this.playerId = playerId;
        this.length = length;
    }

    public static Lane from (LaneId entityId, PlayerId playerId, Length length, LaneNumber laneNumber) {
        var lane = new Lane(entityId);
        lane.playerId=playerId;
        lane.length=length;
        lane.laneNumber=laneNumber;
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

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void run(){
        Double acumulator = 0d;
        while(acumulator<length.value()) {
            int diceValue = (int) (Math.random() * (6-1+1)+1); // (int)(Math.random()*(max-min+1)+min); the min value is inclusive while the max value is exclusive
            this.metersRunned.add(new MetersRunned(diceValue * 100d));
            acumulator += diceValue * 100d;
        }
        this.speed=new Speed((1d/6.5)*(acumulator/metersRunned.size()));  //velocidad en km/h
        // (1d/x)-> x es un factor de conversion a velocidad, x es inversamente proporcional a la velocidad.
        //en x=8 los caballos tienen velocidad de 50Km/h +-10.
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
