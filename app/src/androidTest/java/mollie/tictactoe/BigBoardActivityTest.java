package mollie.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_BOARD_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_PLAYER_TYPES;
import static mollie.tictactoe.MobilePlayers.MOBILE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ttt.PlayerType.PERFECT;
import static ttt.PlayerType.RANDOM;

@RunWith(AndroidJUnit4.class)
public class BigBoardActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(BigBoardActivity.class, true, false);

    @Test
    public void canWinAGame() {
        startActivity(MOBILE, MOBILE, false, false);
        clickButton(R.id.top_left);
        clickButton(R.id.top_right);
        clickButton(R.id.second_left);
        clickButton(R.id.second_right);
        clickButton(R.id.third_left);
        clickButton(R.id.third_right);
        clickButton(R.id.bottom_left);
        onView(withText("X wins!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void showsAComputerWin() {
        startActivity(PERFECT, MOBILE, true, true);
        clickButton(R.id.bottom_left);
        clickButton(R.id.bottom_mid_left);
        clickButton(R.id.bottom_mid_right);
        onView(withText("X wins!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void showsAComputerMove() {
        startActivity(MOBILE, RANDOM, true, false);
        clickButton(R.id.top_right);
        onView(withText("O")).check(matches(isDisplayed()));
    }

    private void startActivity(String player1, String player2, boolean isAComputerGame, boolean isComputerFirst) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, BigBoardActivity.class);
        intent.putExtra(EXTRA_BOARD_TYPE, 4);
        intent.putExtra(EXTRA_PLAYER_TYPES, new String[]{player1, player2});
        intent.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
        intent.putExtra(GamePlayHelper.EXTRA_COMPUTER_FIRST, isComputerFirst);
        mActivityRule.launchActivity(intent);
    }

    public static void clickButton(int id) {
        onView(withId(id)).perform(click());
    }
}
