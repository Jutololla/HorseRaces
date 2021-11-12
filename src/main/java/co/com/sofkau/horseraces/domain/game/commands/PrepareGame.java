package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
@AllArgsConstructor
@Getter
public class PrepareGame extends Command {
    private final String gameId;
    private final ArrayList<String> playerIds;


}
