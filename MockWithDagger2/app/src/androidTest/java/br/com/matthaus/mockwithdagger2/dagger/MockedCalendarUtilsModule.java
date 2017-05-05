package br.com.matthaus.mockwithdagger2.dagger;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockedCalendarUtilsModule {
    @Provides
    @Singleton
    CalendarUtils provideCalendarUtils() {
        return Mockito.mock(CalendarUtils.class);
    }
}
