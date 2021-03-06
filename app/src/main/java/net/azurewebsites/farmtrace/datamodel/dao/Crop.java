package net.azurewebsites.farmtrace.datamodel.dao;

import java.util.List;

import net.azurewebsites.farmtrace.datamodel.dao.DaoSession;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table CROP.
 */
public class Crop {

    private Long cropID;
    private String cropName;
    private String cropVariety;

    /**
     * Used to resolve relations
     */
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    private transient CropDao myDao;

    private List<FarmerGroup> farmerGroupList;
    private List<Fertilizer> fertilizerList;
    private List<Seed> seedList;
    private List<PlantingSeason> plantingSeasonList;

    public Crop() {
    }

    public Crop(Long cropID) {
        this.cropID = cropID;
    }

    public Crop(Long cropID, String cropName, String cropVariety) {
        this.cropID = cropID;
        this.cropName = cropName;
        this.cropVariety = cropVariety;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCropDao() : null;
    }

    public Long getCropID() {
        return cropID;
    }

    public void setCropID(Long cropID) {
        this.cropID = cropID;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropVariety() {
        return cropVariety;
    }

    public void setCropVariety(String cropVariety) {
        this.cropVariety = cropVariety;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<FarmerGroup> getFarmerGroupList() {
        if (farmerGroupList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FarmerGroupDao targetDao = daoSession.getFarmerGroupDao();
            List<FarmerGroup> farmerGroupListNew = targetDao._queryCrop_FarmerGroupList(cropID);
            synchronized (this) {
                if (farmerGroupList == null) {
                    farmerGroupList = farmerGroupListNew;
                }
            }
        }
        return farmerGroupList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetFarmerGroupList() {
        farmerGroupList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<Fertilizer> getFertilizerList() {
        if (fertilizerList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FertilizerDao targetDao = daoSession.getFertilizerDao();
            List<Fertilizer> fertilizerListNew = targetDao._queryCrop_FertilizerList(cropID);
            synchronized (this) {
                if (fertilizerList == null) {
                    fertilizerList = fertilizerListNew;
                }
            }
        }
        return fertilizerList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetFertilizerList() {
        fertilizerList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<Seed> getSeedList() {
        if (seedList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SeedDao targetDao = daoSession.getSeedDao();
            List<Seed> seedListNew = targetDao._queryCrop_SeedList(cropID);
            synchronized (this) {
                if (seedList == null) {
                    seedList = seedListNew;
                }
            }
        }
        return seedList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetSeedList() {
        seedList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public List<PlantingSeason> getPlantingSeasonList() {
        if (plantingSeasonList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlantingSeasonDao targetDao = daoSession.getPlantingSeasonDao();
            List<PlantingSeason> plantingSeasonListNew = targetDao._queryCrop_PlantingSeasonList(cropID);
            synchronized (this) {
                if (plantingSeasonList == null) {
                    plantingSeasonList = plantingSeasonListNew;
                }
            }
        }
        return plantingSeasonList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    public synchronized void resetPlantingSeasonList() {
        plantingSeasonList = null;
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
