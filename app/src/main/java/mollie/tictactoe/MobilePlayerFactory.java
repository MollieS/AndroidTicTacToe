package mollie.tictactoe;

import ttt.Player;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

public class MobilePlayerFactory {

    public static Player create(String playerType, Marks mark) {
        switch (playerType) {
            case MobilePlayerTypes.HUMAN:
                return new MobilePlayer(mark);
            case MobilePlayerTypes.PERFECT:
                return new PerfectPlayer(mark);
            case MobilePlayerTypes.RANDOM:
                return new RandomPlayer(new RandomLocationGenerator(), mark);
        }
        return null;
    }
}
