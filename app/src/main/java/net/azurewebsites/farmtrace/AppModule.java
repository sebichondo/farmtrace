package net.azurewebsites.farmtrace;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/13/15.
 */
@Module
public class AppModule {
    private final FarmTraceApp app;

    public AppModule(FarmTraceApp app) {
        this.app = app;
    }

    @Provides
    @ApplicationScope
    Application provideApplication() {
        return app;
    }
}
