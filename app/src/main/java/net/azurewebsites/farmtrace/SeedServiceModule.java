package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.seed.ISeedService;
import net.azurewebsites.api.seed.SeedService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/20/15.
 */
@Module
public class SeedServiceModule {
    @Provides
    @MainScope
    ISeedService provideSeedsService(IApiService apiService) {
        return new SeedService(apiService);
    }
}