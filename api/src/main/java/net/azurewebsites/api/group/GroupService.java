package net.azurewebsites.api.group;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 8/18/15.
 */
public class GroupService implements IGroupService {
    private IApiService apiService;

    public GroupService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getGroups(Bus bus) {
        apiService.getGroups(new RestCallback<List<GroupResponse>>(bus) {
        });
    }
}
