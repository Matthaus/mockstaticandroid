package com.example.matthaus.mockwithdagger2.dagger;

import android.support.test.rule.ActivityTestRule;

import com.example.matthaus.mockwithdagger2.MainActivity;
import com.example.matthaus.mockwithdagger2.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    private static final String FORMAT_DATE = "dd/MM/yyyy";
    private static final String CURRENT_DATE = "14/04/2017";

    @Inject
    CalendarUtils calendarUtils;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class, false, false);

    @Before
    public void setUp() {
        mActivityRule.launchActivity(null);
    }

    @Test
    public void shouldShowCurrentDate() {
        onView(withId(R.id.textview_DataHora)).check(matches(withText(CURRENT_DATE)));
    }

}
