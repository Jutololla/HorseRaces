package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrepareGameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test preparation with valid arguments")
    void validArguments_prepareGame() {
//        //arrange
//        ArrayList<PlayerId> commandListPlayerId = new ArrayList<>();
//        commandListPlayerId.add(PlayerId.of("Player1"));
//        commandListPlayerId.add(PlayerId.of("Player2"));
//
//        var command = new PrepareGame(
//                new GameId("Game001"),commandListPlayerId);
//
//        var useCase = new PrepareGameUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        ArrayList<PlayerId> playersIds = new ArrayList<>();
//        playersIds.add(PlayerId.of("Player1"));
//        playersIds.add(PlayerId.of("Player2"));
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (GamePrepared) events.get(0);
//
//        //Assert
//        assertEquals(event.getPlayerIds(), playersIds);
    }

    @Test
    @DisplayName("Test preparation with uncomplete arguments")
    void uncompleteData_prepareGame() {
//        //arrange
//        ArrayList<PlayerId> commandListPlayerId = new ArrayList<>();
//        commandListPlayerId.add(PlayerId.of("Player1"));
//        commandListPlayerId.add(PlayerId.of("Player2"));
//
//        var command = new PrepareGame(
//                new GameId("Game001"),commandListPlayerId);
//
//        var useCase = new PrepareGameUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore2());
//        useCase.addRepository(repository);
//
//        //Act,Assert
//        Assertions.assertThrows(Exception.class, () -> UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents());

    }

//    private List<DomainEvent> EventRestore() {
//        return List.of(
//                new GameCreated(GameId.of("Game001"), new DateTime()),
//                new TrackAdded(new TrackId("Track1"),new Length(10d)),
//                new HorseCreated(new HorseId("Horse1"), new Name("Campeona")),
//                new HorseCreated(new HorseId("Horse2"), new Name("Muchacho")),
//                new PlayerCreated(PlayerId.of("Player1"), new Name("Francisco")),
//                new PlayerCreated(PlayerId.of("Player2"), new Name("Carlos")),
//                new HorseChosen(new HorseId("Horse1"), new PlayerId("Player1")),
//                new HorseChosen(new HorseId("Horse2"), new PlayerId("Player2")));
//        }
//    private List<DomainEvent> EventRestore2() {
//        return List.of(
//                new GameCreated(GameId.of("Game001"), new DateTime()),
//                new TrackAdded(new TrackId("Track1"), new Length(10d)),
//                new HorseCreated(new HorseId("Horse1"), new Name("Campeona")),
//                new HorseCreated(new HorseId("Horse2"), new Name("Muchacho")),
//                new PlayerCreated(PlayerId.of("Player1"), new Name("Francisco")),
//                new PlayerCreated(PlayerId.of("Player2"), new Name("Carlos")),
////                new HorseChosen(new HorseId("Horse1"), new PlayerId("Player1")),
//                new HorseChosen(new HorseId("Horse2"), new PlayerId("Player2")));
//    }
}
