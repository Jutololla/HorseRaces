package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;

public class SetPodium extends Command {
    private final GameId gameId;

    public SetPodium(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
