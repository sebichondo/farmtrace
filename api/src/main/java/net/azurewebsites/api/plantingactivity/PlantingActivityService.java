package net.azurewebsites.api.plantingactivity;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 9/9/15.
 */
public class PlantingActivityService implements IPlantingActivity {
    private IApiService apiService;

    public PlantingActivityService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getPlantingActivities(Bus bus) {
        apiService.getPlantingActivities(new RestCallback<List<PlantingActivityResponse>>(bus) {
        });
    }
}
