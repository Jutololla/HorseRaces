package co.com.sofkau.horseraces.domain.game;


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
    protected ArrayList<String> firstPlacePodiumId=new ArrayList<>();
    protected ArrayList<String> secondPlacePodiumId= new ArrayList<>();
    protected ArrayList<String> thirdPlacePodiumId=new ArrayList<>();

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
