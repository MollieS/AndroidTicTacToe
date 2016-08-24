package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button mGameOptionButton;
    private Button mBoardSizeButton;
    private Intent mGameOptions;
    private static final String EXTRA_GAME_TYPE = "tictactoe.game_type";
    private static final String EXTRA_BOARD_TYPE = "tictactoe.board_type";
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mGameOptionButton = (Button) findViewById(R.id.human_v_human);
        mBoardSizeButton = (Button) findViewById(R.id._3x3);
        mPlayButton = (Button) findViewById(R.id.play_button);
        mGameOptions = new Intent(MenuActivity.this, MainActivity.class);
        setGameOptionButton();
        setBoardOptionButton();
        setPlayButton();
    }

    private void setBoardOptionButton() {
        mBoardSizeButton.setOnClickListener(view -> mGameOptions.putExtra(EXTRA_BOARD_TYPE, 3));
    }

    private void setGameOptionButton() {
        mGameOptionButton.setOnClickListener(view -> mGameOptions.putExtra(EXTRA_GAME_TYPE, new String[]{"HUMAN", "HUMAN"}));
    }

    private void setPlayButton() {
        mPlayButton.setOnClickListener(view -> startActivity(mGameOptions));
    }
}
