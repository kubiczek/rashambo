package com.kubiczek.rashambo.player;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RockPlayerTest {
    public static final int NUM_OF_ROUNDS = 100;

    @Test
    public void shouldAlwaysGestureRock() {
        // Given
        RockPlayer player = new RockPlayer("Johnny");
        // When
        Handsing[] handsigns = new Handsing[NUM_OF_ROUNDS];
        for (int i = 0; i < NUM_OF_ROUNDS; i++) {
            handsigns[i] = player.play();
        }
        // Then
        for (int i = 0; i < NUM_OF_ROUNDS; i++) {
            assertThat(handsigns[i]).isEqualTo(Handsing.ROCK);
        }
    }
}
