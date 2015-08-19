package net.azurewebsites.api.farmer;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sebichondo on 8/13/15.
 */

public class FarmerService implements IFarmerService {
    private IApiService apiService;

    @Inject
    public FarmerService(IApiService apiService) {
        this.apiService = apiService;
    }


    @Override
    public void getFarmers(Bus bus) {
        apiService.getFarmers(new RestCallback<List<FarmerResponse>>(bus) { });
    }
}
