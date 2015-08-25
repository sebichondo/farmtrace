package net.azurewebsites.api.chemical;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 8/20/15.
 */
public class ChemicalService implements IChemicalService {
    private IApiService apiService;

    @Override
    public void getChemicals(Bus bus) {
        apiService.getChemicals(new RestCallback<List<ChemicalResponse>>(bus) {
        });
    }

    public ChemicalService(IApiService apiService) {
        this.apiService = apiService;
    }
}
