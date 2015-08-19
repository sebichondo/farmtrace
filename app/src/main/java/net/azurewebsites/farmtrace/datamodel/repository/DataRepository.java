package net.azurewebsites.farmtrace.datamodel.repository;

import android.content.Context;
import android.util.Log;

import net.azurewebsites.farmtrace.FarmTraceApp;
import net.azurewebsites.farmtrace.datamodel.dao.Crop;
import net.azurewebsites.farmtrace.datamodel.dao.CropDao;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerDao;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroup;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroupDao;

import java.util.List;

/**
 * Created by sebichondo on 8/15/15.
 */
public class DataRepository {

    public static void insertOrUpdateFarmer(Context context, Farmer farmer) {
        Long rowsReturned=getFarmerDao(context).insertOrReplace(farmer);
        Log.d("DataRepository", "The Number of Farmers Inserted: " + rowsReturned);

    }

    public static void insertOrUpdateCrop(Context context, Crop crop) {
        Long rowsReturned=getCropDao(context).insertOrReplace(crop);
        Log.d("DataRepository", "The Number of Crops Inserted: " + rowsReturned);
    }


    public static void insertOrUpdateFarmerGroup(Context context, FarmerGroup farmerGroup) {
        Long rowsReturned=getFarmerGroupDao(context).insertOrReplace(farmerGroup);
        Log.d("DataRepository", "The Number of Groups Inserted: " + rowsReturned);
    }

    public static List<Crop> getAllCrops(Context context) {
        return getCropDao(context).loadAll();
    }

    /**
     * Dao getters
     */
    private static FarmerDao getFarmerDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getFarmerDao();
    }

    private static CropDao getCropDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getCropDao();
    }

    private static FarmerGroupDao getFarmerGroupDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getFarmerGroupDao();
    }

}
