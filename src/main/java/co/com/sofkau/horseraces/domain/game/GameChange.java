package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofkau.horseraces.domain.game.events.*;
import co.com.sofkau.horseraces.domain.game.values.ActualState;
import co.com.sofkau.horseraces.domain.game.values.LaneId;
import co.com.sofkau.horseraces.domain.game.values.MetersRunned;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class GameChange extends EventChange {

    public GameChange(Game game) {
        apply((GameCreated event) ->
                game.dateTime = event.getDateTime());


        apply((TrackAdded event) -> {
            game.track = new Track(
                    event.getTrackId(),
                    event.getLength()
            );
        });

        apply((HorseCreated event) -> {
            game.horses.add(new Horse(
                    event.getHorseId(),
                    event.getName()
            ));
        });

        apply((PlayerCreated event) -> {
            game.players.put(event.getPlayerId().value(),
                    new Player(
                            event.getPlayerId(),
                            event.getName()
                    ));
        });

        apply((HorseChosen event) -> {
            if (game.players.containsKey(event.getPlayerId().value())) {
                game.players.get(event.getPlayerId().value())
                        .setHorseId(event.getHorseId());
            } else {
                throw new NullPointerException("The referenced player doesn't exist");
            }
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

    }
}
