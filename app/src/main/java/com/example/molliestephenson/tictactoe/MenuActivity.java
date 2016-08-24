package com.example.molliestephenson.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button mGameOptionButton;
    private Button mBoardSizeButton;
    private Intent mGameOptions;
    private static final String EXTRA_GAME_TYPE = "com.example.molliestephenson.tictactoe.game_type";
    private static final String EXTRA_BOARD_TYPE = "com.example.molliestephenson.tictactoe.board_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mGameOptionButton = (Button) findViewById(R.id.hvh);
        setGameOptionButton();
        setBoardOptionButton();
    }

    private void setBoardOptionButton() {
        mBoardSizeButton = (Button) findViewById(R.id.board_size);
        mBoardSizeButton.setOnClickListener(view -> {
            mGameOptions.putExtra(EXTRA_BOARD_TYPE, true);
            startActivity(mGameOptions);
        });
    }

    private void setGameOptionButton() {
        mGameOptionButton.setOnClickListener(view -> {
            mGameOptions = new Intent(MenuActivity.this, MainActivity.class);
            mGameOptions.putExtra(EXTRA_GAME_TYPE, true);
        });
    }
}
