package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.commands.AddTrack;
import co.com.sofkau.horseraces.domain.game.events.GameCreated;
import co.com.sofkau.horseraces.domain.game.events.TrackAdded;
import co.com.sofkau.horseraces.domain.game.values.DateTime;
import co.com.sofkau.horseraces.domain.game.values.GameId;
import co.com.sofkau.horseraces.domain.game.values.Length;
import co.com.sofkau.horseraces.domain.game.values.TrackId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddTrackUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test aditton with valid arguments")
    void validArguments_addTrack(){
        //arrange
        var command = new AddTrack(
                new GameId("Game001"),
                new TrackId("xxxxxx1"),
                new Length(150d)  );

        var useCase = new AddTrackUseCase();
        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getGameId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (TrackAdded)events.get(0);

        //Assert
        Assertions.assertEquals("xxxxxx1", event.getTrackId().value());
        Assertions.assertEquals(150d, event.getLength().value());



    }

    private List<DomainEvent> EventRestore() {
        return List.of(
                new GameCreated(GameId.of("Game001") ,new DateTime()));
    }

}