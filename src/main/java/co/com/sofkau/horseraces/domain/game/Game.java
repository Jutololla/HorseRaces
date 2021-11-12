package co.com.sofkau.horseraces.domain.game;

import co.com.sofka.business.generic.BusinessException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
@Document("game")
public class Game {
    @Id
    protected String gameId;
    protected Double track;
    protected String   actualState;
    protected HashMap<String,Player> players = new HashMap<>();
    protected ArrayList<Podium> podium = new ArrayList<>();
    protected ArrayList<Lane> lanes = new ArrayList<>();
    protected HashMap<String,Horse> horses = new HashMap<>();


    public Game() {
        this.actualState = "IDLE";
    }

    public Game(String gameId) {
        this.gameId = gameId;
        this.actualState = "IDLE";
    }

    public void setTrack(Double track) throws Exception {
        if(!(track.isInfinite()|| track.isNaN()||track<2000)) {
            this.track = track;
        }
        else{
            throw new Exception("the track length must be a valid value greater than 2000");
        }
    }

    //    public void addTrack(TrackId trackId, Length length)    {
//        appendChange(new TrackAdded(trackId,length)).apply();
//    }
//
//    public void createHorse(HorseId horseId, Name name){
//        appendChange(new HorseCreated(horseId, name)).apply();
//    }
//
//    public void createPlayer(PlayerId playerId, Name name){ appendChange(new PlayerCreated(playerId,name)).apply();}
//
//    public void chooseHorse(HorseId horseId, PlayerId playerId) {appendChange(new HorseChosen(horseId,playerId)).apply();}
//
//    public void prepareGame(List<PlayerId> playerIds) {appendChange(new GamePrepared((ArrayList<PlayerId>) playerIds)).apply();}
//
//    public void runRace(){appendChange(new RaceRun()).apply();}
//
//    public void setPodium(){appendChange(new PodiumSet()).apply();}
//
//    public void doRematch(){appendChange(new RematchDone()).apply();}
//
//    public void cleanLanesAndPodium(){appendChange(new LanesAndPodiumCleaned()).apply();}

}
