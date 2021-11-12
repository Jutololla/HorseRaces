package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
public class Lane{
    protected String playerId;
    protected String horseId;
    protected Double length;
    protected ArrayList<Double> metersRunned = new ArrayList<>();
    protected Double speed;
    protected String laneNumber;

    public Lane(String playerId, String horseId, Double length, String laneNumber) {
        this.playerId = playerId;
        this.horseId = horseId;
        this.length = length;
        this.laneNumber = laneNumber;
    }

    //    public void run(){
//        Double acumulator = 0d;
//        while(acumulator<length.value()) {
//            int diceValue = (int) (Math.random() * (6-1+1)+1); // (int)(Math.random()*(max-min+1)+min); the min value is inclusive while the max value is exclusive
//            this.metersRunned.add(new MetersRunned(diceValue * 100d));
//            acumulator += diceValue * 100d;
//        }
//        this.speed=new Speed((1d/6.5)*(acumulator/metersRunned.size()));  //velocidad en km/h
//        // (1d/x)-> x es un factor de conversion a velocidad, x es inversamente proporcional a la velocidad.
//        //en x=8 los caballos tienen velocidad de 50Km/h +-10.
//    }


}
