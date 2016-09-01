package mollie.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

public class FourByFourActivity extends AppCompatActivity {

    private GameEngine mGameEngine;
    private List<Button> mBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_by_four_board);
        mBoard = createBoard();
        mGameEngine = getGame();
        setClickable(isAComputerGame(MainActivity.EXTRA_GAME_TYPE));
    }

    private boolean isAComputerGame(String extraGameType) {
        return getIntent().getBooleanExtra(extraGameType, false);
    }

    private GameEngine getGame() {
        String[] playersTypes = getIntent().getStringArrayExtra(MainActivity.EXTRA_PLAYER_TYPES);
        int boardSize = getIntent().getIntExtra(MainActivity.EXTRA_BOARD_TYPE, 3);
        return createGame(playersTypes, boardSize);
    }

    private List<Button> createBoard() {
        List<Button> board = new ArrayList<>();
        board.add(getCell(R.id.top_left));
        board.add(getCell(R.id.top_mid_left));
        board.add(getCell(R.id.top_mid_right));
        board.add(getCell(R.id.top_right));
        board.add(getCell(R.id.second_left));
        board.add(getCell(R.id.second_mid_left));
        board.add(getCell(R.id.second_mid_right));
        board.add(getCell(R.id.second_right));
        board.add(getCell(R.id.third_left));
        board.add(getCell(R.id.third_mid_left));
        board.add(getCell(R.id.third_mid_right));
        board.add(getCell(R.id.third_right));
        board.add(getCell(R.id.bottom_left));
        board.add(getCell(R.id.bottom_mid_left));
        board.add(getCell(R.id.bottom_mid_right));
        board.add(getCell(R.id.bottom_right));

        return board;
    }

    private Button getCell(int top_left) {
        return (Button) findViewById(top_left);
    }

    private GameEngine createGame(String[] playerTypes, int boardSize) {
        Board board = new Board(boardSize);
        Player player1 = AndroidPlayerFactory.create(playerTypes[0], Marks.X);
        Player player2 = AndroidPlayerFactory.create(playerTypes[1], Marks.O);
        return new GameEngine(player1, player2, board);
    }

    private void setClickable(boolean isAComputerGame) {
        for (int cell = 0; cell < mBoard.size(); cell++) {
            MoveListener moveListener = new MoveListener(cell, mBoard, getApplicationContext(), mGameEngine, isAComputerGame);
            mBoard.get(cell).setOnClickListener(moveListener);
        }
    }

}
