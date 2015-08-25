package net.azurewebsites.api.seed;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 8/20/15.
 */
public class SeedService implements ISeedService {
    private IApiService apiService;

    public SeedService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getSeeds(Bus bus) {
        apiService.getSeeds(new RestCallback<List<SeedResponse>>(bus) {
        });
    }
}
