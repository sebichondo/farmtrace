package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.farmer.FarmerService;
import net.azurewebsites.api.farmer.IFarmerService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/13/15.
 */

@Module
public class FarmerServiceModule {
    @Provides
    @MainScope
    IFarmerService provideFarmerService(IApiService apiService) {
        return new FarmerService(apiService);
    }
}
