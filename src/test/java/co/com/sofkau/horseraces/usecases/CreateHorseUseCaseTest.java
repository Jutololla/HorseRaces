package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CreateHorseUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test creation with valid arguments")
    void validArguments_createHorse(){
//        //arrange
//        var command = new CreateHorse(
//                new GameId("Game001"),
//                new HorseId("xxxxxx1"),
//                new Name("Guadalupe")  );
//
//        var useCase = new CreateHorseUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (HorseCreated)events.get(0);
//
//        //Assert
//        Assertions.assertEquals("xxxxxx1", event.getHorseId().value());
//        Assertions.assertEquals("Guadalupe", event.getName().value());
//
//
//
//    }
//
//    private List<DomainEvent> EventRestore() {
//        return List.of(
//                new GameCreated(GameId.of("Game001") ,new DateTime()));
    }


}