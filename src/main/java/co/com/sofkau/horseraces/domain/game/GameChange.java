package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.horseraces.domain.game.events.*;
import co.com.sofkau.horseraces.domain.game.utils.LaneComparator;
import co.com.sofkau.horseraces.domain.game.values.*;

import java.util.ArrayList;
import java.util.Collections;

public class GameChange extends EventChange {

    public GameChange(Game game) {
        apply((GameCreated event) -> {
            game.dateTime = event.getDateTime();
            game.actualState= new ActualState("IDLE");
        });


        apply((TrackAdded event) -> {
            game.track = new Track(
                    event.getTrackId(),
                    event.getLength()
            );
            //<IDLE,IDLE>
        });

        apply((HorseCreated event) -> {
            game.horses.add(new Horse(
                    event.getHorseId(),
                    event.getName()
            ));
            //<IDLE,IDLE>
        });

        apply((PlayerCreated event) -> {
            game.players.put(event.getPlayerId().value(),
                    new Player(
                            event.getPlayerId(),
                            event.getName()
                    ));
            //<IDLE,IDLE>
        });

        apply((HorseChosen event) -> {
            if (game.players.containsKey(event.getPlayerId().value())) {
                game.players.get(event.getPlayerId().value())
                        .setHorseId(event.getHorseId());
            } else {
                throw new NullPointerException("The referenced player doesn't exist");
            }
            //<IDLE,IDLE>
        });

        apply((GamePrepared event)->{
            int counter = 1;
            for (PlayerId iterable:event.getPlayerIds()) {
                game.lanes.add(Lane.from(new LaneId(),iterable,game.track.length,new LaneNumber(String.valueOf(counter))));
                counter+=1;
            }
            game.actualState= new ActualState("PREPARED");
        });

        apply((RaceRun event)->{
            game.actualState= new ActualState("RUNNING");
            for (Lane lane: game.lanes) {
                lane.run();
            }
        });

        apply((PodiumSet event)->{
            game.actualState= new ActualState("FINISHED");
            Collections.sort(game.lanes, new LaneComparator());
            game.podium.setFirstPlace(game.lanes.get(0).playerId);
            game.podium.setSecondPlace(game.lanes.get(1).playerId);
            game.podium.setThirdPlace(game.lanes.get(2).playerId);
            game.players.get(game.podium.getFirstPlace().value()).addFirstPlaceVictory();
            game.players.get(game.podium.getSecondPlace().value()).addSecondPlaceVictory();
            game.players.get(game.podium.getThirdPlace().value()).addThirdPlaceVictory();
        });

        apply((RematchDone event)->{
            game.actualState= new ActualState("RUNNING");
            cleanVariables(game,false);
            for (Lane lane: game.lanes) {
                lane.run();
            }
        });

        apply((LanesAndPodiumCleaned event)->{
            game.actualState= new ActualState("IDLE");
            cleanVariables(game,true);
        });



    }

    private void cleanVariables(Game game, Boolean cleanHorses) {
        for (Lane lane : game.lanes) {
            if(cleanHorses){
            game.players.get(lane.playerId.value()).setHorseId(null);}
            lane.metersRunned.clear();
            lane.setSpeed(new Speed(0d));
        }
        game.podium = Podium.from();
    }
}
