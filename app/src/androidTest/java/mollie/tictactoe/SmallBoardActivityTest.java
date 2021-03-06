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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MobileGameConstructor.EXTRA_PLAYER_TYPES;
import static mollie.tictactoe.MobilePlayers.MOBILE;
import static ttt.PlayerType.RANDOM;

@RunWith(AndroidJUnit4.class)
public class SmallBoardActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(SmallBoardActivity.class, true, false);

    @Test
    public void canWinAGame() {
        startActivity(MOBILE, MOBILE, false);
        clickButton(R.id.left_top_corner);
        clickButton(R.id.left_centre);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_button);
        clickButton(R.id.right_top_corner);
        onView(withText("X wins!")).check(matches(isDisplayed()));
    }

    @Test
    public void canDrawAGame() {
        startActivity(MOBILE, MOBILE, false);
        clickButton(R.id.left_top_corner);
        clickButton(R.id.centre_button);
        clickButton(R.id.left_centre);
        clickButton(R.id.left_bottom);
        clickButton(R.id.right_top_corner);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_bottom);
        clickButton(R.id.right_bottom);
        clickButton(R.id.right_centre);
        onView(withText("It's a draw!")).check(matches(isDisplayed()));
    }

    @Test
    public void promptsUserToPlayAgain() {
        startActivity(MOBILE, MOBILE, false);
        clickButton(R.id.left_top_corner);
        clickButton(R.id.left_centre);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_button);
        clickButton(R.id.right_top_corner);
        onView(withText("Would you like to play again?")).check(matches(isDisplayed()));
    }

    @Test
    public void showsAComputerMove() {
        startActivity(MOBILE, RANDOM, true);
        clickButton(R.id.left_top_corner);
        onView(withText("O")).check(matches(isDisplayed()));
    }

    private void startActivity(String player1, String player2, boolean isAComputerGame) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, SmallBoardActivity.class);
        intent.putExtra(EXTRA_PLAYER_TYPES, new String[]{player1, player2});
        intent.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
        mActivityRule.launchActivity(intent);
    }

    public static void clickButton(int id) {
        onView(withId(id)).perform(click());
    }
}
