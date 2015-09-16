package net.azurewebsites.api.plantingactivity;

import java.util.Date;

/**
 * Created by sebichondo on 9/11/15.
 */
public class PlantingActivity {

    private Long plantingActivityID;
    private Integer activityType;
    private String input;
    private Double quantity;
    private String location;
    private Date activityDate;
    private Long userID;
    private Long fieldID;
    private Long updateSequenceNumberID;

    public PlantingActivity() {
    }

    public PlantingActivity(Long plantingActivityID) {
        this.plantingActivityID = plantingActivityID;
    }

    public PlantingActivity(Long plantingActivityID, Integer activityType, String input, Double quantity, String location, Date activityDate, Long userID, Long fieldID, Long usnID) {
        this.plantingActivityID = plantingActivityID;
        this.activityType = activityType;
        this.input = input;
        this.quantity = quantity;
        this.location = location;
        this.activityDate = activityDate;
        this.userID = userID;
        this.fieldID = fieldID;
        this.updateSequenceNumberID = usnID;
    }

    public Long getPlantingActivityID() {
        return plantingActivityID;
    }

    public void setPlantingActivityID(Long plantingActivityID) {
        this.plantingActivityID = plantingActivityID;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getFieldID() {
        return fieldID;
    }

    public void setFieldID(Long fieldID) {
        this.fieldID = fieldID;
    }

    public Long getUsnID() {
        return updateSequenceNumberID;
    }

    public void setUsnID(Long usnID) {
        this.updateSequenceNumberID = usnID;
    }

    @Override
    public String toString() {
        return "PlantingActivity{" +
                "plantingActivityID=" + plantingActivityID +
                ", activityType=" + activityType +
                ", input='" + input + '\'' +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                ", activityDate=" + activityDate +
                ", userID=" + userID +
                ", fieldID=" + fieldID +
                ", updateSequenceNumberID=" + updateSequenceNumberID +
                '}';
    }
}
