package www.zhouyan.project.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import www.zhouyan.project.modle.CompanyConfigsDao;
import www.zhouyan.project.modle.CustomerDao;
import www.zhouyan.project.modle.ExpressDao;
import www.zhouyan.project.modle.GoodsinfoDao;
import www.zhouyan.project.modle.OrderListTableDao;
import www.zhouyan.project.modle.PayDao;
import www.zhouyan.project.modle.PicDictSaveDao;
import www.zhouyan.project.modle.ProColorsDao;
import www.zhouyan.project.modle.ProSizesDao;
import www.zhouyan.project.modle.ShopDao;
import www.zhouyan.project.modle.SkuDao;
import www.zhouyan.project.modle.dao.DaoMaster2;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/12 17:35
 * 修改人: zhouyan
 * 修改时间: 2017/6/12 17:35
 * 修改备注:
 */

public class MyDaoMasterOpenHelper extends DaoMaster2.OpenHelper {
    public MyDaoMasterOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MyDaoMasterOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {

    }
    /*
    *CompanyConfigsDao.createTable(db, ifNotExists); //配置
        GoodsinfoDao.createTable(db, ifNotExists); //商品
        ShopDao.createTable(db, ifNotExists);//门店
        CustomerDao.createTable(db, ifNotExists);//客户
        PayDao.createTable(db, ifNotExists);//门店账户
        OrderListTableDao.createTable(db, ifNotExists);//单据列表
        SkuDao.createTable(db, ifNotExists);//商品sku
        PicDictSaveDao.createTable(db, ifNotExists);//字典
        ProColorsDao.createTable(db, ifNotExists);//颜色
        ProSizesDao.createTable(db,ifNotExists);//尺码
     */


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("lxq", "oldVersion:" + oldVersion + ",newVersion" + newVersion);
        MigrationHelper.getInstance().migrate(db, CustomerDao.class, ProColorsDao.class,
                ProSizesDao.class, CompanyConfigsDao.class, GoodsinfoDao.class, ShopDao.class,
                PayDao.class, OrderListTableDao.class,
                SkuDao.class, PicDictSaveDao.class, ExpressDao.class);
    }
}
