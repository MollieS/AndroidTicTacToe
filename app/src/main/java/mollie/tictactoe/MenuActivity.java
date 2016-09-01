package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import static mollie.tictactoe.MobilePlayerTypes.HUMAN;
import static mollie.tictactoe.MobilePlayerTypes.PERFECT;
import static mollie.tictactoe.MobilePlayerTypes.RANDOM;
import static mollie.tictactoe.GamePlayHelper.*;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_BOARD_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_PLAYER_TYPES;

public class MenuActivity extends AppCompatActivity {

    private Intent mGameOptions;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mPlayButton = (Button) findViewById(R.id.play_button);
        mGameOptions = new Intent(MenuActivity.this, SmallBoardActivity.class);
        setPlayButton();
    }

    private void setPlayButton() {
        mPlayButton.setOnClickListener(view -> startActivity(mGameOptions));
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        setGameInteractivity(true);
        setComputerIsFirst(false);
        switch (view.getId()) {
            case R.id.human_v_human:
                setPlayerTypes(checked, HUMAN, HUMAN);
                setGameInteractivity(false);
                break;
            case R.id.human_v_random:
                setPlayerTypes(checked, HUMAN, RANDOM);
                break;
            case R.id.human_v_perfect:
                setPlayerTypes(checked, HUMAN, PERFECT);
                break;
            case R.id.random_v_human:
                setPlayerTypes(checked, RANDOM, HUMAN);
                setComputerIsFirst(true);
                break;
            case R.id.perfect_v_human:
                setPlayerTypes(checked, PERFECT, HUMAN);
                setComputerIsFirst(true);
                break;
        }
    }

    public void onBoardSizeSelected(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id._3x3:
                if (checked) {
                    mGameOptions.putExtra(EXTRA_BOARD_TYPE, 3);
                    mGameOptions.setClass(MenuActivity.this, SmallBoardActivity.class);
                }
                break;
            case R.id._4x4:
                if (checked) {
                    mGameOptions.putExtra(EXTRA_BOARD_TYPE, 4);
                    mGameOptions.setClass(MenuActivity.this, BigBoardActivity.class);
                }
                break;
        }
    }

    private void setGameInteractivity(boolean isAComputerGame) {
        mGameOptions.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
    }

    private void setPlayerTypes(boolean checked, String player1, String player2) {
        if (checked) {
            String[] playerTypes = new String[]{player1, player2};
            mGameOptions.putExtra(EXTRA_PLAYER_TYPES, playerTypes);
        }
    }

    public void setComputerIsFirst(boolean computerIsFirst) {
        mGameOptions.putExtra(EXTRA_COMPUTER_FIRST, computerIsFirst);
    }
}
