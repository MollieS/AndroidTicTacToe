package mollie.tictactoe;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static mollie.tictactoe.AndroidPlayerType.HUMAN;
import static mollie.tictactoe.MainActivity.*;
import static mollie.tictactoe.MainActivityTest.clickButton;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static ttt.PlayerType.PERFECT;
import static ttt.PlayerType.RANDOM;

@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public IntentsTestRule<MenuActivity> mIntentsTestRule = new IntentsTestRule<>(MenuActivity.class);

    @Test
    public void canChooseHumanVHumanWithA3x3Board() {
        clickButton(R.id.human_v_human);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(toPackage("mollie.tictactoe"));
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void addsHumanVHumanExtrasToIntent() {
        clickButton(R.id.human_v_human);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(allOf(
                hasExtras(allOf(
                        hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(3)),
                        hasEntry(equalTo(EXTRA_PLAYER_TYPES), equalTo(new String[]{HUMAN, HUMAN})),
                        hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(false)),
                        hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(false)))),
                toPackage("mollie.tictactoe")));
    }

    @Test
    public void canChooseHumanVRandomComputerGame() {
        clickButton(R.id.human_v_random);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void addsHumanVRandomComputerExtrasToIntent() {
        clickButton(R.id.human_v_random);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(allOf(
                hasExtras(allOf(
                        hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(3)),
                        hasEntry(equalTo(EXTRA_PLAYER_TYPES), equalTo(new String[]{HUMAN, RANDOM})),
                        hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(false)),
                        hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(true)))),
                toPackage("mollie.tictactoe")));
    }

    @Test
    public void canChooseHumanVPerfectComputerGame() {
        clickButton(R.id.human_v_perfect);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void addsHumanVPerfectComputerExtrasToIntent() {
        clickButton(R.id.human_v_perfect);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(allOf(
                hasExtras(allOf(
                        hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(3)),
                        hasEntry(equalTo(EXTRA_PLAYER_TYPES), equalTo(new String[]{HUMAN, PERFECT})),
                        hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(false)),
                        hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(true)))),
                toPackage("mollie.tictactoe")));
    }

    @Test
    public void addsRandomVHumanExtrasToIntent() {
        clickButton(R.id.random_v_human);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(allOf(
                hasExtras(allOf(
                        hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(3)),
                        hasEntry(equalTo(EXTRA_PLAYER_TYPES), equalTo(new String[]{RANDOM, HUMAN})),
                        hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(true)),
                        hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(true)))),
                toPackage("mollie.tictactoe")));
    }

    @Test
    public void addsPerfectVHumanExtrasToIntent() {
        clickButton(R.id.perfect_v_human);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
        intended(allOf(
                hasExtras(allOf(
                        hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(3)),
                        hasEntry(equalTo(EXTRA_PLAYER_TYPES), equalTo(new String[]{PERFECT, HUMAN})),
                        hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(true)),
                        hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(true)))),
                toPackage("mollie.tictactoe")));
    }
}
