package net.azurewebsites.api.crop;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by sebichondo on 8/18/15.
 */
public class CropService implements ICropService {
    private IApiService apiService;

    @Inject
    public CropService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getCrops(Bus bus) {
        apiService.getCrops(new RestCallback<List<CropResponse>>(bus) {
        });
    }
}
