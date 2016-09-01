package mollie.tictactoe;

import ttt.Player;
import ttt.game.Marks;
import ttt.players.PerfectPlayer;
import ttt.players.RandomLocationGenerator;
import ttt.players.RandomPlayer;

public class AndroidPlayerFactory {

    public static Player create(String playerType, Marks mark) {
        switch (playerType) {
            case AndroidPlayerType.HUMAN:
                return new MobilePlayer(mark);
            case AndroidPlayerType.PERFECT:
                return new PerfectPlayer(mark);
            case AndroidPlayerType.RANDOM:
                return new RandomPlayer(new RandomLocationGenerator(), mark);
        }
        return null;
    }
}
