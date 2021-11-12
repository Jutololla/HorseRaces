package co.com.sofkau.horseraces.domain.game.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateHorse{
    private final String horseId;
    private final String name;
}
