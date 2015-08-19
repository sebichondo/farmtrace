package net.azurewebsites.api.farmer;

import com.google.gson.annotations.Expose;

/**
 * Created by sebichondo on 8/13/15.
 */
public class FarmerResponse {
    @Expose
    private String Names;
    @Expose
    private String Address;
    @Expose
    private String Telephone;
    @Expose
    private Long FarmerID;
    @Expose
    private Group Group;
    @Expose
    private Long GroupID;

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public Long getFarmerID() {
        return FarmerID;
    }

    public void setFarmerID(Long farmerID) {
        FarmerID = farmerID;
    }

    public net.azurewebsites.api.farmer.Group getGroup() {
        return Group;
    }

    public void setGroup(net.azurewebsites.api.farmer.Group group) {
        Group = group;
    }

    public Long getGroupID() {
        return GroupID;
    }

    public void setGroupID(Long groupID) {
        GroupID = groupID;
    }

    @Override
    public String toString() {
        return "FarmerResponse{" +
                "Names='" + Names + '\'' +
                ", Address='" + Address + '\'' +
                ", Telephone='" + Telephone + '\'' +
                ", FarmerID=" + FarmerID +
                ", Group=" + Group +
                ", GroupID=" + GroupID +
                '}';
    }
}
