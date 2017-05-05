package br.com.matthaus.mockwithdagger2;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import br.com.matthaus.mockwithdagger2.dagger.CalendarUtils;
import br.com.matthaus.mockwithdagger2.dagger.MockWithDagger2Application;
import br.com.matthaus.mockwithdagger2.dagger.MockedMockWithDagger2Component;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
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
        MockWithDagger2Application application =
                (MockWithDagger2Application)
                        InstrumentationRegistry.getTargetContext().getApplicationContext();
        MockedMockWithDagger2Component component =
                (MockedMockWithDagger2Component) application.component();
        component.inject(this);

        Mockito.when(calendarUtils.getCurrentDate()).thenReturn(generateCurrentDate());

        mActivityRule.launchActivity(null);
    }

    @Test
    public void shouldShowCurrentDate() {
        onView(withId(R.id.textview_DataHora)).check(matches(withText(CURRENT_DATE)));
    }

    private static Calendar generateCurrentDate() {
        try {
            Date date = new SimpleDateFormat(FORMAT_DATE).parse(CURRENT_DATE);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }

}
