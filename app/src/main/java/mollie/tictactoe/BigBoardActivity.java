package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ttt.game.GameEngine;

import static mollie.tictactoe.GamePlayHelper.isAComputerTurn;
import static mollie.tictactoe.GamePlayHelper.playComputerMove;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.getGame;
import static mollie.tictactoe.MobileGameConstructor.setClickable;

public class BigBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_board);
        Intent intent = getIntent();
        List<Button> board = createBoard();
        GameEngine gameEngine = getGame(intent);
        setClickable(isAComputerTurn(EXTRA_GAME_TYPE, intent), board, getApplicationContext(), gameEngine);
        if (isAComputerTurn(EXTRA_GAME_TYPE, intent)) {
            int location = playComputerMove(gameEngine);
            updateView(location, board, gameEngine);
        }
    }

    private void updateView(int location, List<Button> board, GameEngine gameEngine) {
        board.get(location).setText(gameEngine.board(location).toString());
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

    private Button getCell(int cellId) {
        return (Button) findViewById(cellId);
    }
}
