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

    /**
     *
     * @return
     * The FieldID
     */
    public Long getFieldID() {
        return FieldID;
    }

    /**
     *
     * @param FieldID
     * The FieldID
     */
    public void setFieldID(Long FieldID) {
        this.FieldID = FieldID;
    }

    /**
     *
     * @return
     * The FarmerID
     */
    public Long getFarmerID() {
        return FarmerID;
    }

    /**
     *
     * @param FarmerID
     * The FarmerID
     */
    public void setFarmerID(Long FarmerID) {
        this.FarmerID = FarmerID;
    }

    /**
     *
     * @return
     * The Farmer
     */
    public Farmer getFarmer() {
        return Farmer;
    }

    /**
     *
     * @param Farmer
     * The Farmer
     */
    public void setFarmer(Farmer Farmer) {
        this.Farmer = Farmer;
    }

    /**
     *
     * @return
     * The FieldName
     */
    public String getFieldName() {
        return FieldName;
    }

    /**
     *
     * @param FieldName
     * The FieldName
     */
    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
    }

    /**
     *
     * @return
     * The Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     *
     * @param Location
     * The Location
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public String toString() {
        return "FieldResponse{" +
                "FieldID=" + FieldID +
                ", FarmerID=" + FarmerID +
                ", Farmer=" + Farmer +
                ", FieldName='" + FieldName + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}