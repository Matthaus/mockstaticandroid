package br.com.matthaus.mockwithdagger2.dagger;

import br.com.matthaus.mockwithdagger2.MainActivityTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules=MockedCalendarUtilsModule.class)
public interface MockedMockWithDagger2Component extends MockWithDagger2Component {
    void inject(MainActivityTest mainActivityTest);
}
