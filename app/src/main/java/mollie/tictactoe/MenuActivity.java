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
    private static final String EXTRA_COMPUTER_FIRST = "mollie.tictactoe.computer_first";
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
                setPlayerTypes(checked, HUMAN, HUMAN);
                setGameInteractivity(false);
                setComputerIsFirst(false);
                break;
            case R.id.human_v_random:
                setPlayerTypes(checked, HUMAN, RANDOM);
                setGameInteractivity(true);
                setComputerIsFirst(false);
                break;
            case R.id.human_v_perfect:
                setPlayerTypes(checked, HUMAN, PERFECT);
                setGameInteractivity(true);
                setComputerIsFirst(false);
                break;
            case R.id.random_v_human:
                setPlayerTypes(checked, RANDOM, HUMAN);
                setGameInteractivity(true);
                setComputerIsFirst(true);
                break;
            case R.id.perfect_v_human:
                setPlayerTypes(checked, PERFECT, HUMAN);
                setGameInteractivity(true);
                setComputerIsFirst(true);
                break;
        }
        mGameOptions.putExtra(EXTRA_PLAYER_TYPES, mPlayerTypes);
    }

    private void setGameInteractivity(boolean isAComputerGame) {
        mGameOptions.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
    }

    private void setPlayerTypes(boolean checked, String player1, String player2) {
        if (checked) {
            mPlayerTypes = new String[]{player1, player2};
        }
    }

    public void setComputerIsFirst(boolean computerIsFirst) {
        mGameOptions.putExtra(EXTRA_COMPUTER_FIRST, computerIsFirst);
    }
}
