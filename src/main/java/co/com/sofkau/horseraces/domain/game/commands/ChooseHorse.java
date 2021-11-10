package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;

public class ChooseHorse extends Command {
    private final GameId gameId;
    private final HorseId horseId;
    private final PlayerId playerId;

    public ChooseHorse(GameId gameId, HorseId horseId, PlayerId playerId) {
        this.gameId = gameId;
        this.horseId = horseId;
        this.playerId = playerId;
    }

    public GameId getGameId() {
        return gameId;
    }

    public HorseId getHorseId() {
        return horseId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }
}
