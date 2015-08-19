package net.azurewebsites.farmtrace;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/14/15.
 */
@Module
public class UIModule {
    @Provides
    @ApplicationScope
    AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }
}
