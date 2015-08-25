package net.azurewebsites.api.fertilizer;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/20/15.
 */
public interface IFertilizerService {
    public void getFertilizers(Bus bus);
}
