package co.com.sofkau.horseraces.domain.game.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreatePlayer{
    private final String gameId;
    private final String playerId;
    private final String name;
}
