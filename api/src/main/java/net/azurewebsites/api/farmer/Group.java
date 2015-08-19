package net.azurewebsites.api.farmer;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/14/15.
 */
public class Group {
    @Expose
    private Integer GroupID;
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
    private Object Crop;
    @Expose
    private Integer CropID;

    /**
     *
     * @return
     * The GroupID
     */
    public Integer getGroupID() {
        return GroupID;
    }

    /**
     *
     * @param GroupID
     * The GroupID
     */
    public void setGroupID(Integer GroupID) {
        this.GroupID = GroupID;
    }

    /**
     *
     * @return
     * The GroupName
     */
    public String getGroupName() {
        return GroupName;
    }

    /**
     *
     * @param GroupName
     * The GroupName
     */
    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    /**
     *
     * @return
     * The ContactPerson
     */
    public String getContactPerson() {
        return ContactPerson;
    }

    /**
     *
     * @param ContactPerson
     * The ContactPerson
     */
    public void setContactPerson(String ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    /**
     *
     * @return
     * The Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     * The Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     * The Telephone
     */
    public String getTelephone() {
        return Telephone;
    }

    /**
     *
     * @param Telephone
     * The Telephone
     */
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    /**
     *
     * @return
     * The EmailAddress
     */
    public String getEmailAddress() {
        return EmailAddress;
    }

    /**
     *
     * @param EmailAddress
     * The EmailAddress
     */
    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    /**
     *
     * @return
     * The Crop
     */
    public Object getCrop() {
        return Crop;
    }

    /**
     *
     * @param Crop
     * The Crop
     */
    public void setCrop(Object Crop) {
        this.Crop = Crop;
    }

    /**
     *
     * @return
     * The CropID
     */
    public Integer getCropID() {
        return CropID;
    }

    /**
     *
     * @param CropID
     * The CropID
     */
    public void setCropID(Integer CropID) {
        this.CropID = CropID;
    }
}
