package mollie.tictactoe;

import org.junit.Test;

import ttt.Player;

import static junit.framework.Assert.assertEquals;
import static mollie.tictactoe.MobilePlayers.MOBILE;
import static ttt.game.Marks.X;

public class MobilePlayerFactoryTest {

    @Test
    public void returnsAMobileHumanPlayer() {
        Player player = MobilePlayerFactory.create(MOBILE, X);
        assertEquals(MobilePlayer.class, player.getClass());
    }
}
