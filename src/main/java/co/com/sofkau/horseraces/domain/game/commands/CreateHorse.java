package co.com.sofkau.horseraces.domain.game.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class CreateHorse{
    private final String horseId;
    private final String name;
}
