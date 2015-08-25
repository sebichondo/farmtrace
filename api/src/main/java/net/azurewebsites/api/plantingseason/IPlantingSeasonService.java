package net.azurewebsites.api.plantingseason;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/19/15.
 */
public interface IPlantingSeasonService {
    public void getPlantingSeasons(Bus bus);
}
