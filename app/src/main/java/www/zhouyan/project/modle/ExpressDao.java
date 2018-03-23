package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 * 物流
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

@Entity(nameInDb = "Express")
public class ExpressDao extends AbstractDao<Express, String> {
    public static final String TABLENAME = "Express";

    /**
     * Properties of entity Express.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */

    public static class Properties {
        public final static Property name = new Property(1, String.class, "name", true, "name");
        public final static Property expresstype = new Property(0, int.class, "expresstype", false, "expresstype");
        public final static Property code = new Property(2, String.class, "code", false, "code");
        public final static Property canquery = new Property(3, int.class, "canquery", false, "canquery");
        public final static Property canorder = new Property(4, String.class, "canorder", false, "canorder");
        public final static Property shortspell = new Property(5, String.class, "shortspell", false, "shortspell");
        public final static Property firstletter = new Property(6, String.class, "firstletter", false, "firstletter");
        public final static Property iscommon = new Property(7, String.class, "iscommon", false, "iscommon");
       
    }


    public ExpressDao(DaoConfig config) {
        super(config);
    }

    public ExpressDao(DaoConfig config, DaoSession2 daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"Express\" (" + //
                "\"expresstype\" TEXT," + // 1: expresstype
                "\"name\" TEXT PRIMARY KEY NOT NULL ," + // 0: name
                "\"code\" TEXT," + // 2: code
                "\"canquery\" TEXT," + // 3: canquery
                "\"canorder\" TEXT," + // 4: canorder
                "\"shortspell\" TEXT" + // 5: shortspell
                "\"firstletter\" TEXT" + // 6: firstletter
                "\"iscommon\" TEXT" + // 7: iscommon
                " );");
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"Express\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Express entity) {
        stmt.clearBindings();

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        int expresstype = entity.getExpresstype();
        stmt.bindLong(1, expresstype);


        String code = entity.getCode();
        stmt.bindString(3, code);

        int canquery = entity.getCanquery();
        stmt.bindLong(4, canquery);

        String canorder = entity.getCanorder();
        if (canorder != null) {
            stmt.bindString(5, canorder);
        }

        String shortspell = entity.getShortspell();
        if (shortspell != null) {
            stmt.bindString(6, shortspell);
        }

        String firstletter = entity.getFirstletter();
        if (shortspell != null) {
            stmt.bindString(7, firstletter);
        }
        int iscommon = entity.getIscommon();
        stmt.bindLong(8, iscommon);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Express entity) {
        stmt.clearBindings();

        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        int expresstype = entity.getExpresstype();
        stmt.bindLong(1, expresstype);


        String code = entity.getCode();
        stmt.bindString(3, code);

        int canquery = entity.getCanquery();
        stmt.bindLong(4, canquery);


        String canorder = entity.getCanorder();
        if (canorder != null) {
            stmt.bindString(5, canorder);
        }

        String shortspell = entity.getShortspell();
        if (shortspell != null) {
            stmt.bindString(6, shortspell);
        }

        String firstletter = entity.getFirstletter();
        if (shortspell != null) {
            stmt.bindString(7, firstletter);
        }
        int iscommon = entity.getIscommon();
        stmt.bindLong(8, iscommon);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset +1) ? null : cursor.getString(offset + 1);
    }

    @Override
    public Express readEntity(Cursor cursor, int offset) {
        Express entity = new Express();
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setExpresstype(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCanquery(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setCanorder(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setShortspell(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFirstletter(cursor.isNull(offset + 6) ? null : cursor.getString(offset +6));
        entity.setIscommon(cursor.isNull(offset + 7) ? null : cursor.getInt(offset +7));
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, Express entity, int offset) {
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setExpresstype(cursor.isNull(offset + 0) ? null : cursor.getInt(offset + 0));
        entity.setCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCanquery(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setCanorder(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setShortspell(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setFirstletter(cursor.isNull(offset + 6) ? null : cursor.getString(offset +6));
        entity.setIscommon(cursor.isNull(offset + 7) ? null : cursor.getInt(offset +7));
    }

    @Override
    protected final String updateKeyAfterInsert(Express entity, long rowId) {
        return entity.getName();
    }

    @Override
    public String getKey(Express entity) {
        if (entity != null) {
            return entity.getName();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Express entity) {
        return entity.getName() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }


//    //写出需要的查询语句
//    public ArrayList<Express> getArray(String key){
//        ArrayList<Express> arrayList = new ArrayList<>();
//        SQLiteDatabase db2 = MyApplication.getInstance().getDb2();
//        Cursor cursor =db2.rawQuery("select * from Express where Express.name like \""+key+"\" or Express.shortspell like \""+key+"\"",null);
//        //数据库查询数据
//        if(cursor!=null){
//            while(cursor.moveToNext()) { //循环遍历查找数组
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                String code = cursor.getString(cursor.getColumnIndex("code"));
//                Express express = new Express();
//                express.setName(name);
//                express.setCode(code);
//                arrayList.add(express);
//            }
//        }
//        return arrayList;
//    }
}
