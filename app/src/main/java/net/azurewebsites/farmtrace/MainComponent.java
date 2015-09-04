package net.azurewebsites.farmtrace;

import net.azurewebsites.api.APIServicesModule;
import net.azurewebsites.farmtrace.farmingactivity.FarmingDashboardActivity;

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
                GroupServiceModule.class,
                FieldServiceModule.class,
                PlantingSeasonServiceModule.class,
                FertilizerServiceModule.class,
                ChemicalServiceModule.class,
                SeedServiceModule.class
        }
)
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(FarmingDashboardActivity activity);

}
