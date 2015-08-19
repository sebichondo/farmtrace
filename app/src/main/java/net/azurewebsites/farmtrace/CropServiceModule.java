package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.crop.CropService;
import net.azurewebsites.api.crop.ICropService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/18/15.
 */

@Module
public class CropServiceModule {
    @Provides
    @MainScope
    ICropService provideCropService(IApiService apiService){
        return new CropService(apiService);
    }
}
