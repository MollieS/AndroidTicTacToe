package com.example.molliestephenson.tictactoe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void canWinAGame() {
        onView(withId(R.id.left_top_corner)).perform(click());
        onView(withId(R.id.left_centre)).perform(click());
        onView(withId(R.id.top_centre)).perform(click());
        onView(withId(R.id.centre_button)).perform(click());
        onView(withId(R.id.right_top_corner)).perform(click());
        onView(withText("X wins!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    @Test
    public void canDrawAGame() {
        onView(withId(R.id.left_top_corner)).perform(click());
        onView(withId(R.id.centre_button)).perform(click());
        onView(withId(R.id.left_centre)).perform(click());
        onView(withId(R.id.left_bottom)).perform(click());
        onView(withId(R.id.right_top_corner)).perform(click());
        onView(withId(R.id.top_centre)).perform(click());
        onView(withId(R.id.centre_bottom)).perform(click());
        onView(withId(R.id.right_bottom)).perform(click());
        onView(withId(R.id.right_centre)).perform(click());
        onView(withText("It's a draw!"))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
