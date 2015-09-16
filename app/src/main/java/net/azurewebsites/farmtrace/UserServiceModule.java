package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.user.IUserService;
import net.azurewebsites.api.user.UserService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 9/8/15.
 */
@Module
public class UserServiceModule {
    @Provides
    @MainScope
    IUserService provideUserService(IApiService apiService) {
        return new UserService(apiService);
    }
}
