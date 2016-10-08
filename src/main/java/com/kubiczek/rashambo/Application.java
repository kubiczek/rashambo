package com.kubiczek.rashambo;

import com.kubiczek.rashambo.game.RashamboGame;
import com.kubiczek.rashambo.player.Player;
import com.kubiczek.rashambo.player.RandomPlayer;
import com.kubiczek.rashambo.player.RockPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * Created by mkubiczek on 10/8/2016.
 */
@SpringBootApplication
public class Application {
    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${rashambo.number-of-players}")
    private int numberOfPlayers;
    @Value("${rashambo.number-of-rounds}")
    private int numberOfRounds;

    @Bean
    List<Player> players() {
        List<Player> players = new ArrayList<>(numberOfPlayers);
        players.add(new RockPlayer("Rock Player"));
        for (int i = 1; i < numberOfPlayers; i++) {
            players.add(new RandomPlayer("Random Player " + i));
        }
        return players;
    }

    @Bean
    public RashamboGame game() {
        log.info("Setting up the game for {} players", numberOfPlayers);
        return new RashamboGame(players());
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            log.info("Let's the game begin! {} players, {} round(s)", numberOfPlayers, numberOfRounds);
            Map<Player, Integer> summary = new HashMap<>();
            int tie = 0;
            for (int i = 0; i < numberOfRounds; i++) {
                Optional<Player> winner = game().battle();
                if (winner.isPresent()) {
                    summary.put(winner.get(), summary.getOrDefault(winner.get(), 0) + 1);
                } else {
                    tie++;
                }
                log.trace("Battle winner: {}", winner.isPresent() ? winner.get().getName() : "Tie");
            }

            summary.forEach((player, count) -> log.info("{}: {} time(s) winner", player.getName(), count));
            log.info("The game is tied {} time(s)", tie);
        };
    }
}
