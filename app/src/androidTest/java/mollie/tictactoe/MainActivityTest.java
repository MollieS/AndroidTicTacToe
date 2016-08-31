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
import static mollie.tictactoe.AndroidPlayerType.HUMAN;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ttt.PlayerType.RANDOM;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String EXTRA_PLAYER_TYPES = "mollie.tictactoe.player_types";
    private static final String EXTRA_GAME_TYPE = "mollie.tictactoe.game_type";

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void canWinAGame() {
        startActivity(HUMAN, HUMAN, false);
        clickButton(R.id.left_top_corner);
        clickButton(R.id.left_centre);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_button);
        clickButton(R.id.right_top_corner);
        onView(withText("X wins!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void canDrawAGame() {
        startActivity(HUMAN, HUMAN, false);
        clickButton(R.id.left_top_corner);
        clickButton(R.id.centre_button);
        clickButton(R.id.left_centre);
        clickButton(R.id.left_bottom);
        clickButton(R.id.right_top_corner);
        clickButton(R.id.top_centre);
        clickButton(R.id.centre_bottom);
        clickButton(R.id.right_bottom);
        clickButton(R.id.right_centre);
        onView(withText("It's a draw!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void showsAComputerMove() {
        startActivity(HUMAN, RANDOM, true);
        clickButton(R.id.left_top_corner);
        onView(withText("O")).check(matches(isDisplayed()));
    }

    private void startActivity(String player1, String player2, boolean isAComputerGame) {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, MainActivity.class);
        intent.putExtra(EXTRA_PLAYER_TYPES, new String[]{player1, player2});
        intent.putExtra(EXTRA_GAME_TYPE, isAComputerGame);
        mActivityRule.launchActivity(intent);
    }

    public static void clickButton(int id) {
        onView(withId(id)).perform(click());
    }
}
