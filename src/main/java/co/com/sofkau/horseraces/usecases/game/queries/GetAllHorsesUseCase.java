package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofkau.horseraces.repositories.HorseRepository;

public class GetAllHorsesUseCase {
    public Object apply(HorseRepository horseRepository) {

    return horseRepository.findAll();

    }
}
