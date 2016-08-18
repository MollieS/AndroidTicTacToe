package com.example.molliestephenson.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ttt.game.GameEngine;
import ttt.game.Marks;

public class MoveListener implements View.OnClickListener {

    private Button cell;
    private GameEngine gameEngine;
    private int location;
    private Context context;

    public MoveListener(int location, Button cell, Context context, GameEngine gameEngine) {
        this.location = location;
        this.cell = cell;
        this.context = context;
        this.gameEngine = gameEngine;
    }

    @Override
    public void onClick(View view) {
        if (!gameEngine.isOver() && gameEngine.board(location) == Marks.NULL) {
            updateView();
        }
        if (gameEngine.isOver()) {
            showResult();
        }
    }

    private void showResult() {
        if (gameEngine.isWon()) {
            showWinner();
        } else {
            Toast.makeText(context, "It's a draw!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateView() {
        gameEngine.play(location);
        cell.setText(gameEngine.board(location).toString());
    }

    private void showWinner() {
        String winningMessage = gameEngine.winningMark() + " wins!";
        Toast.makeText(context, winningMessage, Toast.LENGTH_SHORT).show();
    }
}
