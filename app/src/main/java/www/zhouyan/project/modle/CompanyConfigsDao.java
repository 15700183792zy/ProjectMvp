package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 * 同步设置
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import www.zhouyan.project.modle.dao.DaoSession2;

@Entity(nameInDb = "CompanyConfigs")
public class CompanyConfigsDao extends AbstractDao<CompanyConfigs, Integer> {
    public static final String TABLENAME = "CompanyConfigs";

    /**
     * Properties of entity CompanyConfigs.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     *  @Id
     @Property(nameInDb = "configid")
     private int configid;
     @Property(nameInDb = "name")
     private String name;
     @Property(nameInDb = "type")
     private int type;
     @Property(nameInDb = "configvalue")
     private String configvalue;
     @Property(nameInDb = "value")
     private String value;

     */
    public static class Properties {
        public final static Property configid = new Property(0, int.class, "configid", true, "configid");
        public final static Property name = new Property(1, String.class, "name", false, "name");
        public final static Property type = new Property(2, int.class, "type", false, "type");
        public final static Property configvalue = new Property(3, String.class, "configvalue", false, "configvalue");
        public final static Property value = new Property(4, String.class, "value", false, "value");
    }


    public CompanyConfigsDao(DaoConfig config) {
        super(config);
    }

    public CompanyConfigsDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CompanyConfigs\" (" + //
                "\"configid\" TEXT PRIMARY KEY NOT NULL ," + // 0: areaCode
                "\"name\" TEXT," + // 1: areaName
                "\"type\" TEXT," + // 2: postCode
                "\"configvalue\" TEXT," + // 3: zoneCode
                "\"value\" TEXT);"); // 4: areanamefull
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CompanyConfigs\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CompanyConfigs entity) {
        stmt.clearBindings();

        int configid = entity.getConfigid();
        if (configid != 0) {
            stmt.bindLong(1, configid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }

        int type = entity.getType();
        if (type != 0) {
            stmt.bindLong(3, type);
        }

        String configvalue = entity.getConfigvalue();
        if(configvalue==null)  configvalue="";
        if (configvalue != null) {
            stmt.bindString(4, configvalue);
        }

        String value = entity.getValue();
        if (value != null) {
            stmt.bindString(5, value);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CompanyConfigs entity) {
        stmt.clearBindings();

        int configid = entity.getConfigid();
        if (configid != 0) {
            stmt.bindLong(1, configid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }

        int type = entity.getType();
        if (type != 0) {
            stmt.bindLong(3, type);
        }

        String configvalue = entity.getConfigvalue();
        if(configvalue==null)  configvalue="";
        if (configvalue != null) {
            stmt.bindString(4, configvalue);
        }

        String value = entity.getValue();
        if (value != null) {
            stmt.bindString(5, value);
        }
    }

    @Override
    public Integer readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0);
    }

    @Override
    public CompanyConfigs readEntity(Cursor cursor, int offset) {
        CompanyConfigs entity = new CompanyConfigs(
                cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0), // configid
                cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // type
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // configvalue
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // value
        );
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, CompanyConfigs entity, int offset) {
        entity.setConfigid(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setType(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setConfigvalue(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setValue(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
    }

    @Override
    protected final Integer updateKeyAfterInsert(CompanyConfigs entity, long rowId) {
        return entity.getConfigid();
    }

    @Override
    public Integer getKey(CompanyConfigs entity) {
        if(entity != null) {
            return entity.getConfigid();
        } else {
            return 0;
        }
    }

    @Override
    public boolean hasKey(CompanyConfigs entity) {
        return entity.getConfigid() != 0;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}
