package co.com.sofkau.horseraces.domain.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
