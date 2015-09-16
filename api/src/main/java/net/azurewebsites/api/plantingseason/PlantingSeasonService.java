package net.azurewebsites.api.plantingseason;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 8/19/15.
 */
public class PlantingSeasonService implements IPlantingSeasonService {
    private IApiService apiService;

    public PlantingSeasonService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getPlantingSeasons(Bus bus) {
        apiService.getPlantingSeasons(new RestCallback<List<PlantingSeasonResponse>>(bus) {
        });
    }


}
