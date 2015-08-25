package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.plantingseason.IPlantingSeasonService;
import net.azurewebsites.api.plantingseason.PlantingSeasonService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/19/15.
 */
@Module
public class PlantingSeasonServiceModule {
    @Provides
    @MainScope
    IPlantingSeasonService providePlantingSeasonsService(IApiService apiService){
        return new PlantingSeasonService(apiService);
    }
}