package co.com.sofkau.horseraces.usecases;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateGameUseCaseTest {

    @Test
    @DisplayName("Valid arguments test")
    void validArgumentsCase_CreateGame(){
//        //arrange
//        var command = new CreateGame(
//                GameId.of("gameId-xxx"),
//                new DateTime(LocalDateTime.of(2022, 9, 30, 15, 45))
//        );
//        var useCase = new CreateGameUseCase();
//
//        //act
//        var events = UseCaseHandler.getInstance()
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        //assert
//        var event = (GameCreated) events.get(0);
//        Assertions.assertEquals("gameId-xxx",event.aggregateRootId());
//        Assertions.assertEquals("30-09-2022 15:45", event.getDateTime().toString());
//
//
//    }
//
//    @Test
//    @DisplayName("No Id test")
//    void noIdCase_CreateGame(){
//        //arrange
//        var command = new CreateGame(new GameId(),
//                new DateTime(LocalDateTime.of(2022, 9, 30, 15, 45))
//        );
//        var useCase = new CreateGameUseCase();
//
//        //act
//        var events = UseCaseHandler.getInstance()
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        //assert
//        var event = (GameCreated) events.get(0);
//        Assertions.assertFalse(event.aggregateRootId().isBlank());
//        Assertions.assertEquals("30-09-2022 15:45", event.getDateTime().toString());
//
//
    }

}