package www.zhouyan.project.datebase;

import android.database.sqlite.SQLiteDatabase;

import www.zhouyan.project.modle.daoarea.DaoMaster;
import www.zhouyan.project.modle.daoarea.DaoSession;

/**
 * Created by mac on 17/12/8.
 */

public class GreenDaoManagerAreaCode {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManagerAreaCode mInstance; //单例
    private SQLiteDatabase writableDatabase;
    private GreenDaoManagerAreaCode(){
        MyDataBaseHelper devOpenHelper = new
                MyDataBaseHelper(new GreenDaoAreacodeContext(), "ls/sykj.db", null);//此处为自己需要处理的表
        writableDatabase = devOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(writableDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManagerAreaCode getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManagerAreaCode.class) {//保证异步处理安全操作

                if (mInstance == null) {
                    mInstance = new GreenDaoManagerAreaCode();
                }
            }
        }
        return mInstance;
    }

    public SQLiteDatabase getWritableDatabase() {
        return writableDatabase;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }
    public DaoSession getSession() {
        return mDaoSession;
    }
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
