package co.com.sofkau.HorseRaces.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.HorseRaces.domain.game.commands.CreateGame;
import co.com.sofkau.HorseRaces.domain.game.events.GameCreated;
import co.com.sofkau.HorseRaces.domain.game.values.DateTime;
import co.com.sofkau.HorseRaces.domain.game.values.GameId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import static org.junit.jupiter.api.Assertions.*;

class CreateGameUseCaseTest {

    @Test
    @DisplayName("Valid arguments test")
    void validArgumentsCase_CreateGame(){
        //arrange
        var command = new CreateGame(
                GameId.of("gameId-xxx"),
                new DateTime(LocalDateTime.of(2022, 9, 30, 15, 45))
        );
        var useCase = new CreateGameUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (GameCreated) events.get(0);
        Assertions.assertEquals("gameId-xxx",event.aggregateRootId());
        Assertions.assertEquals("30-09-2022 15:45", event.getDateTime().toString());


    }

    @Test
    @DisplayName("No Id test")
    void noIdCase_CreateGame(){
        //arrange
        var command = new CreateGame(new GameId(),
                new DateTime(LocalDateTime.of(2022, 9, 30, 15, 45))
        );
        var useCase = new CreateGameUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //assert
        var event = (GameCreated) events.get(0);
        Assertions.assertFalse(event.aggregateRootId().isBlank());
        Assertions.assertEquals("30-09-2022 15:45", event.getDateTime().toString());


    }

}