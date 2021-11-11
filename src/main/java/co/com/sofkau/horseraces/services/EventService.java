package co.com.sofkau.horseraces.services;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.horseraces.domain.game.commands.CreateGame;
import co.com.sofkau.horseraces.domain.game.commands.CreateHorse;
import co.com.sofkau.horseraces.usecases.CreateGameUseCase;
import co.com.sofkau.horseraces.usecases.CreateHorseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public void createGame(CreateGame createGame){
        var useCase = new CreateGameUseCase();

        //act
        UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(createGame));
    }

    public void createHorse(CreateHorse command) {
        var useCase = new CreateHorseUseCase();

//        //act
//        UseCaseHandler.getInstance()
//                .syncExecutor(useCase, new RequestCommand<>(command));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getGameId().value())
                .syncExecutor(useCase, new RequestCommand<>(command));
    }
}
