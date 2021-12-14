package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofkau.horseraces.repositories.GameRepository;

public class GetLastGameUseCase {
    public Object apply(GameRepository gameRepository) {

        var games= gameRepository.findAll();
        return games.get(games.size()-1).getGameId();

    }
}

