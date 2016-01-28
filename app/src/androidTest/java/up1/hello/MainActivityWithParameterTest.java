package up1.hello;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MainActivityWithParameterTest {

    private final String mFirst;
    private final String mOperator;
    private final String mSecond;
    private final String mExpectedResult;

    @Parameters
    public static Iterable<Object[]> initData() {
        return Arrays.asList(
                new Object[][]{
                        {"5", "+", "3", "8"},
                        {"15", "+", "3", "18"},
                        {"5", "+", "2", "7"},
                }
        );
    }


    public MainActivityWithParameterTest(String first,
                                         String operator,
                                         String second,
                                         String expectedResult) {
        mFirst = first;
        mOperator = operator;
        mSecond = second;
        mExpectedResult = expectedResult;
    }

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void flow_of_calculate_number_with_operators() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText(mFirst));
        onView(withId(R.id.secondOperand))
                .perform(typeText(mSecond));

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText(mExpectedResult)));
    }

}
