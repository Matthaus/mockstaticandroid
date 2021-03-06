package br.com.matthaus.mockwithdagger2.dagger;

import br.com.matthaus.mockwithdagger2.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules=CalendarUtilsModule.class)
public interface MockWithDagger2Component {
    void inject(MainActivity mainActivity);
}
