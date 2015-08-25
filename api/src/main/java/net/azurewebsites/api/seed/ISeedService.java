package net.azurewebsites.api.seed;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/20/15.
 */
public interface ISeedService {
    public void getSeeds(Bus bus);
}
