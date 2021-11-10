package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;

public class CreateHorse extends Command {
    private final GameId gameId;
    private final HorseId horseId;
    private final Name name;

    public CreateHorse(GameId gameId, HorseId horseId, Name name) {
        this.gameId = gameId;
        this.horseId = horseId;
        this.name = name;
    }

    public GameId getGameId() {
        return gameId;
    }

    public HorseId getHorseId() {
        return horseId;
    }

    public Name getName() {
        return name;
    }
}
