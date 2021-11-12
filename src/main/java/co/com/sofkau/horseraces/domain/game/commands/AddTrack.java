package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddTrack extends Command {
    private final String gameId;
    private final Double length;
}
