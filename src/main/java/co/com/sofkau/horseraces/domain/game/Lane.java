package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.LaneId;
import co.com.sofkau.horseraces.domain.game.values.Length;
import co.com.sofkau.horseraces.domain.game.values.MetersRunned;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

import java.util.Objects;

public class Lane extends Entity<LaneId> {
    protected PlayerId playerId;
    protected Length length;
    protected MetersRunned metersRunned;

    private Lane(LaneId entityId) {
        super(entityId);
    }

    protected Lane(LaneId entityId, PlayerId playerId, Length length, MetersRunned metersRunned) {
        super(entityId);
        this.playerId = playerId;
        this.length = length;
        this.metersRunned = metersRunned;
    }

    public static Lane from (LaneId entityId, PlayerId playerId, Length length, MetersRunned metersRunned) {
        var lane = new Lane(entityId);
        lane.playerId=playerId;
        lane.length=length;
        lane.metersRunned=metersRunned;
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

    public MetersRunned getMetersRunned() {
        return metersRunned;
    }

    public void setMetersRunned(MetersRunned metersRunned) {
        this.metersRunned = metersRunned;
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
