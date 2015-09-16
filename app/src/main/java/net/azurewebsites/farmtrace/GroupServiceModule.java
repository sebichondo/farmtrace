package net.azurewebsites.farmtrace;

import net.azurewebsites.api.IApiService;
import net.azurewebsites.api.group.GroupService;
import net.azurewebsites.api.group.IGroupService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sebichondo on 8/18/15.
 */
@Module
public class GroupServiceModule {
    @Provides
    @MainScope
    IGroupService provideGroupService(IApiService apiService) {
        return new GroupService(apiService);
    }
}
