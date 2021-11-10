package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.horseraces.domain.game.events.*;
import co.com.sofkau.horseraces.domain.game.utils.LaneComparator;
import co.com.sofkau.horseraces.domain.game.values.ActualState;
import co.com.sofkau.horseraces.domain.game.values.LaneId;
import co.com.sofkau.horseraces.domain.game.values.MetersRunned;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

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
            for (PlayerId iterable:event.getPlayerIds()) {
                game.lanes.add(Lane.from(new LaneId(),iterable,game.track.length));
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
        });



    }
}
