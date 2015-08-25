package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.chemical.ChemicalService;
import net.azurewebsites.api.chemical.IChemicalService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/20/15.
 */
@Module
public class ChemicalServiceModule {
    @Provides
    @MainScope
    IChemicalService provideChemicalService(IApiService apiService){
        return new ChemicalService(apiService);
    }
}