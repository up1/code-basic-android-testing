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
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculationWithDivideOperatorTest {

    private final String mFirst;
    private final String mSecond;
    private final String mExpectedResult;

    @Parameters
    public static Iterable<Object[]> initData() {
        return Arrays.asList(
                new Object[][]{
                        {"5", "5", "1"},
                        {"15", "3", "5"},
                        {"6", "2", "3"},
                        {"6", "0", "NaN"},
                }
        );
    }


    public CalculationWithDivideOperatorTest(String first,
                                             String second,
                                             String expectedResult) {
        mFirst = first;
        mSecond = second;
        mExpectedResult = expectedResult;
    }

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void flow_of_calculate_number() {
        //Arrange
        onView(withId(R.id.firstOperand))
                .perform(typeText(mFirst));
        onView(withId(R.id.secondOperand))
                .perform(typeText(mSecond));
        onView(withId(R.id.divide)).perform(click());

        //Act
        onView(withId(R.id.calculate)).perform(click());

        //Assert
        onView(withId(R.id.result)).check(matches(withText(mExpectedResult)));
    }

}
