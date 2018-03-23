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

@Entity(nameInDb = "orderlist")
public class OrderListTableDao extends AbstractDao<OrderListTable, Long> {
    public static final String TABLENAME = "orderlist";

    /**
     * Properties of entity orderlist.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property orderno = new Property(0, String.class, "orderno", false, "orderno");
        public final static Property clientname = new Property(1, String.class, "clientname", false, "clientname");
        public final static Property totalquantity = new Property(2, int.class, "totalquantity", false, "totalquantity");
        public final static Property actamount = new Property(3, double.class, "actamount", false, "actamount");
        public final static Property orderjson = new Property(4, String.class, "orderjson", false, "orderjson");
        public final static Property state = new Property(5, int.class, "state", false, "state");
        public final static Property ordertime = new Property(6, String.class, "ordertime", false, "ordertime");
        public final static Property sname = new Property(7, String.class, "sname", false, "sname");
        public final static Property id = new Property(8, Long.class, "id", true, "id");

    }


    public OrderListTableDao(DaoConfig config) {
        super(config);
    }

    public OrderListTableDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"orderlist\" (" + //
                "\"orderno\" TEXT  ," + // 0: orderno
                "\"clientname\" TEXT," + // 1: clientname
                "\"totalquantity\" int," + // 2: totalquantity
                "\"actamount\" double," + // 3: actamount
                "\"orderjson\" TEXT" + // 4: orderjson
                "\"state\" int" + // 5: state
                "\"ordertime\" TEXT" + // 6: ordertime
                "\"sname\" TEXT" + // 7: sname
                "\"id\" integer PRIMARY KEY autoincrement NOT NULL ," + // 0: id
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"orderlist\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, OrderListTable entity) {
        stmt.clearBindings();

        String orderno = entity.getOrderno();
        if (orderno != null) {
            stmt.bindString(1, orderno);
        }

        String clientname = entity.getClientname();
        if (clientname != null) {
            stmt.bindString(2, clientname);
        }

        int totalquantity = entity.getTotalquantity();
        stmt.bindLong(3, totalquantity);

        double actamount = entity.getActamount();
        stmt.bindDouble(4, actamount);


        String orderjson = entity.getOrderjson();
        if (orderjson != null) {
            stmt.bindString(5, orderjson);
        }


        int state = entity.getState();
        stmt.bindLong(6, state);
        String ordertime = entity.getOrdertime();
        if (ordertime != null) {
            stmt.bindString(7, ordertime);
        }

        String sname = entity.getSname();
        if (sname != null) {
            stmt.bindString(8, sname);
        }
//        Long id = entity.getId();
//        stmt.bindLong(9, id);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, OrderListTable entity) {
        stmt.clearBindings();

        String orderno = entity.getOrderno();
        if (orderno != null) {
            stmt.bindString(1, orderno);
        }

        String clientname = entity.getClientname();
        if (clientname != null) {
            stmt.bindString(2, clientname);
        }

        int totalquantity = entity.getTotalquantity();
        stmt.bindLong(3, totalquantity);

        double actamount = entity.getActamount();
        stmt.bindDouble(4, actamount);


        String orderjson = entity.getOrderjson();
        if (orderjson != null) {
            stmt.bindString(5, orderjson);
        }
        int state = entity.getState();
        stmt.bindLong(6, state);
        String ordertime = entity.getOrdertime();
        if (ordertime != null) {
            stmt.bindString(7, ordertime);
        }

        String sname = entity.getSname();
        if (sname != null) {
            stmt.bindString(8, sname);
        }


//        Long id = entity.getId();
//        stmt.bindLong(9, id);
    }


    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    public OrderListTable readEntity(Cursor cursor, int offset) {
        OrderListTable entity = new OrderListTable();
        entity.setOrderno(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setClientname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTotalquantity(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setActamount(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setOrderjson(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setState(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setOrdertime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSname(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, OrderListTable entity, int offset) {
        entity.setOrderno(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setClientname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTotalquantity(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setActamount(cursor.isNull(offset + 3) ? null : cursor.getDouble(offset + 3));
        entity.setOrderjson(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setState(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setOrdertime(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSname(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
    }


    @Override
    protected final Long updateKeyAfterInsert(OrderListTable entity, long rowId) {
        return entity.getId();
    }

    @Override
    public Long getKey(OrderListTable entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return 0L;
        }
    }

    @Override
    public boolean hasKey(OrderListTable entity) {
        return entity.getId() != 0;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}