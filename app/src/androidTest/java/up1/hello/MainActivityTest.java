package up1.hello;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void plus() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText("2"));
        onView(withId(R.id.secondOperand))
                .perform(typeText("3"));

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("5")));
    }

    @Test
    public void minus() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText("2"));
        onView(withId(R.id.secondOperand))
                .perform(typeText("3"));
        onView(withId(R.id.minus)).perform(click());

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("-1")));
    }

    @Test
    public void multiply() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText("3"));
        onView(withId(R.id.secondOperand))
                .perform(typeText("3"));
        onView(withId(R.id.multiply)).perform(click());

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("9")));
    }

    @Test
    public void divide() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText("3"));
        onView(withId(R.id.secondOperand))
                .perform(typeText("3"));
        onView(withId(R.id.divide)).perform(click());

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("1")));
    }

    @Test
    public void divide_by_zero_should_show_NaN() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText("3"));
        onView(withId(R.id.secondOperand))
                .perform(typeText("0"));
        onView(withId(R.id.divide)).perform(click());

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText("NaN")));
    }

}








