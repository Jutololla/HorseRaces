package co.com.sofkau.horseraces.repositories;

import co.com.sofkau.horseraces.domain.game.Podium;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PodiumRepository extends MongoRepository<Podium,String> {
}
