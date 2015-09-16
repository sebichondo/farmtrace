package net.azurewebsites.daogenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by sebichondo on 8/14/15.
 */
public class MyDaoGenerator {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(22, "net.azurewebsites.farmtrace.datamodel.dao");

        //Entities
        Entity crop = schema.addEntity("Crop");
        crop.addLongProperty("cropID").primaryKey();
        crop.addStringProperty("cropName");
        crop.addStringProperty("cropVariety");

        Entity user = schema.addEntity("User");
        user.addLongProperty("userID").primaryKey();
        user.addStringProperty("userName");
        user.addStringProperty("userPassword");
        user.addIntProperty("userType");
        user.addIntProperty("userStatus");
        user.addStringProperty("profilePicUri");


        Entity chemical = schema.addEntity("Chemical");
        chemical.addLongProperty("chemicalID").primaryKey();
        chemical.addIntProperty("chemicalType");
        chemical.addIntProperty("cropStage");
        chemical.addIntProperty("activeIngredient");
        chemical.addStringProperty("agent");
        chemical.addStringProperty("manufacturer");
        chemical.addIntProperty("pHI");
        chemical.addStringProperty("productTradeName");
        chemical.addIntProperty("rate");
        chemical.addStringProperty("reasonForUse");
        chemical.addStringProperty("registrationNumber");

        Entity farmerGroup = schema.addEntity("FarmerGroup");
        farmerGroup.addLongProperty("farmerGroupID").primaryKey();
        farmerGroup.addStringProperty("groupName");
        farmerGroup.addStringProperty("telephone");
        farmerGroup.addStringProperty("emailAddress");
        farmerGroup.addStringProperty("contactPerson");
        farmerGroup.addStringProperty("address");
        Property cropIdForGroup = farmerGroup.addLongProperty("cropID").getProperty();

        Entity farmer = schema.addEntity("Farmer");
        farmer.addLongProperty("farmerID").primaryKey();
        farmer.addStringProperty("groupName");
        farmer.addStringProperty("names");
        farmer.addStringProperty("telephone");
        farmer.addStringProperty("address");
        Property groupIdForFamer = farmer.addLongProperty("farmerGroupID").getProperty();

        Entity fertilizer = schema.addEntity("Fertilizer");
        fertilizer.addLongProperty("fertilizerID").primaryKey();
        fertilizer.addIntProperty("fertilizerType");
        fertilizer.addIntProperty("mainNutrients");
        fertilizer.addIntProperty("soilConditions");
        fertilizer.addIntProperty("timeOfPlanting");
        fertilizer.addIntProperty("topDressing");
        Property cropIdForFertilizer = fertilizer.addLongProperty("cropID").getProperty();

        Entity field = schema.addEntity("Field");
        field.addLongProperty("fieldID").primaryKey();
        field.addStringProperty("fieldName");
        field.addStringProperty("location");
        field.addDoubleProperty("area");
        Property fieldIdForFarmer= field.addLongProperty("farmerID").getProperty();

        Entity seed = schema.addEntity("Seed");
        seed.addLongProperty("seedID").primaryKey();
        seed.addIntProperty("seedRate");
        seed.addStringProperty("seedVariety");
        seed.addIntProperty("transplantToHarvest");
        Property seedIdForCrop= seed.addLongProperty("cropID").getProperty();

        Entity plantingSeason = schema.addEntity("PlantingSeason");
        plantingSeason.addLongProperty("plantingSeasonID").primaryKey();
        plantingSeason.addIntProperty("harvestedQuantity");
        plantingSeason.addStringProperty("seasonName");
        plantingSeason.addDateProperty("startDate");
        plantingSeason.addDateProperty("targetDate");
        plantingSeason.addIntProperty("targetQuantity");
        Property cropIdForSeason= plantingSeason.addLongProperty("cropID").getProperty();

        Entity plantingActivity = schema.addEntity("PlantingActivity");
        plantingActivity.addLongProperty("plantingActivityID").primaryKey().autoincrement();
        plantingActivity.addIntProperty("activityType");
        plantingActivity.addStringProperty("input");
        plantingActivity.addDoubleProperty("quantity");
        plantingActivity.addStringProperty("location");
        plantingActivity.addDateProperty("activityDate");
        Property userIdForPlantingActivity= plantingActivity.addLongProperty("userID").getProperty();
        Property fieldIdForPlantingActivity= plantingActivity.addLongProperty("fieldID").getProperty();
        Property usnIdForPlantingActivity= plantingActivity.addLongProperty("usnID").getProperty();

        Entity updateSequenceNumbers = schema.addEntity("UpdateSequenceNumbers");
        updateSequenceNumbers.addLongProperty("updateSequenceNumberID").primaryKey().autoincrement();
        updateSequenceNumbers.addDateProperty("usnDate");
        Property userIdForUSN= updateSequenceNumbers.addLongProperty("userID").getProperty();

        /**
         * Relationships
         * */
        crop.addToMany(farmerGroup, cropIdForGroup);
        farmerGroup.addToMany(farmer, groupIdForFamer);
        crop.addToMany(fertilizer, cropIdForFertilizer);
        farmer.addToMany(field,fieldIdForFarmer);
        crop.addToMany(seed,seedIdForCrop);
        crop.addToMany(plantingSeason, cropIdForSeason);
        user.addToMany(plantingActivity, userIdForPlantingActivity);
        user.addToMany(updateSequenceNumbers, userIdForUSN);
        field.addToMany(plantingActivity,fieldIdForPlantingActivity);
        updateSequenceNumbers.addToMany(plantingActivity,usnIdForPlantingActivity);

        new DaoGenerator().generateAll(schema, args[0]);
    }
}
