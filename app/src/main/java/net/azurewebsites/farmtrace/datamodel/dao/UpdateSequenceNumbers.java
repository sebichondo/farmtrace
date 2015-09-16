package net.azurewebsites.farmtrace.datamodel.dao;

import java.util.List;

import net.azurewebsites.farmtrace.datamodel.dao.DaoSession;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table UPDATE_SEQUENCE_NUMBERS.
 */
public class UpdateSequenceNumbers {

    private Long updateSequenceNumberID;
    private java.util.Date usnDate;
    private Long userID;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient UpdateSequenceNumbersDao myDao;

    private List<PlantingActivity> plantingActivityList;

    public UpdateSequenceNumbers() {
    }

    public UpdateSequenceNumbers(Long updateSequenceNumberID) {
        this.updateSequenceNumberID = updateSequenceNumberID;
    }

    public UpdateSequenceNumbers(Long updateSequenceNumberID, java.util.Date usnDate, Long userID) {
        this.updateSequenceNumberID = updateSequenceNumberID;
        this.usnDate = usnDate;
        this.userID = userID;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUpdateSequenceNumbersDao() : null;
    }

    public Long getUpdateSequenceNumberID() {
        return updateSequenceNumberID;
    }

    public void setUpdateSequenceNumberID(Long updateSequenceNumberID) {
        this.updateSequenceNumberID = updateSequenceNumberID;
    }

    public java.util.Date getUsnDate() {
        return usnDate;
    }

    public void setUsnDate(java.util.Date usnDate) {
        this.usnDate = usnDate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<PlantingActivity> getPlantingActivityList() {
        if (plantingActivityList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlantingActivityDao targetDao = daoSession.getPlantingActivityDao();
            List<PlantingActivity> plantingActivityListNew = targetDao._queryUpdateSequenceNumbers_PlantingActivityList(updateSequenceNumberID);
            synchronized (this) {
                if (plantingActivityList == null) {
                    plantingActivityList = plantingActivityListNew;
                }
            }
        }
        return plantingActivityList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetPlantingActivityList() {
        plantingActivityList = null;
    }

    /**
     * Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context.
     */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context.
     */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context.
     */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

}
