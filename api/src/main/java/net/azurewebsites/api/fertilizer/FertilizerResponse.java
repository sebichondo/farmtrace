package net.azurewebsites.api.fertilizer;

import com.google.gson.annotations.Expose;

import net.azurewebsites.api.group.Crop;

/**
 * Created by sebichondo on 8/20/15.
 */
public class FertilizerResponse {
    @Expose
    private Long FertilizerID;
    @Expose
    private Integer FertilizerType;
    @Expose
    private Integer MainNutrients;
    @Expose
    private Crop Crop;
    @Expose
    private Long CropID;
    @Expose
    private Integer SoilConditions;
    @Expose
    private Integer TimeOfPlanting;
    @Expose
    private Integer TopDressing;

    /**
     * @return The FertilizerID
     */
    public Long getFertilizerID() {
        return FertilizerID;
    }

    /**
     * @param FertilizerID The FertilizerID
     */
    public void setFertilizerID(Long FertilizerID) {
        this.FertilizerID = FertilizerID;
    }

    /**
     * @return The FertilizerType
     */
    public Integer getFertilizerType() {
        return FertilizerType;
    }

    /**
     * @param FertilizerType The FertilizerType
     */
    public void setFertilizerType(Integer FertilizerType) {
        this.FertilizerType = FertilizerType;
    }

    /**
     * @return The MainNutrients
     */
    public Integer getMainNutrients() {
        return MainNutrients;
    }

    /**
     * @param MainNutrients The MainNutrients
     */
    public void setMainNutrients(Integer MainNutrients) {
        this.MainNutrients = MainNutrients;
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
     * @return The SoilConditions
     */
    public Integer getSoilConditions() {
        return SoilConditions;
    }

    /**
     * @param SoilConditions The SoilConditions
     */
    public void setSoilConditions(Integer SoilConditions) {
        this.SoilConditions = SoilConditions;
    }

    /**
     * @return The TimeOfPlanting
     */
    public Integer getTimeOfPlanting() {
        return TimeOfPlanting;
    }

    /**
     * @param TimeOfPlanting The TimeOfPlanting
     */
    public void setTimeOfPlanting(Integer TimeOfPlanting) {
        this.TimeOfPlanting = TimeOfPlanting;
    }

    /**
     * @return The TopDressing
     */
    public Integer getTopDressing() {
        return TopDressing;
    }

    /**
     * @param TopDressing The TopDressing
     */
    public void setTopDressing(Integer TopDressing) {
        this.TopDressing = TopDressing;
    }

}
