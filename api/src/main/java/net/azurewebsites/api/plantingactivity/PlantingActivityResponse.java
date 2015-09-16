package net.azurewebsites.api.plantingactivity;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 9/9/15.
 */
public class PlantingActivityResponse {
    @Expose
    private Long PlantingActivityID;
    @Expose
    private Integer ActivityType;
    @Expose
    private String Input;
    @Expose
    private Integer Quantity;
    @Expose
    private User User;
    @Expose
    private Long UserID;
    @Expose
    private String Location;
    @Expose
    private Field Field;
    @Expose
    private UpdateSequenceNumber UpdateSequenceNumber;

    public PlantingActivityResponse(Long plantingActivityID, Integer activityType, String input, Integer quantity, net.azurewebsites.api.plantingactivity.User user, Long userID, String location, net.azurewebsites.api.plantingactivity.Field field, net.azurewebsites.api.plantingactivity.UpdateSequenceNumber updateSequenceNumber) {
        PlantingActivityID = plantingActivityID;
        ActivityType = activityType;
        Input = input;
        Quantity = quantity;
        User = user;
        UserID = userID;
        Location = location;
        Field = field;
        UpdateSequenceNumber = updateSequenceNumber;
    }

    public Long getPlantingActivityID() {
        return PlantingActivityID;
    }

    public void setPlantingActivityID(Long plantingActivityID) {
        PlantingActivityID = plantingActivityID;
    }

    public Integer getActivityType() {
        return ActivityType;
    }

    public void setActivityType(Integer activityType) {
        ActivityType = activityType;
    }

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public net.azurewebsites.api.plantingactivity.User getUser() {
        return User;
    }

    public void setUser(net.azurewebsites.api.plantingactivity.User user) {
        User = user;
    }

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public net.azurewebsites.api.plantingactivity.Field getField() {
        return Field;
    }

    public void setField(net.azurewebsites.api.plantingactivity.Field field) {
        Field = field;
    }

    public net.azurewebsites.api.plantingactivity.UpdateSequenceNumber getUpdateSequenceNumber() {
        return UpdateSequenceNumber;
    }

    public void setUpdateSequenceNumber(net.azurewebsites.api.plantingactivity.UpdateSequenceNumber updateSequenceNumber) {
        UpdateSequenceNumber = updateSequenceNumber;
    }
}