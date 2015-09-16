package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.fertilizer.FertilizerService;
import net.azurewebsites.api.fertilizer.IFertilizerService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/20/15.
 */
@Module
public class FertilizerServiceModule {
    @Provides
    @MainScope
    IFertilizerService provideFertilizerrService(IApiService apiService) {
        return new FertilizerService(apiService);
    }
}
