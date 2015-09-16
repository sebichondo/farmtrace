package net.azurewebsites.api.plantingactivity;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.Date;
import java.util.List;

/**
 * Created by sebichondo on 9/9/15.
 */
public class PlantingActivityService implements IPlantingActivityService {
    private IApiService apiService;

    public PlantingActivityService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getPlantingActivities(Bus bus) {
        apiService.getPlantingActivities(new RestCallback<List<PlantingActivityResponse>>(bus) {
        });
    }

    @Override
    public void savePlantingActivities(Long plantingActivityID, Integer activityTypeID, String input, Double quantity, String location,
                                       Date activityDate, Long userID, Long fieldID, Long usnID, Bus bus) {
        apiService.savePlantingActivities(new PlantingActivity(plantingActivityID, activityTypeID, input, quantity,
                        location, activityDate, userID, fieldID, usnID),
                new RestCallback<PlantingActivityResponse>(bus) {
                });
    }
}
