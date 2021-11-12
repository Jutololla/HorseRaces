package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddTrackUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test aditton with valid arguments")
    void validArguments_addTrack(){
//        //arrange
//        var command = new AddTrack(
//                new GameId("Game001"),
//                new TrackId("xxxxxx1"),
//                new Length(150d)  );
//
//        var useCase = new AddTrackUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (TrackAdded)events.get(0);
//
//        //Assert
//        Assertions.assertEquals("xxxxxx1", event.getTrackId().value());
//        Assertions.assertEquals(150d, event.getLength().value());



    }



}