package net.azurewebsites.farmtrace;

import net.azurewebsites.api.APIServicesModule;

import dagger.Component;

/**
 * Created by sebichondo on 8/14/15.
 */

@MainScope
@Component(
        dependencies = AppComponent.class,
        modules = {FarmerServiceModule.class,
                APIServicesModule.class,
                CropServiceModule.class,
                GroupServiceModule.class
        }
)
public interface MainComponent {
    void inject(MainActivity activity);
}
