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
    private Long UserID;
    @Expose
    private String Location;

    /**
     * @return The PlantingActivityID
     */
    public Long getPlantingActivityID() {
        return PlantingActivityID;
    }

    /**
     * @param PlantingActivityID The PlantingActivityID
     */
    public void setPlantingActivityID(Long PlantingActivityID) {
        this.PlantingActivityID = PlantingActivityID;
    }

    /**
     * @return The ActivityType
     */
    public Integer getActivityType() {
        return ActivityType;
    }

    /**
     * @param ActivityType The ActivityType
     */
    public void setActivityType(Integer ActivityType) {
        this.ActivityType = ActivityType;
    }

    /**
     * @return The Input
     */
    public String getInput() {
        return Input;
    }

    /**
     * @param Input The Input
     */
    public void setInput(String Input) {
        this.Input = Input;
    }

    /**
     * @return The Quantity
     */
    public Integer getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity The Quantity
     */
    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return The UserID
     */
    public Long getUserID() {
        return UserID;
    }

    /**
     * @param UserID The UserID
     */
    public void setUserID(Long UserID) {
        this.UserID = UserID;
    }

    /**
     * @return The Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * @param Location The Location
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }
}