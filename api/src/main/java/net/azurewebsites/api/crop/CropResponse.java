package net.azurewebsites.api.crop;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/18/15.
 */
public class CropResponse {
    @Expose
    private Long CropID;
    @Expose
    private String CropName;
    @Expose
    private String CropVariety;

    /**
     * @return The CropID
     */
    public Long getCropID() {
        return CropID;
    }

    /**
     * @param CropID The CropID
     */
    public void setCropID(Long CropID) {
        this.CropID = CropID;
    }

    /**
     * @return The CropName
     */
    public String getCropName() {
        return CropName;
    }

    /**
     * @param CropName The CropName
     */
    public void setCropName(String CropName) {
        this.CropName = CropName;
    }

    /**
     * @return The CropVariety
     */
    public String getCropVariety() {
        return CropVariety;
    }

    /**
     * @param CropVariety The CropVariety
     */
    public void setCropVariety(String CropVariety) {
        this.CropVariety = CropVariety;
    }

}

