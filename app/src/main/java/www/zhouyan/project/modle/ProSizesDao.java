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
 * Created by mac on 07/00/19.
 */
@Entity(nameInDb = "ProSizes")
public class ProSizesDao extends AbstractDao<ProSizes, String> {
    public static final String TABLENAME = "ProSizes";

    /**
     * Properties of entity ProSizes.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property pguid = new Property(0, String.class, "pguid", true, "pguid");
        public final static Property dguid = new Property(1, String.class, "dguid", false, "dguid");
        public final static Property name = new Property(2, String.class, "name", false, "name");
    }


    public ProSizesDao(DaoConfig config) {
        super(config);
    }

    public ProSizesDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProSizes\" (" + //
                "\"pguid\" TEXT  PRIMARY KEY NOT NULL ," + // 0: pguid
                "\"dguid\" TEXT," + // 1: dguid
                "\"name\" TEXT" + // 2: name
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProSizes\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ProSizes entity) {
        stmt.clearBindings();

        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(1, pguid);
        }

        String dguid = entity.getDguid();
        stmt.bindString(2, dguid);

        String name = entity.getName();
        stmt.bindString(3, name);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ProSizes entity) {
        stmt.clearBindings();


        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(1, pguid);
        }

        String dguid = entity.getDguid();
        stmt.bindString(2, dguid);

        String name = entity.getName();
        stmt.bindString(3, name);

    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public ProSizes readEntity(Cursor cursor, int offset) {
        ProSizes entity = new ProSizes();
        entity.setPguid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));

        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, ProSizes entity, int offset) {

        entity.setPguid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
    }

    @Override
    protected final String updateKeyAfterInsert(ProSizes entity, long rowId) {
        return entity.getPguid();
    }

    @Override
    public String getKey(ProSizes entity) {
        if (entity != null) {
            return entity.getPguid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ProSizes entity) {
        return entity.getPguid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}