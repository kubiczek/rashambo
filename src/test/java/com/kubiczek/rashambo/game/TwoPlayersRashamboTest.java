package com.kubiczek.rashambo.game;

import com.kubiczek.rashambo.player.Handsing;
import com.kubiczek.rashambo.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by mkubiczek on 10/8/2016.
 */
public class TwoPlayersRashamboTest {
    private TwoPlayersRashambo game, reverseGame;
    @Mock
    private Player player1, player2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.game = new TwoPlayersRashambo(player1, player2);
        this.reverseGame = new TwoPlayersRashambo(player2, player1);
    }

    @Test
    public void shouldRockWin_whenRockCrushesScissors() {
        // Given
        when(player1.play()).thenReturn(Handsing.ROCK);
        when(player2.play()).thenReturn(Handsing.SCISSORS);
        // When
        Optional<Player> result = game.battle();
        Optional<Player> resultReverse = reverseGame.battle();
        // Then
        assertThat(result.get()).isEqualTo(player1);
        assertThat(resultReverse.get()).isEqualTo(player1);
    }

    @Test
    public void shouldPaperWin_whenPaperCoversRock() {
        // Given
        when(player1.play()).thenReturn(Handsing.PAPER);
        when(player2.play()).thenReturn(Handsing.ROCK);
        // When
        Optional<Player> result = game.battle();
        Optional<Player> resultReverse = reverseGame.battle();
        // Then
        assertThat(result.get()).isEqualTo(player1);
        assertThat(resultReverse.get()).isEqualTo(player1);
    }

    @Test
    public void shouldScissorsWin_whenScissorsCutPaper() {
        // Given
        when(player1.play()).thenReturn(Handsing.SCISSORS);
        when(player2.play()).thenReturn(Handsing.PAPER);
        // When
        Optional<Player> result = game.battle();
        Optional<Player> resultReverse = reverseGame.battle();
        // Then
        assertThat(result.get()).isEqualTo(player1);
        assertThat(resultReverse.get()).isEqualTo(player1);
    }

    @Test
    public void shouldBeTie_whenBothPlayersChooseTheSameShape() {
        for (Handsing handsing : Handsing.values()) {
            // Given
            when(player1.play()).thenReturn(handsing);
            when(player2.play()).thenReturn(handsing);
            // When
            Optional<Player> result = game.battle();
            // Then
            assertThat(result.isPresent()).isFalse();
        }
    }
}
