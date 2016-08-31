package mollie.tictactoe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static mollie.tictactoe.AndroidPlayerType.HUMAN;
import static mollie.tictactoe.MainActivity.EXTRA_BOARD_TYPE;
import static mollie.tictactoe.MainActivity.EXTRA_COMPUTER_FIRST;
import static mollie.tictactoe.MainActivity.EXTRA_GAME_TYPE;
import static mollie.tictactoe.MainActivity.EXTRA_PLAYER_TYPES;
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
    public void choosingAGameRedirectsToMainPage() {
        chooseGame(R.id.human_v_human);
        onView(withId(R.id.board)).check(matches(isDisplayed()));
    }

    @Test
    public void addsHumanVHumanExtrasToIntent() {
        chooseGame(R.id.human_v_human);
        intended(allOf(
                hasExtras(allOf(
                        hasBoardType(3),
                        hasPlayerTypes(HUMAN, HUMAN),
                        hasComputerFirstBoolean(false),
                        hasComputerGameBoolean(false)))));
    }

    @Test
    public void addsHumanVRandomComputerExtrasToIntent() {
        chooseGame(R.id.human_v_random);
        intended(allOf(
                hasExtras(allOf(
                        hasBoardType(3),
                        hasPlayerTypes(HUMAN, RANDOM),
                        hasComputerFirstBoolean(false),
                        hasComputerGameBoolean(true)))));
    }

    @Test
    public void addsHumanVPerfectComputerExtrasToIntent() {
        chooseGame(R.id.human_v_perfect);
        intended(allOf(
                hasExtras(allOf(
                        hasBoardType(3),
                        hasPlayerTypes(HUMAN, PERFECT),
                        hasComputerFirstBoolean(false),
                        hasComputerGameBoolean(true)))));
    }


    @Test
    public void addsRandomVHumanExtrasToIntent() {
        chooseGame(R.id.random_v_human);
        intended(allOf(
                hasExtras(allOf(
                        hasBoardType(3),
                        hasPlayerTypes(RANDOM, HUMAN),
                        hasComputerFirstBoolean(true),
                        hasComputerGameBoolean(true)))));
    }

    @Test
    public void addsPerfectVHumanExtrasToIntent() {
        chooseGame(R.id.perfect_v_human);
        intended(allOf(
                hasExtras(allOf(
                        hasBoardType(3),
                        hasPlayerTypes(PERFECT, HUMAN),
                        hasComputerFirstBoolean(true),
                        hasComputerGameBoolean(true)))));
    }

    private void chooseGame(int gameType) {
        clickButton(gameType);
        clickButton(R.id._3x3);
        clickButton(R.id.play_button);
    }

    @NonNull
    private Matcher<Bundle> hasPlayerTypes(String player1, String player2) {
        return hasPlayerTypes(equalTo(new String[]{player1, player2}));
    }

    @NonNull
    private Matcher<Bundle> hasPlayerTypes(Matcher<String[]> valueMatcher) {
        return hasEntry(equalTo(EXTRA_PLAYER_TYPES), valueMatcher);
    }

    @NonNull
    private Matcher<Bundle> hasBoardType(int size) {
        return hasEntry(equalTo(EXTRA_BOARD_TYPE), equalTo(size));
    }

    @NonNull
    private Matcher<Bundle> hasComputerGameBoolean(boolean isAComputerGame) {
        return hasEntry(equalTo(EXTRA_GAME_TYPE), equalTo(isAComputerGame));
    }

    @NonNull
    private Matcher<Bundle> hasComputerFirstBoolean(boolean computerMovesFirst) {
        return hasEntry(equalTo(EXTRA_COMPUTER_FIRST), equalTo(computerMovesFirst));
    }
}
