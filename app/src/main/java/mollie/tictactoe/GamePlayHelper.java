package mollie.tictactoe;

import android.content.Intent;
import android.util.Log;

import ttt.game.GameEngine;

public class GamePlayHelper {

    public static final String EXTRA_COMPUTER_FIRST = "mollie.tictactoe.computer_first";
    private static final String LOG_TAG = "GamePlayHelper";

    public static boolean isAComputerTurn(String extraName, Intent intent) {
        return intent.getBooleanExtra(extraName, false);
    }

    public static int playComputerMove(GameEngine gameEngine) {
        int move = getComputerMove(gameEngine);
        gameEngine.play(move);
        return move;
    }

    private static int getComputerMove(GameEngine game) {
        try {
            return game.getPlayerMove(game.showBoard());
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error: " + e);
        }
        return Integer.parseInt(null);
    }
}
