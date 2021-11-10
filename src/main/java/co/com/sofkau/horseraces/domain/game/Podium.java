package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;
import co.com.sofkau.horseraces.domain.game.values.PodiumId;

public class Podium extends Entity<PodiumId> {
    protected PlayerId firstPlace;
    protected PlayerId secondPlace;
    protected PlayerId thirdPlace;

    private Podium(PodiumId entityId) {
        super(entityId);
    }

    protected Podium(PodiumId entityId, PlayerId firstPlace, PlayerId secondPlace, PlayerId thirdPlace) {
        super(entityId);
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
    }

    public static Podium from(PodiumId entityId, PlayerId firstPlace, PlayerId secondPlace, PlayerId thirdPlace) {
        var podium = new Podium(entityId);
        podium.firstPlace = firstPlace;
        podium.secondPlace = secondPlace;
        podium.thirdPlace = thirdPlace;
        return podium;
    }

    public static Podium from() {
        return new Podium(new PodiumId());
    }

    public PlayerId getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(PlayerId firstPlace) {
        this.firstPlace = firstPlace;
    }

    public PlayerId getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(PlayerId secondPlace) {
        this.secondPlace = secondPlace;
    }

    public PlayerId getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(PlayerId thirdPlace) {
        this.thirdPlace = thirdPlace;
    }


}
