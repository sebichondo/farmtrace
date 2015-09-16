package net.azurewebsites.farmtrace;

import net.azurewebsites.api.APIServicesModule;
import net.azurewebsites.farmtrace.farmingactivity.FarmingDashboardActivity;
import net.azurewebsites.farmtrace.farmingactivity.MainFarmingActivity;
import net.azurewebsites.farmtrace.planting.PlantingActivity;
import net.azurewebsites.farmtrace.syncadapter.accounts.adapters.FarmTraceSyncAdapter;

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
                SeedServiceModule.class,
                UserServiceModule.class,
                PlantingActivityServiceModule.class,
                USNServiceModule.class
        }
)
public interface MainComponent {
    void inject(MainActivity activity);

    void inject(MainFarmingActivity activity);

    void inject(FarmingDashboardActivity activity);

    void inject(LoginActivity activity);

    void inject(PlantingActivity activity);

    void inject(FarmTraceSyncAdapter adapter);
}
