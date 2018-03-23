package www.zhouyan.project.datebase;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/12 17:26
 * 修改人: zhouyan
 * 修改时间: 2017/6/12 17:26
 * 修改备注:
 */


import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import www.zhouyan.project.app.MyApplication;

/**
 * Created by zhouyan on 2017/4/27.
 */

public class GreenDaoAreacodeContext extends ContextWrapper {

    private String currentUserId = "greendaoAreacode";//一般用来针对一个用户一个数据库, 以免数据混乱问题
    private Context mContext;

    public GreenDaoAreacodeContext() {
        super(MyApplication.getInstance());
        this.mContext = MyApplication.getInstance();
//        this.currentUserId = "greendao";//初始化
    }

    /**
     * 获得数据库路径, 如果不存在, 则创建对象
     *
     * @param dbName
     */
    @Override
    public File getDatabasePath(String dbName) {
        String dbDir = mContext.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(dbDir)) {
            Log.e("SD卡管理: ", "SD卡不存在, 请加载SD卡");
            return null;
        }
        File baseFile = new File(dbDir);
        // 目录不存在则自动创建目录
        if (!baseFile.exists()) {
            baseFile.mkdirs();
        }
        File dbFile = new File(mContext.getFilesDir().getAbsolutePath() + "/" + dbName);
        if (dbFile.exists()) {
            return dbFile;
        } else {
            try {
                dbFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbFile;
    }

    /**
     * 重载这个方法, 是用来打开SD卡上的数据库的, android 2.3及以下会调用这个方法。
     *
     * @param name
     * @param mode
     * @param factory
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
        return result;
    }

    /**
     * Android 4.0会调用此方法获取数据库。
     *
     * @param name
     * @param mode
     * @param factory
     * @param errorHandler
     * @see ContextWrapper#openOrCreateDatabase(String, int,
     * SQLiteDatabase.CursorFactory,
     * DatabaseErrorHandler)
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);

        return result;
    }
}
