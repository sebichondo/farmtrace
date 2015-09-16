package net.azurewebsites.api.seed;

import com.google.gson.annotations.Expose;

import net.azurewebsites.api.group.Crop;

/**
 * Created by sebichondo on 8/20/15.
 */
public class SeedResponse {
    @Expose
    private Long SeedID;
    @Expose
    private String SeedVariety;
    @Expose
    private Long CropID;
    @Expose
    private Crop Crop;
    @Expose
    private Integer TransplantToHarvest;
    @Expose
    private Integer SeedRate;

    /**
     * @return The SeedID
     */
    public Long getSeedID() {
        return SeedID;
    }

    /**
     * @param SeedID The SeedID
     */
    public void setSeedID(Long SeedID) {
        this.SeedID = SeedID;
    }

    /**
     * @return The SeedVariety
     */
    public String getSeedVariety() {
        return SeedVariety;
    }

    /**
     * @param SeedVariety The SeedVariety
     */
    public void setSeedVariety(String SeedVariety) {
        this.SeedVariety = SeedVariety;
    }

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
     * @return The Crop
     */
    public Crop getCrop() {
        return Crop;
    }

    /**
     * @param Crop The Crop
     */
    public void setCrop(Crop Crop) {
        this.Crop = Crop;
    }

    /**
     * @return The TransplantToHarvest
     */
    public Integer getTransplantToHarvest() {
        return TransplantToHarvest;
    }

    /**
     * @param TransplantToHarvest The TransplantToHarvest
     */
    public void setTransplantToHarvest(Integer TransplantToHarvest) {
        this.TransplantToHarvest = TransplantToHarvest;
    }

    /**
     * @return The SeedRate
     */
    public Integer getSeedRate() {
        return SeedRate;
    }

    /**
     * @param SeedRate The SeedRate
     */
    public void setSeedRate(Integer SeedRate) {
        this.SeedRate = SeedRate;
    }

}
