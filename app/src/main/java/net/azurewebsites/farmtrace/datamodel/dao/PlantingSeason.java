package net.azurewebsites.farmtrace.datamodel.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table PLANTING_SEASON.
 */
public class PlantingSeason {

    private Long plantingSeasonID;
    private Integer harvestedQuantity;
    private String seasonName;
    private java.util.Date startDate;
    private java.util.Date targetDate;
    private Integer targetQuantity;
    private Long cropID;

    public PlantingSeason() {
    }

    public PlantingSeason(Long plantingSeasonID) {
        this.plantingSeasonID = plantingSeasonID;
    }

    public PlantingSeason(Long plantingSeasonID, Integer harvestedQuantity, String seasonName, java.util.Date startDate, java.util.Date targetDate, Integer targetQuantity, Long cropID) {
        this.plantingSeasonID = plantingSeasonID;
        this.harvestedQuantity = harvestedQuantity;
        this.seasonName = seasonName;
        this.startDate = startDate;
        this.targetDate = targetDate;
        this.targetQuantity = targetQuantity;
        this.cropID = cropID;
    }

    public Long getPlantingSeasonID() {
        return plantingSeasonID;
    }

    public void setPlantingSeasonID(Long plantingSeasonID) {
        this.plantingSeasonID = plantingSeasonID;
    }

    public Integer getHarvestedQuantity() {
        return harvestedQuantity;
    }

    public void setHarvestedQuantity(Integer harvestedQuantity) {
        this.harvestedQuantity = harvestedQuantity;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public java.util.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }

    public java.util.Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(java.util.Date targetDate) {
        this.targetDate = targetDate;
    }

    public Integer getTargetQuantity() {
        return targetQuantity;
    }

    public void setTargetQuantity(Integer targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    public Long getCropID() {
        return cropID;
    }

    public void setCropID(Long cropID) {
        this.cropID = cropID;
    }

}
