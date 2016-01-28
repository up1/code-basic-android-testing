package up1.hello;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ResultActivityTest {

    @Rule
    public ActivityTestRule<ResultActivity> mResultActivityTestRule =
            new ActivityTestRule<>(ResultActivity.class);

    @Before
    public void initialDataOfIntent() {
        Intent stubIntent = new Intent();
        stubIntent.putExtra(ResultActivity.RESULT, "3");
        mResultActivityTestRule.launchActivity(stubIntent);
    }

    @Test
    public void input_3_should_show_3() {
        onView(withId(R.id.result)).check(matches(withText("3")));
    }
}