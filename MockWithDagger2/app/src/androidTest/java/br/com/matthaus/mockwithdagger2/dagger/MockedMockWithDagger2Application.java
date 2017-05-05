package br.com.matthaus.mockwithdagger2.dagger;


public class MockedMockWithDagger2Application extends MockWithDagger2Application {
    @Override
    public MockWithDagger2Component createComponent() {
        return DaggerMockedMockWithDagger2Component.builder().build();
    }
}
