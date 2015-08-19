package net.azurewebsites.api;

import java.io.Serializable;

/**
 * Created by sebichondo on 8/12/15.
 */
public class FarmerModel implements Serializable {
    private String names;
    private String telephone;
    private String address;
    private String id;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
