package mollie.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = getClass().getName();
    private List<Button> mBoard;
    private GameEngine mGameEngine;
    public static final String EXTRA_PLAYER_TYPES = "mollie.tictactoe.player_types";
    public static final String EXTRA_BOARD_TYPE = "mollie.tictactoe.board_type";
    public static final String EXTRA_GAME_TYPE = "mollie.tictactoe.game_type";
    public static final String EXTRA_COMPUTER_FIRST = "mollie.tictactoe.computer_first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_by_three_board);
        mGameEngine = getGame();
        mBoard = createBoard();
        setClickable(isAComputerGame(EXTRA_GAME_TYPE));
        checkComputerMoveFirst();
    }

    private void checkComputerMoveFirst() {
        if (isAComputerGame(EXTRA_COMPUTER_FIRST)) {
            playComputerMove();
        }
    }

    private boolean isAComputerGame(String extraGameType) {
        return getIntent().getBooleanExtra(extraGameType, false);
    }

    private GameEngine getGame() {
        String[] playersTypes = getIntent().getStringArrayExtra(EXTRA_PLAYER_TYPES);
        int boardSize = getIntent().getIntExtra(EXTRA_BOARD_TYPE, 3);
        return createGame(playersTypes, boardSize);
    }

    private void playComputerMove() {
        int move = getComputerMove();
        mGameEngine.play(move);
        mBoard.get(move).setText(mGameEngine.board(move).toString());
    }

    private int getComputerMove() {
        Integer move = null;
        try {
            move = mGameEngine.getPlayerMove(mGameEngine.showBoard());
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error: " + e);
        }
        return move;
    }

    private List<Button> createBoard() {
        List<Button> board = new ArrayList<>();
        Button mLeftTop = (Button) findViewById(R.id.left_top_corner);
        board.add(mLeftTop);
        Button mCentreTop = (Button) findViewById(R.id.top_centre);
        board.add(mCentreTop);
        Button mRightTop = (Button) findViewById(R.id.right_top_corner);
        board.add(mRightTop);
        Button mLeftCentre = (Button) findViewById(R.id.left_centre);
        board.add(mLeftCentre);
        Button mCentre = (Button) findViewById(R.id.centre_button);
        board.add(mCentre);
        Button mRightCentre = (Button) findViewById(R.id.right_centre);
        board.add(mRightCentre);
        Button mLeftBottom = (Button) findViewById(R.id.left_bottom);
        board.add(mLeftBottom);
        Button mCentreBottom = (Button) findViewById(R.id.centre_bottom);
        board.add(mCentreBottom);
        Button mRightBottom = (Button) findViewById(R.id.right_bottom);
        board.add(mRightBottom);
        return board;
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
