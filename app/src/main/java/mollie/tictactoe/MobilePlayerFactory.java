package mollie.tictactoe;

import ttt.Player;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

public class MobilePlayerFactory {

    public static Player create(String playerType, Marks mark) {
        switch (playerType) {
            case MobilePlayers.MOBILE:
                return new MobilePlayer(mark);
            case MobilePlayers.PERFECT:
                return new PerfectPlayer(mark);
            case MobilePlayers.RANDOM:
                return new RandomPlayer(new RandomLocationGenerator(), mark);
        }
        return null;
    }
}
