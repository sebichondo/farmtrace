package net.azurewebsites.api.chemical;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/20/15.
 */
public class ChemicalResponse {
    @Expose
    private Long ChemicalID;
    @Expose
    private Integer ChemicalType;
    @Expose
    private Integer CropStage;
    @Expose
    private String ProductTradeName;
    @Expose
    private String Manufacturer;
    @Expose
    private String Agent;
    @Expose
    private Integer ActiveIngredient;
    @Expose
    private Integer PHI;
    @Expose
    private String RegistrationNumber;
    @Expose
    private String ReasonForUse;
    @Expose
    private Integer Rate;

    /**
     * @return The ChemicalID
     */
    public Long getChemicalID() {
        return ChemicalID;
    }

    /**
     * @param ChemicalID The ChemicalID
     */
    public void setChemicalID(Long ChemicalID) {
        this.ChemicalID = ChemicalID;
    }

    /**
     * @return The ChemicalType
     */
    public Integer getChemicalType() {
        return ChemicalType;
    }

    /**
     * @param ChemicalType The ChemicalType
     */
    public void setChemicalType(Integer ChemicalType) {
        this.ChemicalType = ChemicalType;
    }

    /**
     * @return The CropStage
     */
    public Integer getCropStage() {
        return CropStage;
    }

    /**
     * @param CropStage The CropStage
     */
    public void setCropStage(Integer CropStage) {
        this.CropStage = CropStage;
    }

    /**
     * @return The ProductTradeName
     */
    public String getProductTradeName() {
        return ProductTradeName;
    }

    /**
     * @param ProductTradeName The ProductTradeName
     */
    public void setProductTradeName(String ProductTradeName) {
        this.ProductTradeName = ProductTradeName;
    }

    /**
     * @return The Manufacturer
     */
    public String getManufacturer() {
        return Manufacturer;
    }

    /**
     * @param Manufacturer The Manufacturer
     */
    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    /**
     * @return The Agent
     */
    public String getAgent() {
        return Agent;
    }

    /**
     * @param Agent The Agent
     */
    public void setAgent(String Agent) {
        this.Agent = Agent;
    }

    /**
     * @return The ActiveIngredient
     */
    public Integer getActiveIngredient() {
        return ActiveIngredient;
    }

    /**
     * @param ActiveIngredient The ActiveIngredient
     */
    public void setActiveIngredient(Integer ActiveIngredient) {
        this.ActiveIngredient = ActiveIngredient;
    }

    /**
     * @return The PHI
     */
    public Integer getPHI() {
        return PHI;
    }

    /**
     * @param PHI The PHI
     */
    public void setPHI(Integer PHI) {
        this.PHI = PHI;
    }

    /**
     * @return The RegistrationNumber
     */
    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    /**
     * @param RegistrationNumber The RegistrationNumber
     */
    public void setRegistrationNumber(String RegistrationNumber) {
        this.RegistrationNumber = RegistrationNumber;
    }

    /**
     * @return The ReasonForUse
     */
    public String getReasonForUse() {
        return ReasonForUse;
    }

    /**
     * @param ReasonForUse The ReasonForUse
     */
    public void setReasonForUse(String ReasonForUse) {
        this.ReasonForUse = ReasonForUse;
    }

    /**
     * @return The Rate
     */
    public Integer getRate() {
        return Rate;
    }

    /**
     * @param Rate The Rate
     */
    public void setRate(Integer Rate) {
        this.Rate = Rate;
    }

}
