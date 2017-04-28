package br.cefetmg.mockwithsingleton.provider;

import java.util.Calendar;

/**
 * Created by matthaus on 28/04/17.
 */

public class CalendarUtils {

    private static final CalendarUtils instance = new CalendarUtils();
    private CalendarProviderInterface calendarProvider = new CalendarDefaultProvider();

    private CalendarUtils() {
    }

    public static CalendarUtils getInstance() {
        return instance;
    }

    public void setCalendarProvider(CalendarProviderInterface calendarProvider){
        this.calendarProvider = calendarProvider;
    }

    public Calendar getCurrentDate() {
        return this.calendarProvider.getCurrentCalendar();
    }

    public class CalendarDefaultProvider implements CalendarProviderInterface {
        @Override
        public Calendar getCurrentCalendar() {
            return Calendar.getInstance();
        }
    }

    public interface CalendarProviderInterface {
        Calendar getCurrentCalendar();
    }

}
