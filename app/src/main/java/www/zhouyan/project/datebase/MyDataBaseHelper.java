package www.zhouyan.project.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import www.zhouyan.project.modle.daoarea.AreaCodeDao;
import www.zhouyan.project.modle.daoarea.DaoMaster;

/**
 * Created by zhouyan on 2017/4/17.
 */

public class MyDataBaseHelper extends DaoMaster.OpenHelper {


    public MyDataBaseHelper(Context context, String name) {
        super(context, name);
    }

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {

    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("lxq","oldVersion:"+oldVersion+",newVersion"+newVersion);
        MigrationAreaCodeHelper.getInstance().migrate(db,AreaCodeDao.class);
    }

}
