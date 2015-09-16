package net.azurewebsites.api.plantingactivity;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 9/14/15.
 */
public class Field {
    @Expose
    private Integer FieldID;
    @Expose
    private Integer FarmerID;
    @Expose
    private String FieldName;
    @Expose
    private String Location;
    @Expose
    private Double Area;

    /**
     * @return The FieldID
     */
    public Integer getFieldID() {
        return FieldID;
    }

    /**
     * @param FieldID The FieldID
     */
    public void setFieldID(Integer FieldID) {
        this.FieldID = FieldID;
    }

    /**
     * @return The FarmerID
     */
    public Integer getFarmerID() {
        return FarmerID;
    }

    /**
     * @param FarmerID The FarmerID
     */
    public void setFarmerID(Integer FarmerID) {
        this.FarmerID = FarmerID;
    }

    /**
     * @return The FieldName
     */
    public String getFieldName() {
        return FieldName;
    }

    /**
     * @param FieldName The FieldName
     */
    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
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

    /**
     * @return The Area
     */
    public Double getArea() {
        return Area;
    }

    /**
     * @param Area The Area
     */
    public void setArea(Double Area) {
        this.Area = Area;
    }

    @Override
    public String toString() {
        return "Field{" +
                "FieldID=" + FieldID +
                ", FarmerID=" + FarmerID +
                ", FieldName='" + FieldName + '\'' +
                ", Location='" + Location + '\'' +
                ", Area=" + Area +
                '}';
    }
}
