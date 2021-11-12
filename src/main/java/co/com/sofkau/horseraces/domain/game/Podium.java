package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.domain.generic.Entity;
import co.com.sofkau.horseraces.domain.game.values.DateTime;
import co.com.sofkau.horseraces.domain.game.values.PlayerId;
import co.com.sofkau.horseraces.domain.game.values.PodiumId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
@AllArgsConstructor
@Getter
@Setter
@Document
public class Podium{
    @Id
    protected String podiumId;
    protected String firstPlacePlayerId;
    protected String secondPlacePlayerId;
    protected String thirdPlacePlayerId;
    protected Double track;
    protected LocalDateTime dateTime;
    protected String gameId;
    protected ArrayList<Lane> lanes = new ArrayList<>();

    public Podium() {
        this.dateTime = LocalDateTime.now();
    }

}
