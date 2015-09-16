package net.azurewebsites.farmtrace.datamodel.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import net.azurewebsites.farmtrace.datamodel.dao.CropDao;
import net.azurewebsites.farmtrace.datamodel.dao.UserDao;
import net.azurewebsites.farmtrace.datamodel.dao.ChemicalDao;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerGroupDao;
import net.azurewebsites.farmtrace.datamodel.dao.FarmerDao;
import net.azurewebsites.farmtrace.datamodel.dao.FertilizerDao;
import net.azurewebsites.farmtrace.datamodel.dao.FieldDao;
import net.azurewebsites.farmtrace.datamodel.dao.SeedDao;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingSeasonDao;
import net.azurewebsites.farmtrace.datamodel.dao.PlantingActivityDao;
import net.azurewebsites.farmtrace.datamodel.dao.UpdateSequenceNumbersDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * Master of DAO (schema version 22): knows all DAOs.
 */
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 22;

    /**
     * Creates underlying database table using DAOs.
     */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        CropDao.createTable(db, ifNotExists);
        UserDao.createTable(db, ifNotExists);
        ChemicalDao.createTable(db, ifNotExists);
        FarmerGroupDao.createTable(db, ifNotExists);
        FarmerDao.createTable(db, ifNotExists);
        FertilizerDao.createTable(db, ifNotExists);
        FieldDao.createTable(db, ifNotExists);
        SeedDao.createTable(db, ifNotExists);
        PlantingSeasonDao.createTable(db, ifNotExists);
        PlantingActivityDao.createTable(db, ifNotExists);
        UpdateSequenceNumbersDao.createTable(db, ifNotExists);
    }

    /**
     * Drops underlying database table using DAOs.
     */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        CropDao.dropTable(db, ifExists);
        UserDao.dropTable(db, ifExists);
        ChemicalDao.dropTable(db, ifExists);
        FarmerGroupDao.dropTable(db, ifExists);
        FarmerDao.dropTable(db, ifExists);
        FertilizerDao.dropTable(db, ifExists);
        FieldDao.dropTable(db, ifExists);
        SeedDao.dropTable(db, ifExists);
        PlantingSeasonDao.dropTable(db, ifExists);
        PlantingActivityDao.dropTable(db, ifExists);
        UpdateSequenceNumbersDao.dropTable(db, ifExists);
    }

    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /**
     * WARNING: Drops all table on Upgrade! Use only during development.
     */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(CropDao.class);
        registerDaoClass(UserDao.class);
        registerDaoClass(ChemicalDao.class);
        registerDaoClass(FarmerGroupDao.class);
        registerDaoClass(FarmerDao.class);
        registerDaoClass(FertilizerDao.class);
        registerDaoClass(FieldDao.class);
        registerDaoClass(SeedDao.class);
        registerDaoClass(PlantingSeasonDao.class);
        registerDaoClass(PlantingActivityDao.class);
        registerDaoClass(UpdateSequenceNumbersDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }

}
