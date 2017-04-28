package br.cefetmg.mockwithsingleton;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.cefetmg.mockwithsingleton.provider.CalendarUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MockWithSingletonTest {

    private static final String FORMAT_DATE = "dd/MM/yyyy";
    private static final String CURRENT_DATE = "14/04/2017";

    CalendarUtils calendarUtils;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class, false, false);

    private CalendarUtils.CalendarProviderInterface mockCalendarProvider =
            new CalendarUtils.CalendarProviderInterface() {
        @Override
        public Calendar getCurrentCalendar() {
            try {
                Date date = new SimpleDateFormat(FORMAT_DATE).parse(CURRENT_DATE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return calendar;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    @Before
    public void setUp() {
        calendarUtils = CalendarUtils.getInstance();
        calendarUtils.setCalendarProvider(mockCalendarProvider);
        mActivityRule.launchActivity(null);
    }

    @Test
    public void shouldShowCurrentDate() {
        onView(withId(R.id.textview_DataHora)).check(matches(withText(CURRENT_DATE)));
    }

}
