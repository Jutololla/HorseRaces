package co.com.sofkau.horseraces.repositories;

import co.com.sofkau.horseraces.domain.game.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game,String> {
}
