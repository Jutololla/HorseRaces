package co.com.sofkau.horseraces.domain.game.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeletePlayer {
    private String playerId;
}
