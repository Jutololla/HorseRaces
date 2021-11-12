package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.HorseId;
import co.com.sofkau.horseraces.domain.game.values.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("horse")
public class Horse {
    @Id
    protected String horseId;
    protected String name;

    public Horse(String name) {
        this.name = name;
    }
}
