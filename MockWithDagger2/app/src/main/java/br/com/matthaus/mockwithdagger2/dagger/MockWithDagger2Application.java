package br.com.matthaus.mockwithdagger2.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

public class MockWithDagger2Application extends Application {
    @Singleton
    @Component(modules = CalendarUtilsModule.class)
    public interface ApplicationComponent extends MockWithDagger2Component {
    }

    private final MockWithDagger2Component component = createComponent();

    public MockWithDagger2Component createComponent(){
        return DaggerMockWithDagger2Application_ApplicationComponent.builder().build();
    }

    public MockWithDagger2Component component() {
        return component;
    }

}
