package co.com.sofkau.horseraces.domain.game;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Lane {
    protected String playerId;
    protected String horseId;
    protected String horseMod;
    protected Double length;
    protected ArrayList<Double> metersRunned = new ArrayList<>();
    protected Double speed;
    protected String laneNumber;

    public Lane(String playerId, String horseId,String horseMod, Double length, String laneNumber) {
        this.playerId = playerId;
        this.horseId = horseId;
        this.horseMod = horseMod;
        this.length = length;
        this.laneNumber = laneNumber;
    }


    public void run() {
        Double accumulator = 0d;
        while (accumulator < length) {
            int diceValue = (int) (Math.random() * (6 - 1 + 1) + 1); // (int)(Math.random()*(max-min+1)+min); the min value is inclusive while the max value is exclusive
            this.metersRunned.add(horseModApply(horseMod,diceValue * 100d));
            accumulator += diceValue * 100d;
        }
        this.speed = (1d / 6.5) * (accumulator / metersRunned.size());  //velocidad en km/h
        // (1d/x)-> x es un factor de conversion a velocidad, x es inversamente proporcional a la velocidad.
        //en x=8 los caballos tienen velocidad de 50Km/h +-10.
    }

    private Double horseModApply(String horseMod, Double value) {
        switch (horseMod) {
            case ("+10PERCENT"):
                return value * 1.1;
            case ("+50METERS"):
                return value + 50;
            case ("50%PROB_CRIT"): {
                Random rd = new Random();
                return rd.nextBoolean() ? value * 1.2 : value;
            }
            case ("1&6_BONUS"):
                return (value==100||value==600)?value+200:value;
            default:
                return value;

        }

    }


}
