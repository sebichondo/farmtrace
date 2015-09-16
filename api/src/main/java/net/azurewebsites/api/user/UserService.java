package net.azurewebsites.api.user;

import com.squareup.otto.Bus;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.RestCallback;

import java.util.List;

/**
 * Created by sebichondo on 9/8/15.
 */
public class UserService implements IUserService {
    private IApiService apiService;

    public UserService(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getUsers(Bus bus) {
        apiService.getUsers(new RestCallback<List<UserResponse>>(bus) {
        });
    }

    @Override
    public void getUser(Bus bus) {
        apiService.getUser(new RestCallback<UserResponse>(bus) {
        });
    }
}
