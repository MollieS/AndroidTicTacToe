package com.example.molliestephenson.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button mGameOption;
    private Button mBoardSize;
    private static final String EXTRA_GAME_TYPE = "com.example.molliestephenson.tictactoe.game_type";
    private static final String EXTRA_BOARD_TYPE = "com.example.molliestephenson.tictactoe.board_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mGameOption = (Button) findViewById(R.id.hvh);
        mGameOption.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            intent.putExtra(EXTRA_GAME_TYPE, true);
            intent.putExtra("3x3", true);
            startActivity(intent);
        });
        mBoardSize = (Button) findViewById(R.id.board_size);
    }
}
