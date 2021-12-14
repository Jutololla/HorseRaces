package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChooseHorseUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test creation with valid arguments")
    void validArguments_chooseHorse(){
//        //arrange
//        var command = new ChooseHorse(
//                new GameId("Game001"),
//                new HorseId("xxxxxx1"),
//                new PlayerId("Guadalupe")  );
//
//        var useCase = new ChooseHorseUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (HorseChosen)events.get(0);
//
//        //Assert
//        Assertions.assertEquals("xxxxxx1", event.getHorseId().value());
//        Assertions.assertEquals("Guadalupe", event.getPlayerId().value());
//
//
//
//    }
//
//    @Test
//    @DisplayName("Test creation with no player found")
//    void noPlayerFound_chooseHorse(){
//        //arrange
//        var command = new ChooseHorse(
//                new GameId("Game001"),
//                new HorseId("xxxxxx1"),
//                new PlayerId("Guadalupe")  );

//        var useCase = new ChooseHorseUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestoreFail());
//        useCase.addRepository(repository);

        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (HorseChosen)events.get(0);

        //Assert




    }



}