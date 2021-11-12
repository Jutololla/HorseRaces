package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.Name;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePlayer{
    private final String gameId;
    private final String playerId;
    private final String name;
}
