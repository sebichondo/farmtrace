package net.azurewebsites.api.farmer;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/13/15.
 */
public interface IFarmerService {
    public void getFarmers(Bus bus);
}
