package mollie.tictactoe;

import ttt.Player;
import ttt.game.Marks;
import ttt.players.PlayerFactory;

public class AndroidPlayerFactory {

    public static Player create(String playerType, Marks mark) {
        if (playerType.equals(AndroidPlayerType.HUMAN)) {
            return new MobilePlayer(mark);
        }
        return PlayerFactory.create(playerType, mark);
    }
}
