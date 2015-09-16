package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.usn.IUSNService;
import net.azurewebsites.api.usn.USNService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 9/12/15.
 */
@Module
public class USNServiceModule {
    @Provides
    @MainScope
    IUSNService provideUSNService(IApiService apiService){
        return new USNService(apiService);
    }
}
