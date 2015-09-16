package net.azurewebsites.api.plantingseason;

import com.google.gson.annotations.Expose;

import net.azurewebsites.api.group.Crop;

import java.util.Date;

/**
 * Created by sebichondo on 8/19/15.
 */

public class PlantingSeasonResponse {
    @Expose
    private Long PlantingSeasonID;
    @Expose
    private String SeasonName;
    @Expose
    private Crop Crop;
    @Expose
    private Long CropID;
    @Expose
    private Date StartDate;
    @Expose
    private Date TargetDate;
    @Expose
    private Integer TargetQuantity;
    @Expose
    private Integer HarvestedQuantity;

    /**
     * @return The PlantingSeasonID
     */
    public Long getPlantingSeasonID() {
        return PlantingSeasonID;
    }

    /**
     * @param PlantingSeasonID The PlantingSeasonID
     */
    public void setPlantingSeasonID(Long PlantingSeasonID) {
        this.PlantingSeasonID = PlantingSeasonID;
    }

    /**
     * @return The SeasonName
     */
    public String getSeasonName() {
        return SeasonName;
    }

    /**
     * @param SeasonName The SeasonName
     */
    public void setSeasonName(String SeasonName) {
        this.SeasonName = SeasonName;
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
     * @return The StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate The StartDate
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return The TargetDate
     */
    public Date getTargetDate() {
        return TargetDate;
    }

    /**
     * @param TargetDate The TargetDate
     */
    public void setTargetDate(Date TargetDate) {
        this.TargetDate = TargetDate;
    }

    /**
     * @return The TargetQuantity
     */
    public Integer getTargetQuantity() {
        return TargetQuantity;
    }

    /**
     * @param TargetQuantity The TargetQuantity
     */
    public void setTargetQuantity(Integer TargetQuantity) {
        this.TargetQuantity = TargetQuantity;
    }

    /**
     * @return The HarvestedQuantity
     */
    public Integer getHarvestedQuantity() {
        return HarvestedQuantity;
    }

    /**
     * @param HarvestedQuantity The HarvestedQuantity
     */
    public void setHarvestedQuantity(Integer HarvestedQuantity) {
        this.HarvestedQuantity = HarvestedQuantity;
    }

    @Override
    public String toString() {
        return "PlantingSeasonResponse{" +
                "PlantingSeasonID=" + PlantingSeasonID +
                ", SeasonName='" + SeasonName + '\'' +
                ", Crop=" + Crop +
                ", CropID=" + CropID +
                ", StartDate='" + StartDate + '\'' +
                ", TargetDate='" + TargetDate + '\'' +
                ", TargetQuantity=" + TargetQuantity +
                ", HarvestedQuantity=" + HarvestedQuantity +
                '}';
    }
}
