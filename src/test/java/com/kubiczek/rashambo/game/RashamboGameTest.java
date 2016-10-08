package com.kubiczek.rashambo.game;

import com.kubiczek.rashambo.player.Handsing;
import com.kubiczek.rashambo.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class RashamboGameTest {
    @Mock
    private Player player1, player2, player3;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldRockWin_whenRockCrushesScissors() {
        // Given
        when(player1.play()).thenReturn(Handsing.ROCK);
        when(player2.play()).thenReturn(Handsing.SCISSORS);
        RashamboGame rashambo = new RashamboGame(Arrays.asList(player1, player2));
        // When
        Optional<Player> winner = rashambo.battle();
        // Then
        assertThat(winner.get()).isEqualTo(player1);
    }

    @Test
    public void shouldPaperWin_whenPaperCoversRock() {
        // Given
        when(player1.play()).thenReturn(Handsing.ROCK);
        when(player2.play()).thenReturn(Handsing.PAPER);
        RashamboGame rashambo = new RashamboGame(Arrays.asList(player1, player2));
        // When
        Optional<Player> winner = rashambo.battle();
        // Then
        assertThat(winner.get()).isEqualTo(player2);
    }

    @Test
    public void shouldScissorsWin_whenScissorsCutPaper() {
        // Given
        when(player1.play()).thenReturn(Handsing.SCISSORS);
        when(player2.play()).thenReturn(Handsing.PAPER);
        RashamboGame rashambo = new RashamboGame(Arrays.asList(player1, player2));
        // When
        Optional<Player> winner = rashambo.battle();
        // Then
        assertThat(winner.get()).isEqualTo(player1);
    }

    @Test
    public void shouldScissorsWin_whenScissorsCutPaperAndThreePlayers() {
        // Given
        when(player1.play()).thenReturn(Handsing.PAPER);
        when(player2.play()).thenReturn(Handsing.PAPER);
        when(player3.play()).thenReturn(Handsing.SCISSORS);
        RashamboGame rashambo = new RashamboGame(Arrays.asList(player1, player2, player3));
        // When
        Optional<Player> winner = rashambo.battle();
        // Then
        assertThat(winner.get()).isEqualTo(player3);
    }

    @Test
    public void shouldBeTie_whenBothPlayersChooseTheSameShape() {
        for (Handsing handsing : Handsing.values()) {
            // Given
            when(player1.play()).thenReturn(handsing);
            when(player2.play()).thenReturn(handsing);
            RashamboGame rashambo = new RashamboGame(Arrays.asList(player1, player2));
            // When
            Optional<Player> winner = rashambo.battle();
            // Then
            assertThat(winner.isPresent()).isFalse();
        }
    }
}
