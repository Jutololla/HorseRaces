package co.com.sofkau.horseraces.repositories;

import co.com.sofkau.horseraces.domain.game.Horse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HorseRepository extends MongoRepository<Horse, String> {

}
