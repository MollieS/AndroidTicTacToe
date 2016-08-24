package com.example.molliestephenson.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ttt.Player;
import ttt.game.Board;
import ttt.game.GameEngine;
import ttt.game.Marks;

public class MainActivity extends AppCompatActivity {

    private List<Button> mBoard = new ArrayList<>();
    private GameEngine mGameEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIntent().getBooleanExtra("HumanVHuman", true);
        createGame();
        createBoard();
        setClickable();
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

    private void createGame() {
        Board board = new Board(3);
        Player player1 = new MobilePlayer(Marks.X);
        Player player2 = new MobilePlayer(Marks.O);
        this.mGameEngine = new GameEngine(player1, player2, board);
    }

    private void setClickable() {
        for (int cell = 0; cell < mBoard.size(); cell++) {
            MoveListener moveListener = new MoveListener(cell, mBoard.get(cell), getApplicationContext(), mGameEngine);
            mBoard.get(cell).setOnClickListener(moveListener);
        }
    }
}
