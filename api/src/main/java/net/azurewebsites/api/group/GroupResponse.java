package net.azurewebsites.api.group;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/18/15.
 */
public class GroupResponse {
    @Expose
    private Long GroupID;
    @Expose
    private String GroupName;
    @Expose
    private String ContactPerson;
    @Expose
    private String Address;
    @Expose
    private String Telephone;
    @Expose
    private String EmailAddress;
    @Expose
    private Crop Crop;
    @Expose
    private Long CropID;

    /**
     * @return The GroupID
     */
    public Long getGroupID() {
        return GroupID;
    }

    /**
     * @param GroupID The GroupID
     */
    public void setGroupID(Long GroupID) {
        this.GroupID = GroupID;
    }

    /**
     * @return The GroupName
     */
    public String getGroupName() {
        return GroupName;
    }

    /**
     * @param GroupName The GroupName
     */
    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    /**
     * @return The ContactPerson
     */
    public String getContactPerson() {
        return ContactPerson;
    }

    /**
     * @param ContactPerson The ContactPerson
     */
    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    /**
     * @return The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return The Telephone
     */
    public String getTelephone() {
        return Telephone;
    }

    /**
     * @param Telephone The Telephone
     */
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    /**
     * @return The EmailAddress
     */
    public String getEmailAddress() {
        return EmailAddress;
    }

    /**
     * @param EmailAddress The EmailAddress
     */
    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
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

    @Override
    public String toString() {
        return "GroupResponse{" +
                "GroupID=" + GroupID +
                ", GroupName='" + GroupName + '\'' +
                ", ContactPerson='" + ContactPerson + '\'' +
                ", Address='" + Address + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", Crop=" + Crop +
                ", CropID=" + CropID +
                '}';
    }
}