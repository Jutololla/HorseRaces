package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.commands.CreatePlayer;
import co.com.sofkau.horseraces.domain.game.events.GameCreated;
import co.com.sofkau.horseraces.domain.game.events.PlayerCreated;
import co.com.sofkau.horseraces.domain.game.values.*;
import co.com.sofkau.horseraces.usecases.game.commands.CreatePlayerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreatePlayerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test creation with valid arguments")
    void validArguments_createPlayer(){
        //arrange
        var command = new CreatePlayer(
                new GameId("Game001"),
                new PlayerId("xxxxxx1"),
                new Name("Pepito")  );

        var useCase = new CreatePlayerUseCase();
        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getGameId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (PlayerCreated)events.get(0);

        //Assert
        Assertions.assertEquals("xxxxxx1", event.getPlayerId().value());
        Assertions.assertEquals("Pepito", event.getName().value());



    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new GameCreated(GameId.of("Game001") ,new DateTime()));
    }

}