package www.zhouyan.project.modle.daoarea;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/12 17:13
 * 修改人: zhouyan
 * 修改时间: 2017/6/12 17:13
 * 修改备注:
 */

/**
 * DAO for table "AreaCode".
 */
public class AreaCodeDao extends AbstractDao<AreaCode, String> {

    public static final String TABLENAME = "AreaCode";

    /**
     * Properties of entity AreaCode.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AreaCode = new Property(0, String.class, "areaCode", true, "areacode");
        public final static Property AreaName = new Property(1, String.class, "areaName", false, "areaname");
        public final static Property PostCode = new Property(2, String.class, "postCode", false, "postcode");
        public final static Property ZoneCode = new Property(3, String.class, "zoneCode", false, "zonecode");
        public final static Property AreaNamefull = new Property(4, String.class, "areanamefull", false, "areanamefull");
    }


    public AreaCodeDao(DaoConfig config) {
        super(config);
    }

    public AreaCodeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"AreaCode\" (" + //
                "\"areacode\" TEXT PRIMARY KEY NOT NULL ," + // 0: areaCode
                "\"areaname\" TEXT," + // 1: areaName
                "\"postcode\" TEXT," + // 2: postCode
                "\"zonecode\" TEXT," + // 3: zoneCode
                "\"areanamefull\" TEXT);"); // 4: areanamefull
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AreaCode\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AreaCode entity) {
        stmt.clearBindings();

        String areaCode = entity.getAreaCode();
        if (areaCode != null) {
            stmt.bindString(1, areaCode);
        }

        String areaName = entity.getAreaName();
        if (areaName != null) {
            stmt.bindString(2, areaName);
        }

        String postCode = entity.getPostCode();
        if (postCode != null) {
            stmt.bindString(3, postCode);
        }

        String zoneCode = entity.getZoneCode();
        if (zoneCode != null) {
            stmt.bindString(4, zoneCode);
        }

        String areanamefull = entity.getareanamefull();
        if (areanamefull != null) {
            stmt.bindString(5, areanamefull);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AreaCode entity) {
        stmt.clearBindings();

        String areaCode = entity.getAreaCode();
        if (areaCode != null) {
            stmt.bindString(1, areaCode);
        }

        String areaName = entity.getAreaName();
        if (areaName != null) {
            stmt.bindString(2, areaName);
        }

        String postCode = entity.getPostCode();
        if (postCode != null) {
            stmt.bindString(3, postCode);
        }

        String zoneCode = entity.getZoneCode();
        if (zoneCode != null) {
            stmt.bindString(4, zoneCode);
        }

        String areanamefull = entity.getareanamefull();
        if (areanamefull != null) {
            stmt.bindString(5, areanamefull);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public AreaCode readEntity(Cursor cursor, int offset) {
        AreaCode entity = new AreaCode( //
                cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // areaCode
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // areaName
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // postCode
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // zoneCode
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // areanamefull
        );
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, AreaCode entity, int offset) {
        entity.setAreaCode(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setAreaName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPostCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setZoneCode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setareanamefull(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
    }

    @Override
    protected final String updateKeyAfterInsert(AreaCode entity, long rowId) {
        return entity.getAreaCode();
    }

    @Override
    public String getKey(AreaCode entity) {
        if(entity != null) {
            return entity.getAreaCode();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AreaCode entity) {
        return entity.getAreaCode() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}