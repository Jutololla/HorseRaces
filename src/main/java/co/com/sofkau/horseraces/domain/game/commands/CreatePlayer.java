package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.Name;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class CreatePlayer extends Command {
    private final GameId gameId;
    private final PlayerId playerId;
    private final Name name;

    public CreatePlayer(GameId gameId, PlayerId playerId, Name name) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.name = name;
    }

    public GameId getGameId() {
        return gameId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Name getName() {
        return name;
    }
}
