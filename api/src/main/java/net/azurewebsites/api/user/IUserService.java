package net.azurewebsites.api.user;

import com.squareup.otto.Bus;

/**
 * Created by sebichondo on 9/8/15.
 */
public interface IUserService {
    public void getUsers(Bus bus);

    public void getUser(Bus bus);
}
