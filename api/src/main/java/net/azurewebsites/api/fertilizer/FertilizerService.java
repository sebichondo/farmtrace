package net.azurewebsites.api.fertilizer;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 8/20/15.
 */
public class FertilizerService implements IFertilizerService {
    private IApiService apiService;

    public FertilizerService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getFertilizers(Bus bus) {
        apiService.getFertilizers(new RestCallback<List<FertilizerResponse>>(bus) {
        });
    }
}
