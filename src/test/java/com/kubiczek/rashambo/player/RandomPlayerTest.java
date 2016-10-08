package com.kubiczek.rashambo.player;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RandomPlayerTest {
    public static final int NUM_OF_ROUNDS = 100;

    @Test
    public void shouldGestureRandomly() {
        // Given
        RandomPlayer player = new RandomPlayer("Johnny");
        // When
        List<Handsing> handsigns = new ArrayList<>(NUM_OF_ROUNDS);
        for (int i = 0; i < NUM_OF_ROUNDS; i++) {
            handsigns.add(player.play());
        }
        // Then
        assertThat(handsigns.stream()
                .filter(handsign -> handsign == Handsing.ROCK)
                .collect(toList())
        ).isNotEmpty();
        assertThat(handsigns.stream()
                .filter(handsign -> handsign == Handsing.PAPER)
                .collect(toList())
        ).isNotEmpty();
        assertThat(handsigns.stream()
                .filter(handsign -> handsign == Handsing.SCISSORS)
                .collect(toList())
        ).isNotEmpty();
    }
}
