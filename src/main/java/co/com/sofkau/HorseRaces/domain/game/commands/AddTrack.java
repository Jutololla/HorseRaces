package co.com.sofkau.HorseRaces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.HorseRaces.domain.game.values.GameId;
import co.com.sofkau.HorseRaces.domain.game.values.Length;
import co.com.sofkau.HorseRaces.domain.game.values.TrackId;

public class AddTrack extends Command {
    private final GameId gameId;
    private final TrackId trackId;
    private final Length length;

    public AddTrack(GameId gameId, TrackId trackId, Length length) {
        this.gameId = gameId;
        this.trackId = trackId;
        this.length = length;
    }

    public GameId getGameId() {
        return gameId;
    }

    public TrackId getTrackId() {
        return trackId;
    }

    public Length getLength() {
        return length;
    }
}
