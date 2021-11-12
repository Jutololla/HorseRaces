package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("player")
public class Player{
    @Id
    protected String playerId;
    protected String name;
    protected String horseId;
    protected Lane lane;
    protected ArrayList<Podium> firstPlace=new ArrayList<>();
    protected ArrayList<Podium> secondPlace= new ArrayList<>();
    protected ArrayList<Podium> thirdPlace=new ArrayList<>();

    public Player(String playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

//    public void addFirstPlaceVictory(){
//        setFirstPlace(new FirstPlace(firstPlace.value()+1));
//    }
//
//    public void addSecondPlaceVictory(){
//        setSecondPlace(new SecondPlace(secondPlace.value()+1));
//    }
//
//    public void addThirdPlaceVictory(){
//        setThirdPlace(new ThirdPlace(thirdPlace.value()+1));
//    }


}
