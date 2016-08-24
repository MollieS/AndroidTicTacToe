package com.example.molliestephenson.tictactoe;

<<<<<<< HEAD
import android.support.test.espresso.ViewInteraction;
=======
>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

<<<<<<< HEAD
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
=======
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

<<<<<<< HEAD
=======
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canWinAGame() {
<<<<<<< HEAD
        findButtonById(R.id.left_top_corner).perform(click());
        findButtonById(R.id.left_centre).perform(click());
        findButtonById(R.id.top_centre).perform(click());
        findButtonById(R.id.centre_button).perform(click());
        findButtonById(R.id.right_top_corner).perform(click());
=======
        onView(withId(R.id.left_top_corner)).perform(click());
        onView(withId(R.id.left_centre)).perform(click());
        onView(withId(R.id.top_centre)).perform(click());
        onView(withId(R.id.centre_button)).perform(click());
        onView(withId(R.id.right_top_corner)).perform(click());
>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
        onView(withText("X wins!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void canDrawAGame() {
<<<<<<< HEAD
        findButtonById(R.id.left_top_corner).perform(click());
        findButtonById(R.id.centre_button).perform(click());
        findButtonById(R.id.left_centre).perform(click());
        findButtonById(R.id.left_bottom).perform(click());
        findButtonById(R.id.right_top_corner).perform(click());
        findButtonById(R.id.top_centre).perform(click());
        findButtonById(R.id.centre_bottom).perform(click());
        findButtonById(R.id.right_bottom).perform(click());
        findButtonById(R.id.right_centre).perform(click());
=======
        onView(withId(R.id.left_top_corner)).perform(click());
        onView(withId(R.id.centre_button)).perform(click());
        onView(withId(R.id.left_centre)).perform(click());
        onView(withId(R.id.left_bottom)).perform(click());
        onView(withId(R.id.right_top_corner)).perform(click());
        onView(withId(R.id.top_centre)).perform(click());
        onView(withId(R.id.centre_bottom)).perform(click());
        onView(withId(R.id.right_bottom)).perform(click());
        onView(withId(R.id.right_centre)).perform(click());
>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
        onView(withText("It's a draw!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
<<<<<<< HEAD

    private ViewInteraction findButtonById(int id) {
       return onView(withId(id));
    }
=======
>>>>>>> 07046df47569234e0a85f27e440b1a8b6e11a3a7
}
