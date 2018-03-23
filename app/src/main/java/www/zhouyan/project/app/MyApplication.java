package www.zhouyan.project.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.text.TextUtils;

import com.igexin.sdk.PushManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.sharesdk.framework.ShareSDK;
import www.zhouyan.project.datebase.GreenDaoManager;
import www.zhouyan.project.datebase.GreenDaoManagerAreaCode;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.modle.daoarea.DaoSession;
import www.zhouyan.project.modle.dao.DaoSession2;
import www.zhouyan.project.service.DemoIntentService;
import www.zhouyan.project.service.DemoPushService;
import www.zhouyan.project.utils.SPUtils;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.wxapi.Constants;

/**
 * Created by mac on 18/3/21.
 */

public class MyApplication extends Application {
    /**
     * 是否离线 false 否，true离线
     */

    private boolean isOffline = false;

    public boolean isOffline() {
        return isOffline;
    }

    public void setOffline(boolean offline) {
        isOffline = offline;
    }


    //得到全局的api
    public String getAPI2() {
        return ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "api");
    }

    /**
     * 对外提供整个应用生命周期的Context
     **/
    private static Context context;
    /**
     * 对外提供整个应用生命周期的MyApplication
     **/
    private static MyApplication instance;

    /**
     * 整个应用全局可访问数据集合
     **/
    private static Map<String, Object> gloableData = new HashMap<String, Object>();
    /***
     * 寄存整个应用Activity
     **/
    private final Stack<WeakReference<Activity>> activitys = new Stack<WeakReference<Activity>>();

    /**
     * 对外提供Application Context
     *
     * @return
     */

    public static Context getMyApplication() {
        return context;
    }

    /**
     * 对外提供Application对象
     *
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }

    public ExecutorService cachedThreadPool;


//    public RefWatcher watcher;

    @Override
    public void onCreate() {

        // 发送异常信息到服务器
        cachedThreadPool = Executors.newFixedThreadPool(5);//LinkedBlockingQueue: 无界的队列

        PushManager.getInstance().initialize(getApplicationContext(), DemoPushService.class);

        SPUtils.putString(getApplicationContext(), "cid", PushManager.getInstance().getClientid(getApplicationContext()));

        PushManager.getInstance().registerPushIntentService(getApplicationContext(), DemoIntentService.class);

        ShareSDK.initSDK(this);


        //bugly 手动上报
//        initBuly();

        context = this;
        instance = this;

        //setDatabase();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
        super.onCreate();

        WX();
    }


    private void WX() {
        //创建微信api并注册到微信
        Constants.wx_api = WXAPIFactory.createWXAPI(instance, Constants.APP_ID, true);
//        Constants.wx_api.registerApp(Constants.APP_ID);
    }


    //bugly 初始化 bugly     appid    5d2c110ccf
    public void initBuly() {
        /***** Bugly高级设置 *****/
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        /**
         * 设置app渠道号
         */
        strategy.setAppChannel(ConstantManager.isDebug? "正式" :
                ConstantManager.API.trim().equals("https://g2api.4yankj.cn/")?"测试":"开发");
        // 获取当前包名
        String packageName = getPackageName();
        // 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());

        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        //第三个参数在测试阶段最好设置为true
        CrashReport.initCrashReport(getApplicationContext(), "5d2c110ccf", true, strategy);
    }


    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }




    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    public void pushTask(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除
     *
     * @param task
     */
    public void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */
    public void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex)
            activitys.remove(taskIndex);
    }

    //得到倒数第二个
    public Activity getActivityTop2() {
        int end = activitys.size();
        if (end >=2) {
            return activitys.get(end - 2).get();
        } else return null;
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    public void removeToTop() {
        int end = activitys.size();
        if(end>1) {
            int start = 1;
            for (int i = end - 1; i >= start; i--) {
                if (!activitys.get(i).get().isFinishing()) {
                    activitys.get(i).get().finish();
                    activitys.remove(i);
                }
            }
        }
    }


    //得到倒数第-个
    public Activity activityTop() {
        int end = activitys.size();
        if(end!=0){
            return activitys.get(end - 1).get();
        }else return activitys.get(0).get();

    }

    /**
     * 将栈中Activity移除倒数第二个
     */
    public void removeTop2() {
        int end = activitys.size();
        if(end!=2) {
            if (!activitys.get(end - 2).get().isFinishing()) {
                activitys.get(end - 2).get().finish();
                activitys.remove(end - 2);
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    public void removeAll() {
        //finish所有的Activity
        for (WeakReference<Activity> task : activitys) {
            if (task == null) continue;
            if (task.get() == null) continue;
            if (!task.get().isFinishing()) {
                task.get().finish();
            }
        }
        //杀死该应用进程
        activitys.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    /**
     * 数据库问题
     */

    public GreenDaoManagerAreaCode greenDaoManagerAreaCode;
    public GreenDaoManager greenDaoManager;
    public GreenDaoManagerAreaCode getGreenDaoManagerAreaCode() {
        if (greenDaoManagerAreaCode == null)
            greenDaoManagerAreaCode = GreenDaoManagerAreaCode.getInstance();
        return greenDaoManagerAreaCode;
    }



    String name= "";
    public void setName(String name) {
        this.name = name;

    }

    public GreenDaoManager getGreenDaoManager() {

        greenDaoManager = new GreenDaoManager();
//        Log.e("--------",name+"==="+greenDaoManager.toString());
        return greenDaoManager;
    }

    public DaoSession getDaoSession() {
        getGreenDaoManagerAreaCode().getSession().clear();
        return getGreenDaoManagerAreaCode().getSession();
    }

    public DaoSession2 getDaoSession2() {
        getGreenDaoManager().getSession().clear();
        return getGreenDaoManager().getSession();
    }

    public SQLiteDatabase getDb2() {
        return getGreenDaoManager().getWritableDatabase();
    }

    public void deldatebase() {
        //删除数据库
        if (greenDaoManagerAreaCode != null)
            greenDaoManagerAreaCode.getSession().clear();
        if (greenDaoManager != null) {
            greenDaoManager.getSession().clear();
        }


        instance.greenDaoManager = null;
        instance.greenDaoManagerAreaCode = null;


        //清理缓存数据
        File file = new File(ConstantManager.path);
        ToolFile.deleteFileOrDir(file);
    }

}
