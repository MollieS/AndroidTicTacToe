package mollie.tictactoe;

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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canWinAGame() {
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

    public static void clickButton(int id) {
        onView(withId(id)).perform(click());
    }

}
