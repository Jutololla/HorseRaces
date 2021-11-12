package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofkau.horseraces.repositories.GameRepository;

public class GetLastGameUseCase {
    public Object apply(GameRepository gameRepository) {

        return gameRepository.findAll().get(0).getGameId();

    }
}

