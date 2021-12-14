package co.com.sofkau.horseraces.domain.game.commands;

import lombok.Getter;

import java.util.Objects;


@Getter
public class ChooseHorse {
    private final String horseId;
    private final String playerId;

    public ChooseHorse(String horseId, String playerId) {
        this.horseId = Objects.requireNonNull(horseId);
        this.playerId = Objects.requireNonNull(playerId);
    }

}
