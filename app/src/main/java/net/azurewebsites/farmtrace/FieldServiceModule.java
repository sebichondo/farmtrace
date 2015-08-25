package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.field.FieldService;
import net.azurewebsites.api.field.IFieldService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/19/15.
 */
@Module
public class FieldServiceModule {
    @Provides
    @MainScope
    IFieldService provideFieldService(IApiService apiService){
        return new FieldService(apiService);
    }
}