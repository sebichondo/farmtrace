package net.azurewebsites.api.field;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/19/15.
 */
public class FieldResponse {
    @Expose
    private Long FieldID;
    @Expose
    private Long FarmerID;
    @Expose
    private Farmer Farmer;
    @Expose
    private String FieldName;
    @Expose
    private String Location;
    @Expose
    private Double Area;

    public FieldResponse(Long fieldID, Long farmerID, net.azurewebsites.api.field.Farmer farmer, String fieldName, String location, Double area) {
        FieldID = fieldID;
        FarmerID = farmerID;
        Farmer = farmer;
        FieldName = fieldName;
        Location = location;
        Area = area;
    }

    public Long getFieldID() {
        return FieldID;
    }

    public void setFieldID(Long fieldID) {
        FieldID = fieldID;
    }

    public Long getFarmerID() {
        return FarmerID;
    }

    public void setFarmerID(Long farmerID) {
        FarmerID = farmerID;
    }

    public net.azurewebsites.api.field.Farmer getFarmer() {
        return Farmer;
    }

    public void setFarmer(net.azurewebsites.api.field.Farmer farmer) {
        Farmer = farmer;
    }

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String fieldName) {
        FieldName = fieldName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Double getArea() {
        return Area;
    }

    public void setArea(Double area) {
        Area = area;
    }

    @Override
    public String toString() {
        return "FieldResponse{" +
                "FieldID=" + FieldID +
                ", FarmerID=" + FarmerID +
                ", Farmer=" + Farmer +
                ", FieldName='" + FieldName + '\'' +
                ", Location='" + Location + '\'' +
                ", Area=" + Area +
                '}';
    }
}