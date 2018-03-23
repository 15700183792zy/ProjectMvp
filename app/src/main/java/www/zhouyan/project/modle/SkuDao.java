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
 * Created by zhouyan on 17/6/28.
 */
@Entity(nameInDb = "ProSKUs")
public class SkuDao extends AbstractDao<Sku, String> {
    public static final String TABLENAME = "ProSKUs";

    /**
     * Properties of entity ProSKUs.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static org.greenrobot.greendao.Property pguid = new org.greenrobot.greendao.Property(0, String.class, "pguid", false, "pguid");
        public final static org.greenrobot.greendao.Property colorguid = new org.greenrobot.greendao.Property(1, String.class, "colorguid", false, "colorguid");
        public final static org.greenrobot.greendao.Property sizeguid = new org.greenrobot.greendao.Property(2, String.class, "sizeguid", false, "sizeguid");
        public final static org.greenrobot.greendao.Property cprice = new org.greenrobot.greendao.Property(3, double.class, "cprice", false, "cprice");
        public final static org.greenrobot.greendao.Property tprice = new org.greenrobot.greendao.Property(4, double.class, "tprice", false, "tprice");
    }


    public SkuDao(DaoConfig config) {
        super(config);
    }

    public SkuDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"ProSKUs\" (" + //
                "\"pguid\" TEXT PRIMARY KEY NOT NULL ," + // 0: guid
                "\"colorguid\" TEXT," + // 1: colorguid
                "\"sizeguid\" TEXT," + // 2: sizeguid
                "\"cprice\" TEXT," + // 3: cprice
                "\"tprice\" TEXT" + // 4: tprice
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ProSKUs\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Sku entity) {
        stmt.clearBindings();

        String guid = entity.getPguid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String colorguid = entity.getColorguid();
        if (colorguid != null) {
            stmt.bindString(2, colorguid);
        }

        String sizeguid = entity.getSizeguid();
        if (sizeguid != null) {
            stmt.bindString(3, sizeguid);
        }

        double cprice = entity.getCprice();
        stmt.bindDouble(4, cprice);


        double tprice = entity.getTprice();
        stmt.bindDouble(5, tprice);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Sku entity) {
        stmt.clearBindings();

        String guid = entity.getPguid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String colorguid = entity.getColorguid();
        if (colorguid != null) {
            stmt.bindString(2, colorguid);
        }

        String sizeguid = entity.getSizeguid();
        if (sizeguid != null) {
            stmt.bindString(3, sizeguid);
        }

        double cprice = entity.getCprice();
        stmt.bindDouble(4, cprice);


        double tprice = entity.getTprice();
        stmt.bindDouble(5, tprice);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public Sku readEntity(Cursor cursor, int offset) {
        Sku entity = new Sku();
        entity.setPguid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setColorguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSizeguid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCprice(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setTprice(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Sku entity, int offset) {
        entity.setPguid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setColorguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSizeguid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCprice(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setTprice(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
    }

    @Override
    protected final String updateKeyAfterInsert(Sku entity, long rowId) {
        return entity.getPguid();
    }

    @Override
    public String getKey(Sku entity) {
        if (entity != null) {
            return entity.getPguid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Sku entity) {
        return entity.getPguid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}

