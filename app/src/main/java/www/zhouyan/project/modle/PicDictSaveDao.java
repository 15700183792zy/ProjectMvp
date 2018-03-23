package www.zhouyan.project.modle;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import www.zhouyan.project.modle.dao.DaoSession2;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/20 18:38
 * 修改人: zhouyan
 * 修改时间: 2017/6/20 18:38
 * 修改备注:
 * 这项表 ProDicts 字典
 */
@Entity(nameInDb = "ProDicts")
public class PicDictSaveDao extends AbstractDao<PicDictSave, String> {
    public static final String TABLENAME = "ProDicts";

    /**
     * Properties of entity ProDicts.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static org.greenrobot.greendao.Property guid = new org.greenrobot.greendao.Property(0, String.class, "guid", true, "guid");
        public final static org.greenrobot.greendao.Property orderno = new org.greenrobot.greendao.Property(1, String.class, "orderno", false, "orderno");
        public final static org.greenrobot.greendao.Property dtype = new org.greenrobot.greendao.Property(2, int.class, "dtype", false, "dtype");
        public final static org.greenrobot.greendao.Property name = new org.greenrobot.greendao.Property(3, String.class, "name", false, "name");
        public final static org.greenrobot.greendao.Property pguid = new org.greenrobot.greendao.Property(4, String.class, "pguid", false, "pguid");
        public final static org.greenrobot.greendao.Property issys = new org.greenrobot.greendao.Property(5, String.class, "issys", false, "issys");
        public final static org.greenrobot.greendao.Property isstop = new org.greenrobot.greendao.Property(6, String.class, "isstop", false, "isstop");
        public final static org.greenrobot.greendao.Property shortspell = new org.greenrobot.greendao.Property(7, String.class, "shortspell", false, "shortspell");
    }


    public PicDictSaveDao(DaoConfig config) {
        super(config);
    }

    public PicDictSaveDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProDicts\" (" + //
                "\"guid\" TEXT PRIMARY KEY NOT NULL ," + // 0: guid
                "\"orderno\" TEXT," + // 1: orderno
                "\"dtype\" TEXT," + // 2: dtype
                "\"name\" TEXT," + // 3: name
                "\"pguid\" TEXT," + // 4: pguid
                "\"issys\" TEXT" + // 4: issys
                "\"isstop\" TEXT" + // 4: isstop
                "\"shortspell\" TEXT" + // 4: shortspell
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProDicts\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PicDictSave entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String orderno = entity.getOrderno();
        if (orderno != null) {
            stmt.bindString(2, orderno);
        }

        int dtype = entity.getDtype();
        if (dtype != 0) {
            stmt.bindLong(3, dtype);
        }


        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }

        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(5, pguid);
        }

        stmt.bindString(6, entity.issys());
        stmt.bindString(7, entity.getIsstop());
        stmt.bindString(8, entity.getShortspell());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PicDictSave entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String orderno = entity.getOrderno();
        if (orderno != null) {
            stmt.bindString(2, orderno);
        }

        int dtype = entity.getDtype();
        if (dtype != 0) {
            stmt.bindLong(3, dtype);
        }


        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }

        String pguid = entity.getPguid();
        if (pguid != null) {
            stmt.bindString(5, pguid);
        }

        stmt.bindString(6, entity.issys());
        stmt.bindString(7, entity.getIsstop());
        stmt.bindString(8, entity.getShortspell());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public PicDictSave readEntity(Cursor cursor, int offset) {
        PicDictSave entity = new PicDictSave();
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setOrderno(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDtype(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPguid(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIssys(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIsstop(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setShortspell(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, PicDictSave entity, int offset) {
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setOrderno(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDtype(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPguid(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIssys(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIsstop(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setShortspell(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
    }

    @Override
    protected final String updateKeyAfterInsert(PicDictSave entity, long rowId) {
        return entity.getGuid();
    }

    @Override
    public String getKey(PicDictSave entity) {
        if (entity != null) {
            return entity.getGuid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PicDictSave entity) {
        return entity.getGuid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}
