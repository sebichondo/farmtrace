package net.azurewebsites.farmtrace.datamodel.repository;

import android.content.Context;
import android.util.Log;

import net.azurewebsites.farmtrace.FarmTraceApp;
import net.azurewebsites.farmtrace.datamodel.dao.Chemical;
import net.azurewebsites.farmtrace.datamodel.dao.ChemicalDao;
import net.azurewebsites.farmtrace.datamodel.dao.Crop;
import net.azurewebsites.farmtrace.datamodel.dao.CropDao;
import net.azurewebsites.farmtrace.datamodel.dao.Farmer;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerDao;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroup;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroupDao;
import net.azurewebsites.farmtrace.datamodel.dao.Fertilizer;
import net.azurewebsites.farmtrace.datamodel.dao.FertilizerDao;
import net.azurewebsites.farmtrace.datamodel.dao.Field;
import net.azurewebsites.farmtrace.datamodel.dao.FieldDao;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeason;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeasonDao;
import net.azurewebsites.farmtrace.datamodel.dao.Seed;
import net.azurewebsites.farmtrace.datamodel.dao.SeedDao;

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

    public static void insertOrUpdateChemical(Context context, Chemical chemical) {
        Long rowsReturned=getChemicalDao(context).insertOrReplace(chemical);
        Log.d("DataRepository", "The Number of Chemicals Inserted: " + rowsReturned);
    }


    public static void insertOrUpdateFarmerGroup(Context context, FarmerGroup farmerGroup) {
        Long rowsReturned=getFarmerGroupDao(context).insertOrReplace(farmerGroup);
        Log.d("DataRepository", "The Number of Groups Inserted: " + rowsReturned);
    }

    public static void insertOrUpdateSeed(Context context, Seed seed) {
        Long rowsReturned=getSeedDao(context).insertOrReplace(seed);
        Log.d("DataRepository", "The Number of Seeds Inserted: " + rowsReturned);
    }


    public static void insertOrUpdateFertilizer(Context context, Fertilizer fertilizer) {
        Long rowsReturned=getFertilizerDao(context).insertOrReplace(fertilizer);
        Log.d("DataRepository", "The Number of Fertilizers Inserted: " + rowsReturned);
    }


    public static void insertOrUpdateField(Context context, Field field) {
        Long rowsReturned=getFieldsDao(context).insertOrReplace(field);
        Log.d("DataRepository", "The Number of Fields Inserted: " + rowsReturned);
    }

    public static void insertOrUpdatePlantingSeason(Context context, PlantingSeason plantingSeason) {
        Long rowsReturned=getPlantingSeasonsDao(context).insertOrReplace(plantingSeason);
        Log.d("DataRepository", "The Number of Planting Seasons Inserted: " + rowsReturned);
    }

    public static List<Crop> getAllCrops(Context context) {
        return getCropDao(context).loadAll();
    }


    public static List<Chemical> getAllChemicals(Context context) {
        return getChemicalDao(context).loadAll();
    }

    public static List<PlantingSeason> getAllPlantingSeasons(Context context) {
        return getPlantingSeasonsDao(context).loadAll();
    }


    public static List<Seed> getAllSeeds(Context context) {
        return getSeedDao(context).loadAll();
    }

    public static List<Fertilizer> getAllFertilizers(Context context) {
        return getFertilizerDao(context).loadAll();
    }

    public static List<FarmerGroup> getAllFarmerGroups(Context context) {
        return getFarmerGroupDao(context).loadAll();
    }

    public static List<Field> getAllFields(Context context) {
        return getFieldsDao(context).loadAll();
    }

    public static List<Farmer> getAllFarmers(Context context) {
        return getFarmerDao(context).loadAll();
    }

    public static Farmer getFarmerById(Context context,Long Id) {
        return getFarmerDao(context).load(Id);
    }

    public static FarmerGroup getGroupById(Context context,Long Id) {
        return getFarmerGroupDao(context).load(Id);
    }

    public static Crop getCropById(Context context,Long Id) {
        return getCropDao(context).load(Id);
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

    private static FieldDao getFieldsDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getFieldDao();
    }

    private static PlantingSeasonDao getPlantingSeasonsDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getPlantingSeasonDao();
    }

    private static FertilizerDao getFertilizerDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getFertilizerDao();
    }

    private static ChemicalDao getChemicalDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getChemicalDao();
    }

    private static SeedDao getSeedDao(Context c) {
        return ((FarmTraceApp) c.getApplicationContext()).getDaoSession().getSeedDao();
    }

}
