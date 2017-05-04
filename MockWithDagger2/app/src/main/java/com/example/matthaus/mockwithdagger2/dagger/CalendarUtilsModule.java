package com.example.matthaus.mockwithdagger2.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CalendarUtilsModule {
    @Provides
    @Singleton
    CalendarUtils provideCalendarUtils() {
        return new CalendarUtils();
    }
}
