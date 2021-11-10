package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

import java.util.ArrayList;

public class PrepareGame extends Command {
    private final GameId gameId;
    private final ArrayList<PlayerId> playerIds;

    public PrepareGame(GameId gameId, ArrayList<PlayerId> playerIds) {
        this.gameId = gameId;
        this.playerIds = playerIds;
    }

    public GameId getGameId() {
        return gameId;
    }

    public ArrayList<PlayerId> getPlayerIds() {
        return playerIds;
    }
}
