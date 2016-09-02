package mollie.tictactoe;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import ttt.game.GameEngine;
import ttt.game.Marks;

public class MoveListener implements View.OnClickListener {

    private final String LOG_TAG = getClass().getName();
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
        playMove();
        showGameStatus();
        playComputerOpponentMove();
    }

    private void playComputerOpponentMove() {
        if (isAComputerGame && !gameEngine.isOver()) {
            playComputerMove();
        }
    }

    private void showGameStatus() {
        if (gameEngine.isOver()) {
            showResult();
        }
    }

    private void playMove() {
        if (!gameEngine.isOver() && gameEngine.board(location) == Marks.NULL) {
            updateView(cell, location);
        }
    }

    private void playComputerMove() {
        try {
            int computerMove = gameEngine.getCurrentPlayer().getLocation(gameEngine.showBoard());
            Button button = uiBoard.get(computerMove);
            if (gameEngine.board(computerMove) == Marks.NULL) {
                updateView(button, computerMove);
            }
            showGameStatus();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error: " + e);
        }
    }

    private void showResult() {
        if (gameEngine.isWon()) {
            showWinner();
        } else {
            Toast.makeText(context, R.string.toast_draw, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateView(Button cellButton, int moveLocation) {
        gameEngine.play(moveLocation);
        cellButton.setText(gameEngine.board(moveLocation).toString());
    }

    private void showWinner() {
        String winningMessage = gameEngine.winningMark() + context.getString(R.string.toast_win);
        Toast.makeText(context, winningMessage, Toast.LENGTH_SHORT).show();
    }
}
