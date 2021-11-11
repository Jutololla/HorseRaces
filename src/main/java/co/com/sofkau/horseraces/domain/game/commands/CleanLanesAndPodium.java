package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;

public class CleanLanesAndPodium extends Command {
    private final GameId gameId;

    public CleanLanesAndPodium(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
