package www.zhouyan.project.modle;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import www.zhouyan.project.modle.dao.DaoSession2;

/**
 * Created by mac on 17/11/29.
 */
@Entity(nameInDb = "ProColors")
public class ProColorsDao extends AbstractDao<ProColors, String> {
    public static final String TABLENAME = "ProColors";

    /**
     * Properties of entity ProColors.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property picurl = new Property(0, String.class, "false", false, "picurl");
        public final static Property pguid = new Property(1, String.class, "pguid", true, "pguid");
        public final static Property dguid = new Property(2, String.class, "dguid", false, "dguid");
        public final static Property name = new Property(3, String.class, "name", false, "name");
    }


    public ProColorsDao(DaoConfig config) {
        super(config);
    }

    public ProColorsDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProColors\" (" + //
                "\"picurl\" TEXT," + // 0: picurl
                "\"pguid\" TEXT  PRIMARY KEY NOT NULL ," + // 1: pguid
                "\"dguid\" TEXT," + // 2: dguid
                "\"name\" TEXT" + // 3: name
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProColors\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ProColors entity) {
        stmt.clearBindings();

        String picurl = entity.getPicurl();
        stmt.bindString(1, picurl);

        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(2, pguid);
        }

        String dguid = entity.getDguid();
        stmt.bindString(3, dguid);

        String name = entity.getName();
        stmt.bindString(4, name);


    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ProColors entity) {
        stmt.clearBindings();

        String picurl = entity.getPicurl();
        stmt.bindString(1, picurl);

        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(2, pguid);
        }

        String dguid = entity.getDguid();
        stmt.bindString(3, dguid);

        String name = entity.getName();
        stmt.bindString(4, name);

    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public ProColors readEntity(Cursor cursor, int offset) {
        ProColors entity = new ProColors();
        entity.setPicurl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDguid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, ProColors entity, int offset) {
        entity.setPicurl(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setPguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDguid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
    }

    @Override
    protected final String updateKeyAfterInsert(ProColors entity, long rowId) {
        return entity.getPguid();
    }

    @Override
    public String getKey(ProColors entity) {
        if (entity != null) {
            return entity.getPguid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ProColors entity) {
        return entity.getPguid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}