package net.azurewebsites.farmtrace;

import android.app.Application;

import dagger.Component;

/**
 * Created by sebichondo on 8/14/15.
 */
@ApplicationScope
@Component(modules = {AppModule.class, UIModule.class})
public interface AppComponent extends AppGraph {
    /**
     * An initializer that creates the graph from an application.
     */
    final static class Initializer {
        static AppComponent init(FarmTraceApp app) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
        }

        private Initializer() {
        } // No instances.
    }

    Application provideApplication();
}
