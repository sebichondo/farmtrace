package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.plantingactivity.IPlantingActivityService;
import net.azurewebsites.api.plantingactivity.PlantingActivityService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 9/11/15.
 */
@Module
public class PlantingActivityServiceModule {
    @Provides
    @MainScope
    IPlantingActivityService providePlantingActivityService(IApiService apiService) {
        return new PlantingActivityService(apiService);
    }
}