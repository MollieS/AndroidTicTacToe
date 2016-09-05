package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import java.util.List;

import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;

import static ttt.game.Marks.O;
import static ttt.game.Marks.X;

public class MobileGameConstructor {

    public static final String EXTRA_PLAYER_TYPES = "mollie.tictactoe.player_types";
    public static final String EXTRA_BOARD_TYPE = "mollie.tictactoe.board_type";
    public static final String EXTRA_GAME_TYPE = "mollie.tictactoe.game_type";

    public static GameEngine getGame(Intent intent) {
        String[] playersTypes = intent.getStringArrayExtra(EXTRA_PLAYER_TYPES);
        int boardSize = intent.getIntExtra(EXTRA_BOARD_TYPE, 3);
        return createGame(playersTypes, boardSize);
    }

    private static GameEngine createGame(String[] playerTypes, int boardSize) {
        Board board = new Board(boardSize);
        Player player1 = MobilePlayerFactory.create(playerTypes[0], X);
        Player player2 = MobilePlayerFactory.create(playerTypes[1], O);
        return new GameEngine(player1, player2, board);
    }

    public static void setClickable(boolean isAComputerGame, List<Button> board, Context context, GameEngine gameEngine) {
        for (int cell = 0; cell < board.size(); cell++) {
            MoveListener moveListener = new MoveListener(cell, board, context, gameEngine, isAComputerGame);
            board.get(cell).setOnClickListener(moveListener);
        }
    }

}
