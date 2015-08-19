package net.azurewebsites.api.group;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 8/18/15.
 */
public interface IGroupService {
    public void getGroups(Bus bus);
}
