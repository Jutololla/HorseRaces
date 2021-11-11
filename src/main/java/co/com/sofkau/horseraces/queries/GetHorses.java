package co.com.sofkau.horseraces.queries;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;

public class GetHorses extends Command {
    private final GameId gameId;

    public GetHorses(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
