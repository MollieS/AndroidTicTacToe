package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ttt.game.GameEngine;

import static mollie.tictactoe.GamePlayHelper.*;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.getGame;
import static mollie.tictactoe.MobileGameConstructor.setClickable;

public class SmallBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.small_board);
        Intent intent = getIntent();
        GameEngine gameEngine = getGame(intent);
        List<Button> board = createBoard();
        if (isAComputerTurn(EXTRA_COMPUTER_FIRST, intent)) {
            int location = playComputerMove(gameEngine);
            updateView(location, board, gameEngine);
        }
        setClickable(isAComputerTurn(EXTRA_GAME_TYPE, intent), board, this, gameEngine);
    }

    private void updateView(int location, List<Button> board, GameEngine gameEngine) {
        board.get(location).setText(gameEngine.board(location).toString());
    }

    private List<Button> createBoard() {
        List<Button> board = new ArrayList<>();
        board.add(getCell(R.id.left_top_corner));
        board.add(getCell(R.id.top_centre));
        board.add(getCell(R.id.right_top_corner));
        board.add(getCell(R.id.left_centre));
        board.add(getCell(R.id.centre_button));
        board.add(getCell(R.id.right_centre));
        board.add(getCell(R.id.left_bottom));
        board.add(getCell(R.id.centre_bottom));
        board.add(getCell(R.id.right_bottom));
        return board;
    }

    private Button getCell(int left_top_corner) {
        return (Button) findViewById(left_top_corner);
    }

}
