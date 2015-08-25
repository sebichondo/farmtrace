package net.azurewebsites.farmtrace.datamodel.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.azurewebsites.farmtrace.datamodel.dao.Chemical;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CHEMICAL.
*/
public class ChemicalDao extends AbstractDao<Chemical, Long> {

    public static final String TABLENAME = "CHEMICAL";

    /**
     * Properties of entity Chemical.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property ChemicalID = new Property(0, Long.class, "chemicalID", true, "CHEMICAL_ID");
        public final static Property ChemicalType = new Property(1, Integer.class, "chemicalType", false, "CHEMICAL_TYPE");
        public final static Property CropStage = new Property(2, Integer.class, "cropStage", false, "CROP_STAGE");
        public final static Property ActiveIngredient = new Property(3, Integer.class, "activeIngredient", false, "ACTIVE_INGREDIENT");
        public final static Property Agent = new Property(4, String.class, "agent", false, "AGENT");
        public final static Property Manufacturer = new Property(5, String.class, "manufacturer", false, "MANUFACTURER");
        public final static Property PHI = new Property(6, Integer.class, "pHI", false, "P_HI");
        public final static Property ProductTradeName = new Property(7, String.class, "productTradeName", false, "PRODUCT_TRADE_NAME");
        public final static Property Rate = new Property(8, Integer.class, "rate", false, "RATE");
        public final static Property ReasonForUse = new Property(9, String.class, "reasonForUse", false, "REASON_FOR_USE");
        public final static Property RegistrationNumber = new Property(10, String.class, "registrationNumber", false, "REGISTRATION_NUMBER");
    };


    public ChemicalDao(DaoConfig config) {
        super(config);
    }
    
    public ChemicalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'CHEMICAL' (" + //
                "'CHEMICAL_ID' INTEGER PRIMARY KEY ," + // 0: chemicalID
                "'CHEMICAL_TYPE' INTEGER," + // 1: chemicalType
                "'CROP_STAGE' INTEGER," + // 2: cropStage
                "'ACTIVE_INGREDIENT' INTEGER," + // 3: activeIngredient
                "'AGENT' TEXT," + // 4: agent
                "'MANUFACTURER' TEXT," + // 5: manufacturer
                "'P_HI' INTEGER," + // 6: pHI
                "'PRODUCT_TRADE_NAME' TEXT," + // 7: productTradeName
                "'RATE' INTEGER," + // 8: rate
                "'REASON_FOR_USE' TEXT," + // 9: reasonForUse
                "'REGISTRATION_NUMBER' TEXT);"); // 10: registrationNumber
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'CHEMICAL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Chemical entity) {
        stmt.clearBindings();
 
        Long chemicalID = entity.getChemicalID();
        if (chemicalID != null) {
            stmt.bindLong(1, chemicalID);
        }
 
        Integer chemicalType = entity.getChemicalType();
        if (chemicalType != null) {
            stmt.bindLong(2, chemicalType);
        }
 
        Integer cropStage = entity.getCropStage();
        if (cropStage != null) {
            stmt.bindLong(3, cropStage);
        }
 
        Integer activeIngredient = entity.getActiveIngredient();
        if (activeIngredient != null) {
            stmt.bindLong(4, activeIngredient);
        }
 
        String agent = entity.getAgent();
        if (agent != null) {
            stmt.bindString(5, agent);
        }
 
        String manufacturer = entity.getManufacturer();
        if (manufacturer != null) {
            stmt.bindString(6, manufacturer);
        }
 
        Integer pHI = entity.getPHI();
        if (pHI != null) {
            stmt.bindLong(7, pHI);
        }
 
        String productTradeName = entity.getProductTradeName();
        if (productTradeName != null) {
            stmt.bindString(8, productTradeName);
        }
 
        Integer rate = entity.getRate();
        if (rate != null) {
            stmt.bindLong(9, rate);
        }
 
        String reasonForUse = entity.getReasonForUse();
        if (reasonForUse != null) {
            stmt.bindString(10, reasonForUse);
        }
 
        String registrationNumber = entity.getRegistrationNumber();
        if (registrationNumber != null) {
            stmt.bindString(11, registrationNumber);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Chemical readEntity(Cursor cursor, int offset) {
        Chemical entity = new Chemical( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // chemicalID
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // chemicalType
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // cropStage
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // activeIngredient
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // agent
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // manufacturer
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // pHI
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // productTradeName
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // rate
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // reasonForUse
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10) // registrationNumber
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Chemical entity, int offset) {
        entity.setChemicalID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setChemicalType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCropStage(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setActiveIngredient(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setAgent(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setManufacturer(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPHI(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setProductTradeName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRate(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setReasonForUse(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setRegistrationNumber(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Chemical entity, long rowId) {
        entity.setChemicalID(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Chemical entity) {
        if(entity != null) {
            return entity.getChemicalID();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
