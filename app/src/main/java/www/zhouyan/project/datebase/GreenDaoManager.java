package www.zhouyan.project.datebase;

import android.database.sqlite.SQLiteDatabase;

import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.modle.dao.DaoMaster2;
import www.zhouyan.project.modle.dao.DaoSession2;

/**
 * Created by mac on 17/12/8.
 */

public class GreenDaoManager {
    private DaoMaster2 mDaoMaster;
    private DaoSession2 mDaoSession;
    public /*static*/ GreenDaoManager mInstance; //单例
    private SQLiteDatabase writableDatabase;

    public GreenDaoManager() {
        String name = ToolFile.getString(ConstantManager.SP_USER_NAME);
        MyDaoMasterOpenHelper devOpenHelper = new
                MyDaoMasterOpenHelper(new GreenDaoContext(),"ls/"+name + "sykj2.db", null);//此处为自己需要处理的表
        writableDatabase = devOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster2(writableDatabase);
        mDaoSession = mDaoMaster.newSession();
    }


    public /*static*/ GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {//保证异步处理安全操作
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }


    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }

    public DaoMaster2 getMaster() {
        return mDaoMaster;
    }

    public DaoSession2 getSession() {
        return mDaoSession;
    }

    public DaoSession2 getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
