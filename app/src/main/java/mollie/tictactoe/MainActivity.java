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

public class MainActivity extends AppCompatActivity {

    private final List<Button> mBoard = new ArrayList<>();
    private GameEngine mGameEngine;
    private static final String EXTRA_PLAYER_TYPES = "mollie.tictactoe.player_types";
    private static final String EXTRA_BOARD_TYPE = "mollie.tictactoe.board_type";
    private static final String EXTRA_GAME_TYPE = "mollie.tictactoe.game_type";
    private static final String EXTRA_COMPUTER_FIRST = "mollie.tictactoe.computer_first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] playersTypes = getIntent().getStringArrayExtra(EXTRA_PLAYER_TYPES);
        boolean isAComputerGame = getIntent().getBooleanExtra(EXTRA_GAME_TYPE, false);
        int boardSize = getIntent().getIntExtra(EXTRA_BOARD_TYPE, 3);
        boolean isComputerMove = getIntent().getBooleanExtra(EXTRA_COMPUTER_FIRST, false);
        createGame(playersTypes, boardSize);
        createBoard();
        setClickable(isAComputerGame);
        if (isComputerMove) {
            int move = getComputerMove();
            mGameEngine.play(move);
            mBoard.get(move).setText(mGameEngine.board(move).toString());
        }
    }

    private int getComputerMove() {
        int move = -1;
        try {
            move = mGameEngine.getPlayerMove(mGameEngine.showBoard());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return move;
    }

    private void createBoard() {
        Button mLeftTop = (Button) findViewById(R.id.left_top_corner);
        mBoard.add(mLeftTop);
        Button mCentreTop = (Button) findViewById(R.id.top_centre);
        mBoard.add(mCentreTop);
        Button mRightTop = (Button) findViewById(R.id.right_top_corner);
        mBoard.add(mRightTop);
        Button mLeftCentre = (Button) findViewById(R.id.left_centre);
        mBoard.add(mLeftCentre);
        Button mCentre = (Button) findViewById(R.id.centre_button);
        mBoard.add(mCentre);
        Button mRightCentre = (Button) findViewById(R.id.right_centre);
        mBoard.add(mRightCentre);
        Button mLeftBottom = (Button) findViewById(R.id.left_bottom);
        mBoard.add(mLeftBottom);
        Button mCentreBottom = (Button) findViewById(R.id.centre_bottom);
        mBoard.add(mCentreBottom);
        Button mRightBottom = (Button) findViewById(R.id.right_bottom);
        mBoard.add(mRightBottom);
    }

    private void createGame(String[] playerTypes, int boardSize) {
        Board board = new Board(boardSize);
        Player player1 = AndroidPlayerFactory.create(playerTypes[0], Marks.X);
        Player player2 = AndroidPlayerFactory.create(playerTypes[1], Marks.O);
        this.mGameEngine = new GameEngine(player1, player2, board);
    }

    private void setClickable(boolean isAComputerGame) {
        for (int cell = 0; cell < mBoard.size(); cell++) {
            MoveListener moveListener = new MoveListener(cell, mBoard, getApplicationContext(), mGameEngine, isAComputerGame);
            mBoard.get(cell).setOnClickListener(moveListener);
        }
    }
}
