package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePlayerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test creation with valid arguments")
    void validArguments_createPlayer(){
//        //arrange
//        var command = new CreatePlayer(
//                new GameId("Game001"),
//                new PlayerId("xxxxxx1"),
//                new Name("Pepito")  );
//
//        var useCase = new CreatePlayerUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (PlayerCreated)events.get(0);
//
//        //Assert
//        Assertions.assertEquals("xxxxxx1", event.getPlayerId().value());
//        Assertions.assertEquals("Pepito", event.getName().value());



    }


}