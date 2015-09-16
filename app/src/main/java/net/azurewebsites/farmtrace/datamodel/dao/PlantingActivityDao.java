package net.azurewebsites.farmtrace.datamodel.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table PLANTING_ACTIVITY.
 */
public class PlantingActivityDao extends AbstractDao<PlantingActivity, Long> {

    public static final String TABLENAME = "PLANTING_ACTIVITY";

    /**
     * Properties of entity PlantingActivity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PlantingActivityID = new Property(0, Long.class, "plantingActivityID", true, "PLANTING_ACTIVITY_ID");
        public final static Property ActivityType = new Property(1, Integer.class, "activityType", false, "ACTIVITY_TYPE");
        public final static Property Input = new Property(2, String.class, "input", false, "INPUT");
        public final static Property Quantity = new Property(3, Double.class, "quantity", false, "QUANTITY");
        public final static Property Location = new Property(4, String.class, "location", false, "LOCATION");
        public final static Property ActivityDate = new Property(5, java.util.Date.class, "activityDate", false, "ACTIVITY_DATE");
        public final static Property UserID = new Property(6, Long.class, "userID", false, "USER_ID");
        public final static Property FieldID = new Property(7, Long.class, "fieldID", false, "FIELD_ID");
        public final static Property UsnID = new Property(8, Long.class, "usnID", false, "USN_ID");
    }

    ;

    private Query<PlantingActivity> user_PlantingActivityListQuery;
    private Query<PlantingActivity> field_PlantingActivityListQuery;
    private Query<PlantingActivity> updateSequenceNumbers_PlantingActivityListQuery;

    public PlantingActivityDao(DaoConfig config) {
        super(config);
    }

    public PlantingActivityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'PLANTING_ACTIVITY' (" + //
                "'PLANTING_ACTIVITY_ID' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: plantingActivityID
                "'ACTIVITY_TYPE' INTEGER," + // 1: activityType
                "'INPUT' TEXT," + // 2: input
                "'QUANTITY' REAL," + // 3: quantity
                "'LOCATION' TEXT," + // 4: location
                "'ACTIVITY_DATE' INTEGER," + // 5: activityDate
                "'USER_ID' INTEGER," + // 6: userID
                "'FIELD_ID' INTEGER," + // 7: fieldID
                "'USN_ID' INTEGER);"); // 8: usnID
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PLANTING_ACTIVITY'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, PlantingActivity entity) {
        stmt.clearBindings();

        Long plantingActivityID = entity.getPlantingActivityID();
        if (plantingActivityID != null) {
            stmt.bindLong(1, plantingActivityID);
        }

        Integer activityType = entity.getActivityType();
        if (activityType != null) {
            stmt.bindLong(2, activityType);
        }

        String input = entity.getInput();
        if (input != null) {
            stmt.bindString(3, input);
        }

        Double quantity = entity.getQuantity();
        if (quantity != null) {
            stmt.bindDouble(4, quantity);
        }

        String location = entity.getLocation();
        if (location != null) {
            stmt.bindString(5, location);
        }

        java.util.Date activityDate = entity.getActivityDate();
        if (activityDate != null) {
            stmt.bindLong(6, activityDate.getTime());
        }

        Long userID = entity.getUserID();
        if (userID != null) {
            stmt.bindLong(7, userID);
        }

        Long fieldID = entity.getFieldID();
        if (fieldID != null) {
            stmt.bindLong(8, fieldID);
        }

        Long usnID = entity.getUsnID();
        if (usnID != null) {
            stmt.bindLong(9, usnID);
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public PlantingActivity readEntity(Cursor cursor, int offset) {
        PlantingActivity entity = new PlantingActivity( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // plantingActivityID
                cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // activityType
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // input
                cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3), // quantity
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // location
                cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // activityDate
                cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6), // userID
                cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7), // fieldID
                cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8) // usnID
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, PlantingActivity entity, int offset) {
        entity.setPlantingActivityID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setActivityType(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setInput(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setQuantity(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setLocation(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setActivityDate(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setUserID(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setFieldID(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
        entity.setUsnID(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(PlantingActivity entity, long rowId) {
        entity.setPlantingActivityID(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(PlantingActivity entity) {
        if (entity != null) {
            return entity.getPlantingActivityID();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    /**
     * Internal query to resolve the "plantingActivityList" to-many relationship of User.
     */
    public List<PlantingActivity> _queryUser_PlantingActivityList(Long userID) {
        synchronized (this) {
            if (user_PlantingActivityListQuery == null) {
                QueryBuilder<PlantingActivity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UserID.eq(null));
                user_PlantingActivityListQuery = queryBuilder.build();
            }
        }
        Query<PlantingActivity> query = user_PlantingActivityListQuery.forCurrentThread();
        query.setParameter(0, userID);
        return query.list();
    }

    /**
     * Internal query to resolve the "plantingActivityList" to-many relationship of Field.
     */
    public List<PlantingActivity> _queryField_PlantingActivityList(Long fieldID) {
        synchronized (this) {
            if (field_PlantingActivityListQuery == null) {
                QueryBuilder<PlantingActivity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.FieldID.eq(null));
                field_PlantingActivityListQuery = queryBuilder.build();
            }
        }
        Query<PlantingActivity> query = field_PlantingActivityListQuery.forCurrentThread();
        query.setParameter(0, fieldID);
        return query.list();
    }

    /**
     * Internal query to resolve the "plantingActivityList" to-many relationship of UpdateSequenceNumbers.
     */
    public List<PlantingActivity> _queryUpdateSequenceNumbers_PlantingActivityList(Long usnID) {
        synchronized (this) {
            if (updateSequenceNumbers_PlantingActivityListQuery == null) {
                QueryBuilder<PlantingActivity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UsnID.eq(null));
                updateSequenceNumbers_PlantingActivityListQuery = queryBuilder.build();
            }
        }
        Query<PlantingActivity> query = updateSequenceNumbers_PlantingActivityListQuery.forCurrentThread();
        query.setParameter(0, usnID);
        return query.list();
    }

}
