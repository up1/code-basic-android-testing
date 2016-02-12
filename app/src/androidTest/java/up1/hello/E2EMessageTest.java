package up1.hello;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class E2EMessageTest {

    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();


    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void show_message() {
        //Arrange
        Screengrab.screenshot("show_message_01");
        onView(withId(R.id.firstOperand)).perform(typeText("5"));
        onView(withId(R.id.secondOperand)).perform(typeText("5"));
        Screengrab.screenshot("show_message_02");
        onView(withId(R.id.calculate)).perform(click());
        Screengrab.screenshot("show_message_03");
        onView(withId(R.id.message)).perform(typeText("Hello world"), closeSoftKeyboard());
        Screengrab.screenshot("show_message_04");
        //Act
        onView(withId(R.id.back)).perform(click());
        Screengrab.screenshot("show_message_05");

        //Assert
        onView(withId(R.id.message)).check(matches(withText("Hello world")));
        Screengrab.screenshot("show_message_06");
    }

}
