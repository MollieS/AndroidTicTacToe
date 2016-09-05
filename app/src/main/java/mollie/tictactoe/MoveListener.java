package mollie.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
            String status = getGameStatus();
            new AlertDialog.Builder(context)
                    .setTitle(status)
                    .setMessage("Would you like to play again?")
                    .setPositiveButton("yes", (dialogInterface, i) -> {
                        ((Activity) context).onBackPressed();
                    })
                    .setNegativeButton("no", (dialogInterface, i) -> {
                    })
                    .show();
        }
    }

    private String getGameStatus() {
        if (gameEngine.isWon()) {
            return gameEngine.winningMark() + " wins!";
        } else {
            return context.getString(R.string.draw_text);
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

    private void updateView(Button cellButton, int moveLocation) {
        gameEngine.play(moveLocation);
        cellButton.setText(gameEngine.board(moveLocation).toString());
    }
}
