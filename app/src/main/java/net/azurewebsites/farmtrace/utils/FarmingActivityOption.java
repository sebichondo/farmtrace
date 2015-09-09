package net.azurewebsites.farmtrace.utils;

/**
 * Created by sebichondo on 9/5/15.
 */
public class FarmingActivityOption {
    private int imageSrc;
    private String farmingActivityName;

    public FarmingActivityOption(int imageSrc, String farmingActivityName) {
        this.imageSrc = imageSrc;
        this.farmingActivityName = farmingActivityName;
    }

    public FarmingActivityOption(String paymentName) {
        this.farmingActivityName = paymentName;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getFarmingActivityName() {
        return farmingActivityName;
    }

    public void setFarmingActivityName(String paymentName) {
        this.farmingActivityName = paymentName;
    }
}
