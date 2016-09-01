package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static mollie.tictactoe.GamePlayHelper.isAComputerTurn;

@RunWith(AndroidJUnit4.class)
public class GamePlayHelperTest {

    private final GameEngine gameEngine = new GameEngine(new PerfectPlayer(Marks.X), new MobilePlayer(Marks.O), new Board(3));

    @Test
    public void knowsIfItIsAComputerPlayersTurn() {
        Intent intent = createIntent();
        intent.putExtra(GamePlayHelper.EXTRA_COMPUTER_FIRST, true);
        assertTrue(isAComputerTurn(GamePlayHelper.EXTRA_COMPUTER_FIRST, intent));
    }

    @Test
    public void playsAComputerMove() {
        GamePlayHelper.playComputerMove(gameEngine);
        assertEquals(Marks.X, gameEngine.board(0));
    }

    @Test
    public void returnsTheMoveLocation() {
        int move = GamePlayHelper.playComputerMove(gameEngine);
        assertEquals(0, move);
    }

    @NonNull
    private Intent createIntent() {
        Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        return new Intent(targetContext, SmallBoardActivity.class);
    }
}
