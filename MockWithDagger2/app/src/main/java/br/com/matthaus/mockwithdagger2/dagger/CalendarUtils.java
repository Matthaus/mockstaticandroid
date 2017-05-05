package br.com.matthaus.mockwithdagger2.dagger;

import java.util.Calendar;

import javax.inject.Singleton;

@Singleton
public class CalendarUtils {

    public Calendar getCurrentDate() {
        return Calendar.getInstance();
    }

}
