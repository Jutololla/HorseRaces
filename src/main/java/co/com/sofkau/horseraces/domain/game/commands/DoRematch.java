package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;

public class DoRematch extends Command {
    private final GameId gameId;

    public DoRematch(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
