package com.kubiczek.rashambo;

import com.kubiczek.rashambo.game.TwoPlayersRashambo;
import com.kubiczek.rashambo.player.Player;
import com.kubiczek.rashambo.player.RandomPlayer;
import com.kubiczek.rashambo.player.RockPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

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
    public TwoPlayersRashambo game() {
        Player rockPlayer = new RockPlayer("Rock Player");
        Player randomPlayer = new RandomPlayer("Random Player");
        return new TwoPlayersRashambo(rockPlayer, randomPlayer);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> {
            log.info("Let's the game begin! {} players, {} round(s)", numberOfPlayers, numberOfRounds);

            for (int i = 0; i < numberOfRounds; i++) {
                TwoPlayersRashambo.BattleResult result = game().battle();
                log.info("Battle result: {}", result);
            }
        };
    }
}
