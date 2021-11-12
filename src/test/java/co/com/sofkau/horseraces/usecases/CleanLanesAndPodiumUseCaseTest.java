package co.com.sofkau.horseraces.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.horseraces.domain.game.commands.CleanLanesAndPodium;
import co.com.sofkau.horseraces.domain.game.events.*;
import co.com.sofkau.horseraces.domain.game.values.*;
import co.com.sofkau.horseraces.usecases.game.commands.CleanLanesAndPodiumUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CleanLanesAndPodiumUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test rematch with valid arguments")
    void validArguments_clean() {
        //arrange
//        var command = new CleanLanesAndPodium(
//                new GameId("Game001"));
//
//        var useCase = new CleanLanesAndPodiumUseCase();
//        Mockito.when(repository.getEventsBy(command.getGameId().value())).thenReturn(EventRestore());
//        useCase.addRepository(repository);
//
//        //Act
//        var events = UseCaseHandler.getInstance()
//                .setIdentifyExecutor(command.getGameId().value())
//                .syncExecutor(useCase, new RequestCommand<>(command))
//                .orElseThrow()
//                .getDomainEvents();
//        var event = (LanesAndPodiumCleaned) events.get(0);
//
//        //Assert
//
//    }
//
//    private List<DomainEvent> EventRestore() {
//        ArrayList<PlayerId> playersIds = new ArrayList<>();
//        playersIds.add(PlayerId.of("Player1"));
//        playersIds.add(PlayerId.of("Player2"));
//        playersIds.add(PlayerId.of("Player3"));
//        playersIds.add(PlayerId.of("Player4"));
//        return List.of(
//                new GameCreated(GameId.of("Game001"), new DateTime()),
//                new TrackAdded(new TrackId("Track1"),new Length(3000d)),
//                new HorseCreated(new HorseId("Horse1"), new Name("Campeona")),
//                new HorseCreated(new HorseId("Horse2"), new Name("Muchacho")),
//                new PlayerCreated(PlayerId.of("Player1"), new Name("Francisco")),
//                new PlayerCreated(PlayerId.of("Player2"), new Name("Carlos")),
//                new PlayerCreated(PlayerId.of("Player3"), new Name("Pedro")),
//                new PlayerCreated(PlayerId.of("Player4"), new Name("Mauricio")),
//                new HorseChosen(new HorseId("Horse1"), new PlayerId("Player1")),
//                new HorseChosen(new HorseId("Horse2"), new PlayerId("Player2")),
//                new HorseChosen(new HorseId("Horse1"), new PlayerId("Player3")),
//                new HorseChosen(new HorseId("Horse2"), new PlayerId("Player4")),
//                new GamePrepared(playersIds),
//                new RaceRun(),
//                new PodiumSet());
    }

}