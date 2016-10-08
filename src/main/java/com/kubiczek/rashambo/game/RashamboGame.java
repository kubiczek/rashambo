package com.kubiczek.rashambo.game;

import com.kubiczek.rashambo.player.Handsing;
import com.kubiczek.rashambo.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RashamboGame {
    private final List<Player> players;

    public RashamboGame(List<Player> players) {
        this.players = players;
    }

    public Optional<Player> battle() {
        Map<Player, Handsing> handsings = new HashMap<>();
        players.forEach(player -> handsings.put(player, player.play()));

        return players.stream()
                .filter(player -> handsings.entrySet()
                        .stream()
                        .filter(playerHandsingEntry -> !player.equals(playerHandsingEntry.getKey()))
                        .allMatch(playerHandsingEntry -> handsings.get(player).beat(playerHandsingEntry.getValue())))
                .findFirst();
    }
}
