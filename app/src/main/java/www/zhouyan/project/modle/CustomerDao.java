package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 * 合作伙伴
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.ArrayList;

import www.zhouyan.project.modle.dao.DaoSession2;

@Entity(nameInDb = "ClientInfoes")
public class CustomerDao extends AbstractDao<Customer, String> {
    public static final String TABLENAME = "ClientInfoes";

    /**
     * Properties of entity ClientInfoes.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property guid = new Property(0, String.class, "guid", true, "guid");
        public final static Property lguid = new Property(1, String.class, "lguid", false, "lguid");
        public final static Property rebate = new Property(2, int.class, "rebate", false, "rebate");
        public final static Property mobile = new Property(3, String.class, "mobile", false, "mobile");
        public final static Property areacode = new Property(4, String.class, "areacode", false, "areacode");
        public final static Property areaname = new Property(5, String.class, "areaname", false, "areaname");
        public final static Property name = new Property(6, String.class, "name", false, "name");
        public final static Property contract = new Property(7, String.class, "contract", false, "contract");
        public final static Property contractmobile = new Property(8, String.class, "contractmobile", false, "contractmobile");
        public final static Property shortspell = new Property(9, String.class, "shortspell", false, "shortspell");
        public final static Property firstletter = new Property(10, String.class, "firstletter", false, "firstletter");
        public final static Property areanamefull = new Property(11, String.class, "areanamefull", false, "areanamefull");
        public final static Property clienttype = new Property(12, int.class, "clienttype", false, "clienttype");

    }


    public CustomerDao(DaoConfig config) {
        super(config);
    }

    public CustomerDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"ClientInfoes\" (" + //
                "\"guid\" TEXT PRIMARY KEY NOT NULL ," + // 0: guid
                "\"lguid\" TEXT," + // 1: lguid
                "\"rebate\" TEXT," + // 2: rebate
                "\"mobile\" TEXT," + // 3: mobile
                "\"areacode\" TEXT," + // 4: areacode
                "\"areaname\" TEXT" + // 5: areaname
                "\"name\" TEXT" + // 6: name
                "\"contract\" TEXT," + // 7: contract
                "\"contractmobile\" TEXT" + // 8: contractmobile
                "\"shortspell\" TEXT," + // 9: shortspell
                "\"firstletter\" TEXT," + // 10: contract
                "\"areanamefull\" TEXT" + // 11: contractmobile
                "\"clienttype\" TEXT" + // 12: shortspell
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ClientInfoes\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Customer entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String lguid = entity.getLguid();
        if (lguid != null) {
            stmt.bindString(2, lguid);
        }

        int rebate = entity.getRebate();
        if (rebate != 0) {
            stmt.bindLong(3, rebate);
        }

        String configvalue = entity.getMobile();
        stmt.bindString(4, configvalue);


        String name = entity.getName();
        if (name != null) {
            stmt.bindString(7, name);
        }

        String shortspell = entity.getShortspell();
        if (shortspell != null) {
            stmt.bindString(10, shortspell);
        }

        int clienttype = entity.getClienttype();
        if (clienttype != 0) {
            stmt.bindLong(13, clienttype);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Customer entity) {
        stmt.clearBindings();

        String guid = entity.getGuid();
        if (guid != null) {
            stmt.bindString(1, guid);
        }

        String lguid = entity.getLguid();
        if (lguid != null) {
            stmt.bindString(2, lguid);
        }

        int rebate = entity.getRebate();
        if (rebate != 0) {
            stmt.bindLong(3, rebate);
        }

        String configvalue = entity.getMobile();
        stmt.bindString(4, configvalue);


        String name = entity.getName();
        if (name != null) {
            stmt.bindString(7, name);
        }

        String shortspell = entity.getShortspell();
        if (shortspell != null) {
            stmt.bindString(10, shortspell);
        }

        int clienttype = entity.getClienttype();
        if (clienttype != 0) {
            stmt.bindLong(13, clienttype);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }

    @Override
    public Customer readEntity(Cursor cursor, int offset) {
        Customer entity = new Customer();
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setLguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRebate(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setMobile(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setShortspell(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setClienttype(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Customer entity, int offset) {
        entity.setGuid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setLguid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRebate(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setMobile(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setShortspell(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setClienttype(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
    }

    @Override
    protected final String updateKeyAfterInsert(Customer entity, long rowId) {
        return entity.getGuid();
    }

    @Override
    public String getKey(Customer entity) {
        if (entity != null) {
            return entity.getGuid();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Customer entity) {
        return entity.getGuid() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }


    public ArrayList<Customer> queryNote(String where, String... params){
        return (ArrayList<Customer>)queryRaw(where, params);
    }
}
