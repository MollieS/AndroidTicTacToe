package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import static mollie.tictactoe.AndroidPlayerType.*;

public class MenuActivity extends AppCompatActivity {

    private Button mBoardSizeButton;
    private Intent mGameOptions;
    private String[] mPlayerTypes;
    private static final String EXTRA_PLAYER_TYPES = "mollie.tictactoe.player_types";
    private static final String EXTRA_BOARD_TYPE = "mollie.tictactoe.board_type";
    private static final String EXTRA_GAME_TYPE = "mollie.tictactoe.game_type";
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mBoardSizeButton = (Button) findViewById(R.id._3x3);
        mPlayButton = (Button) findViewById(R.id.play_button);
        mGameOptions = new Intent(MenuActivity.this, MainActivity.class);
        setBoardOptionButton();
        setPlayButton();
    }

    private void setBoardOptionButton() {
        mBoardSizeButton.setOnClickListener(view -> mGameOptions.putExtra(EXTRA_BOARD_TYPE, 3));
    }

    private void setPlayButton() {
        mPlayButton.setOnClickListener(view -> startActivity(mGameOptions));
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.human_v_human:
                if (checked) {
                    mPlayerTypes = new String[]{HUMAN, HUMAN};
                    mGameOptions.putExtra(EXTRA_PLAYER_TYPES, mPlayerTypes);
                    mGameOptions.putExtra(EXTRA_GAME_TYPE, false);
                }
                break;
            case R.id.human_v_random:
                if (checked) {
                    mPlayerTypes = new String[]{HUMAN, RANDOM};
                    mGameOptions.putExtra(EXTRA_PLAYER_TYPES, mPlayerTypes);
                    mGameOptions.putExtra(EXTRA_GAME_TYPE, true);
                }
                break;
        }
    }
}
