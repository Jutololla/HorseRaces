package co.com.sofkau.HorseRaces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.HorseRaces.domain.game.values.GameId;
import co.com.sofkau.HorseRaces.domain.game.values.DateTime;

public class CreateGame extends Command {
    private final GameId gameId;
    private final DateTime dateTime;

    public CreateGame(GameId gameId, DateTime dateTime) {
        this.gameId = gameId;
        this.dateTime = dateTime;
    }

    public GameId getGameId() {
        return gameId;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}
