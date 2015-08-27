package net.azurewebsites.farmtrace.datamodel.dao;

import java.util.List;
import net.azurewebsites.farmtrace.datamodel.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table FARMER.
 */
public class Farmer {

    private Long farmerID;
    private String groupName;
    private String names;
    private String telephone;
    private String address;
    private Long farmerGroupID;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient FarmerDao myDao;

    private List<Field> fieldList;

    public Farmer() {
    }

    public Farmer(Long farmerID) {
        this.farmerID = farmerID;
    }

    public Farmer(Long farmerID, String groupName, String names, String telephone, String address, Long farmerGroupID) {
        this.farmerID = farmerID;
        this.groupName = groupName;
        this.names = names;
        this.telephone = telephone;
        this.address = address;
        this.farmerGroupID = farmerGroupID;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFarmerDao() : null;
    }

    public Long getFarmerID() {
        return farmerID;
    }

    public void setFarmerID(Long farmerID) {
        this.farmerID = farmerID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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

    public Long getFarmerGroupID() {
        return farmerGroupID;
    }

    public void setFarmerGroupID(Long farmerGroupID) {
        this.farmerGroupID = farmerGroupID;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Field> getFieldList() {
        if (fieldList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FieldDao targetDao = daoSession.getFieldDao();
            List<Field> fieldListNew = targetDao._queryFarmer_FieldList(farmerID);
            synchronized (this) {
                if(fieldList == null) {
                    fieldList = fieldListNew;
                }
            }
        }
        return fieldList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFieldList() {
        fieldList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
