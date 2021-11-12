package co.com.sofkau.horseraces.repositories;

import co.com.sofkau.horseraces.domain.game.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player,String> {
}
