package mollie.tictactoe;

import android.support.test.espresso.ViewInteraction;
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

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void canChooseHumanVHumanWithA3x3Board() {
        findButtonById(R.id.human_v_human).perform(click());
        findButtonById(R.id._3x3).perform(click());
        findButtonById(R.id.play_button).perform(click());
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    private ViewInteraction findButtonById(int id) {
        return onView(withId(id));
    }
}
