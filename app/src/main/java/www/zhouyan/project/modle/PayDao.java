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

@Entity(nameInDb = "CompanyAccounts")
public class PayDao extends AbstractDao<Pay, String> {
    public static final String TABLENAME = "CompanyAccounts";

    /**
     * Properties of entity CompanyAccounts.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property guid = new Property(0, String.class, "guid", true, "guid");
        public final static Property sguid = new Property(1, String.class, "sguid", false, "sguid");
        public final static Property orderno = new Property(2, int.class, "orderno", false, "orderno");
        public final static Property name = new Property(3, String.class, "name", false, "name");
        public final static Property accounttype = new Property(4, int.class, "accounttype", false, "accounttype");
    }


    public PayDao(DaoConfig config) {
        super(config);
    }

    public PayDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"CompanyAccounts\" (" + //
                "\"guid\" TEXT PRIMARY KEY NOT NULL ," + // 0: guid
                "\"sguid\" TEXT," + // 1: sguid
                "\"orderno\" TEXT," + // 2: orderno
                "\"name\" TEXT," + // 3: name
                "\"accounttype\" TEXT," + // 4: accounttype
                " TEXT);");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CompanyAccounts\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Pay entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }

        int accounttype = entity.getAccounttype();
        stmt.bindLong(5, accounttype);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Pay entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }

        int accounttype = entity.getAccounttype();
        stmt.bindLong(5, accounttype);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public Pay readEntity(Cursor cursor, int offset) {
        Pay entity = new Pay();
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAccounttype(cursor.isNull(offset + 4) ? null : cursor.getInt(offset +4));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Pay entity, int offset) {
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAccounttype(cursor.isNull(offset + 4) ? null : cursor.getInt(offset +4));
    }

    @Override
    protected final String updateKeyAfterInsert(Pay entity, long rowId) {
        return entity.getGuid();
    }

    @Override
    public String getKey(Pay entity) {
        if (entity != null) {
            return entity.getGuid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Pay entity) {
        return entity.getGuid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}
