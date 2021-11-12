package co.com.sofkau.horseraces.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("horse")
public class Horse{
    @Id
    protected String horseId;
    protected String name;
    protected String horseMod;

    public Horse(String name, String horseMod) {
        this.name = name;
        this.horseMod = horseMod;
    }
}
