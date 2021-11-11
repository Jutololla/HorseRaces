package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.*;

public class Player extends Entity<PlayerId> {
    protected Name name;
    protected HorseId horseId;
    protected Lane lane;
    protected FirstPlace firstPlace=new FirstPlace(0);
    protected SecondPlace secondPlace= new SecondPlace(0);
    protected ThirdPlace thirdPlace=new ThirdPlace(0);


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

    public void addFirstPlaceVictory(){
        setFirstPlace(new FirstPlace(firstPlace.value()+1));
    }

    public void addSecondPlaceVictory(){
        setSecondPlace(new SecondPlace(secondPlace.value()+1));
    }

    public void addThirdPlaceVictory(){
        setThirdPlace(new ThirdPlace(thirdPlace.value()+1));
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

    public FirstPlace getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(FirstPlace firstPlace) {
        this.firstPlace = firstPlace;
    }

    public SecondPlace getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(SecondPlace secondPlace) {
        this.secondPlace = secondPlace;
    }

    public ThirdPlace getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(ThirdPlace thirdPlace) {
        this.thirdPlace = thirdPlace;
    }
}
