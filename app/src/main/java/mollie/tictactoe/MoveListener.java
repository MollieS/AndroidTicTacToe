package mollie.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import ttt.game.GameEngine;
import ttt.game.Marks;

public class MoveListener implements View.OnClickListener {

    private final List<Button> uiBoard;
    private final GameEngine gameEngine;
    private final Button cell;
    private final int location;
    private final Context context;
    private final boolean isAComputerGame;

    public MoveListener(int location, List<Button> uiBoard, Context context, GameEngine gameEngine, boolean isAComputerGame) {
        this.location = location;
        this.uiBoard = uiBoard;
        this.cell = uiBoard.get(location);
        this.context = context;
        this.gameEngine = gameEngine;
        this.isAComputerGame = isAComputerGame;
    }

    @Override
    public void onClick(View view) {
        if (!gameEngine.isOver() && gameEngine.board(location) == Marks.NULL) {
            updateView();
        }
        if (gameEngine.isOver()) {
            showResult();
        }
        if (isAComputerGame) {
            playComputerMove();
        }
    }

    private void playComputerMove() {
        try {
            int computerMove = gameEngine.getPlayerMove(gameEngine.showBoard());
            gameEngine.play(computerMove);
            Button button = uiBoard.get(computerMove);
            button.setText(gameEngine.board(computerMove).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showResult() {
        if (gameEngine.isWon()) {
            showWinner();
        } else {
            Toast.makeText(context, R.string.toast_draw, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateView() {
        gameEngine.play(location);
        cell.setText(gameEngine.board(location).toString());
    }

    private void showWinner() {
        String winningMessage = gameEngine.winningMark() + context.getString(R.string.toast_win);
        Toast.makeText(context, winningMessage, Toast.LENGTH_SHORT).show();
    }
}
