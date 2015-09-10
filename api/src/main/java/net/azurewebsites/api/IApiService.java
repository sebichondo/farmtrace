package net.azurewebsites.api;

import net.azurewebsites.api.chemical.ChemicalResponse;
import net.azurewebsites.api.crop.CropResponse;
import net.azurewebsites.api.farmer.FarmerResponse;
import net.azurewebsites.api.fertilizer.FertilizerResponse;
import net.azurewebsites.api.field.FieldResponse;
import net.azurewebsites.api.group.GroupResponse;
import net.azurewebsites.api.plantingactivity.PlantingActivityResponse;
import net.azurewebsites.api.plantingseason.PlantingSeasonResponse;
import net.azurewebsites.api.seed.SeedResponse;
import net.azurewebsites.api.user.UserResponse;

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
    @GET("/fields")
    void getFields(Callback<List<FieldResponse>> callback);
    @GET("/plantingseasons")
    void getPlantingSeasons(Callback<List<PlantingSeasonResponse>> callback);
    @GET("/fertilizers")
    void getFertilizers(Callback<List<FertilizerResponse>> callback);
    @GET("/chemicals")
    void getChemicals(Callback<List<ChemicalResponse>> callback);
    @GET("/seeds")
    void getSeeds(Callback<List<SeedResponse>> callback);
    @GET("/users")
    void getUsers(Callback<List<UserResponse>> callback);
    @GET("/plantingactivities")
    void getPlantingActivities(Callback<List<PlantingActivityResponse>> callback);
}
