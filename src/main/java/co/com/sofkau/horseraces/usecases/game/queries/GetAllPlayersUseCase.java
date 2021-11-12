package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PlayerRepository;

public class GetAllPlayersUseCase {

    public Object apply(PlayerRepository playerRepository) {

        return playerRepository.findAll();

    }
}

