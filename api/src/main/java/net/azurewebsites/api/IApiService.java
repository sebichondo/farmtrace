package net.azurewebsites.api;

import net.azurewebsites.api.crop.CropResponse;
import net.azurewebsites.api.farmer.FarmerResponse;
import net.azurewebsites.api.group.GroupResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by sebichondo on 8/12/15.
 */
public interface IApiService {
    @GET("/farmers")
    void getFarmers(Callback<List<FarmerResponse>> callback);
    @GET("/crops")
    void getCrops(Callback<List<CropResponse>> callback);
    @GET("/groups")
    void getGroups(Callback<List<GroupResponse>> callback);
}

