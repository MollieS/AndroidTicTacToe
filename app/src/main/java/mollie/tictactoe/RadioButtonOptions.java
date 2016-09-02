package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

import static mollie.tictactoe.GamePlayHelper.EXTRA_COMPUTER_FIRST;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_PLAYER_TYPES;
import static mollie.tictactoe.MobilePlayers.MOBILE;
import static ttt.PlayerType.PERFECT;
import static ttt.PlayerType.RANDOM;

public class RadioButtonOptions {

    public static Intent getIntentForGameOptions(View view, Intent intent) {
        boolean checked = ((RadioButton) view).isChecked();
        setDefaultValues(intent);
        switch (view.getId()) {
            case R.id.human_v_human:
                setPlayerTypes(checked, MOBILE, MOBILE, intent);
                setGameInteractivity(intent, false);
                break;
            case R.id.human_v_random:
                setPlayerTypes(checked, MOBILE, RANDOM, intent);
                break;
            case R.id.human_v_perfect:
                setPlayerTypes(checked, MOBILE, PERFECT, intent);
                break;
            case R.id.random_v_human:
                setPlayerTypes(checked, RANDOM, MOBILE, intent);
                setComputerIsFirst(intent, true);
                break;
            case R.id.perfect_v_human:
                setPlayerTypes(checked, PERFECT, MOBILE, intent);
                setComputerIsFirst(intent, true);
                break;
        }
        return intent;
    }

    public static Intent formatIntentForBoardOptions(View view, Intent intent, Context context) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id._3x3:
                if (checked) {
                    intent.putExtra(MobileGameConstructor.EXTRA_BOARD_TYPE, 3);
                    intent.setClass(context, SmallBoardActivity.class);
                }
                break;
            case R.id._4x4:
                if (checked) {
                    intent.putExtra(MobileGameConstructor.EXTRA_BOARD_TYPE, 4);
                    intent.setClass(context, BigBoardActivity.class);
                }
                break;
        }
        return intent;
    }

    private static void setDefaultValues(Intent intent) {
        setGameInteractivity(intent, true);
        setComputerIsFirst(intent, false);
    }

    private static void setGameInteractivity(Intent intent, boolean isAComputerGame) {
        intent.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
    }

    private static void setPlayerTypes(boolean checked, String player1, String player2, Intent intent) {
        if (checked) {
            String[] playerTypes = new String[]{player1, player2};
            intent.putExtra(EXTRA_PLAYER_TYPES, playerTypes);
        }
    }

    public static void setComputerIsFirst(Intent intent, boolean computerIsFirst) {
        intent.putExtra(EXTRA_COMPUTER_FIRST, computerIsFirst);
    }
}
