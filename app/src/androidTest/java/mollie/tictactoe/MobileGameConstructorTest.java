package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ttt.game.GameEngine;

import static junit.framework.Assert.assertEquals;
import static mollie.tictactoe.MobilePlayers.MOBILE;

@RunWith(AndroidJUnit4.class)
public class MobileGameConstructorTest {

    @Test
    public void createsAGameFromAnIntent() {
        Intent intent = createIntent();
        intent.putExtra(MobileGameConstructor.EXTRA_BOARD_TYPE, 3);
        intent.putExtra(MobileGameConstructor.EXTRA_PLAYER_TYPES, new String[]{MOBILE, MOBILE});

        GameEngine game = MobileGameConstructor.getGame(intent);

        assertEquals(9, game.showBoard().size());
        assertEquals(MobilePlayer.class, game.getCurrentPlayer().getClass());
    }

    @NonNull
    private Intent createIntent() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        return new Intent(context, SmallBoardActivity.class);
    }
}
