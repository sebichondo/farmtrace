package net.azurewebsites.api.crop;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/18/15.
 */
public interface ICropService {
    public void getCrops(Bus bus);
}
