package net.azurewebsites.api.field;

/**
 * Created by sebichondo on 8/19/15.
 */

import net.azurewebsites.api.farmer.Group;

public class Farmer {
    private String Names;
    private String Address;
    private String Telephone;
    private Long FarmerID;
    private Group Group;
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
}
