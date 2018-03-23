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

@Entity(nameInDb = "Shops")
public class ShopDao extends AbstractDao<Shop, String> {
    public static final String TABLENAME = "Shops";

    /**
     * Properties of entity Shops.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     *
     * @Id
     * @Property(nameInDb = "configid")
     * private int configid;
     * @Property(nameInDb = "name")
     * private String name;
     * @Property(nameInDb = "type")
     * private int type;
     * @Property(nameInDb = "configvalue")
     * private String configvalue;
     * @Property(nameInDb = "value")
     * private String value;
     */
    public static class Properties {
        public final static Property guid = new Property(0, String.class, "guid", true, "guid");
        public final static Property name = new Property(1, String.class, "name", false, "name");
    }


    public ShopDao(DaoConfig config) {
        super(config);
    }

    public ShopDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"Shops\" (" + //
                "\"guid\" TEXT PRIMARY KEY NOT NULL ," + // 0: areaCode
                "\"name\" TEXT" + // 1: areaName
                ");"); // 4: areanamefull
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Shops\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Shop entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }


    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Shop entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public Shop readEntity(Cursor cursor, int offset) {
        Shop entity = new Shop();

        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0)); // guid
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)); // name


        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Shop entity, int offset) {
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0)); // guid
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1)); // name
    }

    @Override
    protected final String updateKeyAfterInsert(Shop entity, long rowId) {
        return entity.getGuid();
    }

    @Override
    public String getKey(Shop entity) {
        if (entity != null) {
            return entity.getGuid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Shop entity) {
        return entity.getGuid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}
