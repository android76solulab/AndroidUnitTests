package com.mobiquity.androidunittests.functionaltests.tests;

import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import com.mobiquity.androidunittests.R;
import com.mobiquity.androidunittests.functionaltests.CalculatorFunctionalTestApplication;
import com.mobiquity.androidunittests.ui.activity.CalculatorActivity;
import com.mobiquity.androidunittests.ui.activity.WolframActivity;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import butterknife.ButterKnife;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.intent.Intents.*;
import static android.support.test.espresso.intent.matcher.IntentMatchers.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class CalculatorActivityTest {

    @Rule
    public IntentsTestRule<CalculatorActivity> activityRule = new IntentsTestRule<>(CalculatorActivity.class);

    @Test
    public void shouldDisplayTypedNumbers() {
        clickAllNumbers();
        onView(withId(R.id.display_input)).check(matches(withText("1234567890")));
    }

    @Test
    public void shouldConcatNumberInput() {
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.add_op)).perform(click());
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.digit_2)).perform(click());
        onView(withId(R.id.display_input)).check(matches(withText("1+12")));
    }

    @Test
    public void shouldShrinkDisplayTextForLargeInput() {
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.add_op)).perform(click());

        EditText displayEditText = ButterKnife.findById(activityRule.getActivity(), R.id.display_input);
        float originalTextSize = displayEditText.getTextSize();

        clickAllNumbers();
        float smallerTextSize = displayEditText.getTextSize();

        Assert.assertTrue("Failed: originalTextSize > smallerTextSize", originalTextSize > smallerTextSize);
    }

    @Test
    public void shouldDisplayOperator_IfThereIsAnOperand() {
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.add_op)).perform(click());
        onView(withId(R.id.display_input)).check(matches(withText("1+")));
    }

    @Test
    public void shouldReplaceOperatorInDisplay_IfThereIsAlreadyAnOperator() {
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.add_op)).perform(click());
        onView(withId(R.id.display_input)).check(matches(withText("1+")));

        onView(withId(R.id.subtract_op)).perform(click());
        onView(withId(R.id.display_input)).check(matches(withText("1-")));
    }

    @Test
    public void onClickWolfram_ShouldGoToWolframActivity() {
        onView(withId(R.id.handle)).perform(click());
        onView(withId(R.id.extra_button_wolfram)).perform(click());

        intending(hasComponent(WolframActivity.class.getName()));
    }

    @After
    public void tearDown() {
        CalculatorFunctionalTestApplication.clear(activityRule.getActivity());
    }

    private void clickAllNumbers() {
        onView(withId(R.id.digit_1)).perform(click());
        onView(withId(R.id.digit_2)).perform(click());
        onView(withId(R.id.digit_3)).perform(click());
        onView(withId(R.id.digit_4)).perform(click());
        onView(withId(R.id.digit_5)).perform(click());
        onView(withId(R.id.digit_6)).perform(click());
        onView(withId(R.id.digit_7)).perform(click());
        onView(withId(R.id.digit_8)).perform(click());
        onView(withId(R.id.digit_9)).perform(click());
        onView(withId(R.id.digit_0)).perform(click());
    }

}