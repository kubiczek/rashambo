package com.kubiczek.rashambo.game;

import com.kubiczek.rashambo.player.Handsing;
import com.kubiczek.rashambo.player.Player;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.kubiczek.rashambo.game.TwoPlayersRashambo.BattleResult.PLAYER_1;
import static com.kubiczek.rashambo.game.TwoPlayersRashambo.BattleResult.PLAYER_2;
import static com.kubiczek.rashambo.game.TwoPlayersRashambo.BattleResult.TIE;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

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
        TwoPlayersRashambo.BattleResult result = game.battle();
        TwoPlayersRashambo.BattleResult resultReverse = reverseGame.battle();
        // Then
        assertThat(result).isEqualTo(PLAYER_1);
        assertThat(resultReverse).isEqualTo(PLAYER_2);
    }

    @Test
    public void shouldPaperWin_whenPaperCoversRock() {
        // Given
        when(player1.play()).thenReturn(Handsing.PAPER);
        when(player2.play()).thenReturn(Handsing.ROCK);
        // When
        TwoPlayersRashambo.BattleResult result = game.battle();
        TwoPlayersRashambo.BattleResult resultReverse = reverseGame.battle();
        // Then
        assertThat(result).isEqualTo(PLAYER_1);
        assertThat(resultReverse).isEqualTo(PLAYER_2);
    }

    @Test
    public void shouldScissorsWin_whenScissorsCutPaper() {
        // Given
        when(player1.play()).thenReturn(Handsing.SCISSORS);
        when(player2.play()).thenReturn(Handsing.PAPER);
        // When
        TwoPlayersRashambo.BattleResult result = game.battle();
        TwoPlayersRashambo.BattleResult resultReverse = reverseGame.battle();
        // Then
        assertThat(result).isEqualTo(PLAYER_1);
        assertThat(resultReverse).isEqualTo(PLAYER_2);
    }

    @Test
    public void shouldBeTie_whenBothPlayersChooseTheSameShape() {
        for (Handsing handsing : Handsing.values()) {
            // Given
            when(player1.play()).thenReturn(handsing);
            when(player2.play()).thenReturn(handsing);
            // When
            TwoPlayersRashambo.BattleResult result = game.battle();
            // Then
            assertThat(result).isEqualTo(TIE);
        }
    }
}
