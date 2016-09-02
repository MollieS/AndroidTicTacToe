package mollie.tictactoe;

import org.junit.Test;

import ttt.Player;

import static junit.framework.Assert.assertEquals;
import static mollie.tictactoe.AndroidPlayerType.HUMAN;
import static ttt.game.Marks.X;

public class AndroidPlayerFactoryTest {

    @Test
    public void returnsAMobileHumanPlayer() {
        Player player = AndroidPlayerFactory.create(HUMAN, X);
        assertEquals(MobilePlayer.class, player.getClass());
    }
}
