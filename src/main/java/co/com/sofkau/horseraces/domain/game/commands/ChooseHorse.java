package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;


@Getter
public class ChooseHorse extends Command {
    private final String horseId;
    private final String playerId;

    public ChooseHorse(String horseId, String playerId) {
        this.horseId = Objects.requireNonNull(horseId);
        this.playerId = Objects.requireNonNull(playerId);
    }

}
