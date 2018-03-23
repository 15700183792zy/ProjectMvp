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
 * Created by zhouyan on 2017/5/24.
 */
@Entity(nameInDb = "Products")
public class GoodsinfoDao extends AbstractDao<Goodsinfo, String> {
    public static final String TABLENAME = "Products";

    /**
     * Properties of entity Products.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property guid = new Property(0, String.class, "guid", true, "guid");
        public final static Property itemno = new Property(1, String.class, "itemno", false, "itemno");
        public final static Property itemnum = new Property(2, String.class, "itemnum", false, "itemnum");
        public final static Property name = new Property(3, String.class, "name", false, "name");
        public final static Property cprice = new Property(4, Double.class, "cprice", false, "cprice");
        public final static Property tprice = new Property(5, Double.class, "tprice", false, "tprice");
        public final static Property clevel = new Property(6, String.class, "clevel", true, "clevel");
        public final static Property rprice = new Property(7, Double.class, "rprice", false, "rprice");
        public final static Property picurl = new Property(8, String.class, "picurl", false, "picurl");
        public final static Property shortspell = new Property(9, String.class, "shortspell", false, "shortspell");
        public final static Property slevel = new Property(10, String.class, "slevel", false, "slevel");
        public final static Property packagecount = new Property(11, int.class, "packagecount", false, "packagecount");
    }


    public GoodsinfoDao(DaoConfig config) {
        super(config);
    }

    public GoodsinfoDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"Products\" (" + //
                "\"guid\" TEXT PRIMARY KEY NOT NULL ," + // 0: guid
                "\"itemno\" TEXT," + // 1: itemno
                "\"itemnum\" TEXT," + // 2: itemnum
                "\"name\" TEXT," + // 3: name
                "\"cprice\" TEXT," +//4cprice
                "\"tprice\" TEXT," +// 5: tprice
                "\"clevel\" TEXT," +//6clevel
                "\"rprice\" TEXT," +//7rprice
                "\"picurl\" TEXT," +//8picurl
                "\"shortspell\" TEXT," +//9 shortspell
                "\"slevel\" TEXT " + //10 slevel"
                  "\"packagecount\" TEXT," );//11 packagecount
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Products\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Goodsinfo entity) {
        stmt.clearBindings();

        String configid = entity.getGuid();
        if (configid != null) {
            stmt.bindString(1, configid);
        }

        String name = entity.getItemno();
        if (name != null) {
            stmt.bindString(2, name);
        }

        String type = entity.getItemnum();
        if (type != null) {
            stmt.bindString(3, type);
        }

        String configvalue = entity.getName();
        if (configvalue != null) {
            stmt.bindString(4, configvalue);
        }

        double value = entity.getCprice();
        stmt.bindDouble(5, value);

        double tprice = entity.getTprice();
        stmt.bindDouble(6, tprice);

        String clevel = entity.getClevel();
        if (clevel != null) {
            stmt.bindString(7, clevel);
        }

        double rprice = entity.getRprice();
        stmt.bindDouble(8, rprice);

        String picturl = entity.getPicurl();
        if (picturl != null)
            stmt.bindString(9, picturl);

        String slevel = entity.getSlevel();
        if (slevel != null) {
            stmt.bindString(11, slevel);
        }

        stmt.bindLong(12,entity.getPackagecount());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Goodsinfo entity) {
        stmt.clearBindings();


        String configid = entity.getGuid();
        if (configid != null) {
            stmt.bindString(1, configid);
        }

        String name = entity.getItemno();
        if (name != null) {
            stmt.bindString(2, name);
        }

        String type = entity.getItemnum();
        if (type != null) {
            stmt.bindString(3, type);
        }

        String configvalue = entity.getName();
        if (configvalue != null) {
            stmt.bindString(4, configvalue);
        }

        double value = entity.getCprice();
        stmt.bindDouble(5, value);

        double tprice = entity.getTprice();
        stmt.bindDouble(6, tprice);

        String clevel = entity.getClevel();
        if (clevel != null) {
            stmt.bindString(7, clevel);
        }

        double rprice = entity.getRprice();
        stmt.bindDouble(8, rprice);

        String picturl = entity.getPicurl();
        if (picturl != null)
            stmt.bindString(9, picturl);
        String slevel = entity.getSlevel();
        if (slevel != null) {
            stmt.bindString(11, slevel);
        }

        stmt.bindLong(12,entity.getPackagecount());
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public Goodsinfo readEntity(Cursor cursor, int offset) {
        Goodsinfo entity = new Goodsinfo();
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setItemno(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setItemnum(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCprice(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setTprice(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setClevel(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPicurl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSlevel(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPackagecount(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Goodsinfo entity, int offset) {
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setItemno(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setItemnum(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCprice(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
        entity.setTprice(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setClevel(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPicurl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSlevel(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPackagecount(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
    }

    @Override
    protected final String updateKeyAfterInsert(Goodsinfo entity, long rowId) {
        return entity.getGuid();
    }

    @Override
    public String getKey(Goodsinfo entity) {
        if (entity != null) {
            return entity.getGuid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Goodsinfo entity) {
        return entity.getGuid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
}
