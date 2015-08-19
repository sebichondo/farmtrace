package net.azurewebsites.api.group;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/18/15.
 */
public class Crop {
    @Expose
    private Long CropID;
    @Expose
    private String CropName;
    @Expose
    private String CropVariety;

    public Crop(Long cropID, String cropName, String cropVariety) {
        CropID = cropID;
        CropName = cropName;
        CropVariety = cropVariety;
    }

    public Long getCropID() {
        return CropID;
    }

    public void setCropID(Long cropID) {
        CropID = cropID;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String cropName) {
        CropName = cropName;
    }

    public String getCropVariety() {
        return CropVariety;
    }

    public void setCropVariety(String cropVariety) {
        CropVariety = cropVariety;
    }

    @Override
    public String toString() {
        return "Crop{" +
                "CropID=" + CropID +
                ", CropName='" + CropName + '\'' +
                ", CropVariety='" + CropVariety + '\'' +
                '}';
    }
}

