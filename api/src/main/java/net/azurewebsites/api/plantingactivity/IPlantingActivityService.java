package net.azurewebsites.api.plantingactivity;

import com.squareup.otto.Bus;

import java.util.Date;

/**
 * Created by sebichondo on 9/9/15.
 */
public interface IPlantingActivityService {
    public void getPlantingActivities(Bus bus);

    public void savePlantingActivities(Long plantingActivityID, Integer activityTypeID, String input, Double quantity, String location,
                                       Date activityDate, Long userID, Long fieldID, Long usnID, Bus bus);
}
