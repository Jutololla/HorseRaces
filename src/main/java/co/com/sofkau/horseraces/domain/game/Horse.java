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
public class Horse {
    @Id
    protected String horseId;
    protected String name;

    public Horse(String name) {
        this.name = name;
    }
}
