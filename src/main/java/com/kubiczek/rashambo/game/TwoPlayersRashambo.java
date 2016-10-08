package com.kubiczek.rashambo.game;

import com.kubiczek.rashambo.player.Handsing;
import com.kubiczek.rashambo.player.Player;

import java.util.Optional;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class TwoPlayersRashambo {
    private final Player player1, player2;

    public TwoPlayersRashambo(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Optional<Player> battle() {
        Handsing handsing1 = player1.play();
        Handsing handsing2 = player2.play();

        if (handsing1.beat(handsing2)) {
            return Optional.of(player1);
        } else if (handsing2.beat(handsing1)) {
            return Optional.of(player2);
        } else {
            return Optional.empty();
        }
    }
}
