package www.zhouyan.project.login;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import www.zhouyan.project.R;
import www.zhouyan.project.exception.CaptureCrashException;
import www.zhouyan.project.login.view.LoginActivity;
import www.zhouyan.project.utils.MyLogger;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.glide.GlideManager;
import www.zhouyan.project.manager.ConstantManager;

/**
 * Created by mac on 18/3/21.
 */

public class LauncherActivity extends BaseActivity{

    @BindView(R.id.iv_show)
    ImageView ivShow;

    @Override
    public int bindLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    public void doBusiness() {

    }

    private Handler handler = new Handler();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
//        toolLogin = null;

    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {


        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        GlideManager.setNormalImageLancher(R.drawable.lanucher_first, ivShow);


        //设置数据源
        getVersionName();


        // 开启线程, 进行初始化操作
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                // 初始化CaptureCrashException
                CaptureCrashException.getInstance().init(MyApplication.getMyApplication());
                MyLogger.systemlLog().i("初始化完成");
                //  CameraManager.init(getApplication());
                initCacheDirectory();
            }
        });


        //当计时结束时，跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //检查版本信息
                upLogin();
            }
        }, 2000);
    }


    private static String getVersionName() {
        PackageManager manager = MyApplication.getMyApplication().getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(MyApplication.getMyApplication().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TAG", "获取应用程序版本失败, 原因: " + e.getMessage());
        }
        String version =/*"v"+ */info.versionName/*+"."+info.versionCode*/;
        ToolFile.putString(ConstantManager.SP_USER_VERSION, version);
        return version;
    }

    private void initCacheDirectory() {
        File path = new File(ConstantManager.path);
        if (!path.isDirectory() || !path.exists()) {
            path.mkdir();
        }
        File cachePath = new File(ConstantManager.cachePath);
        if (!cachePath.isDirectory() || !cachePath.exists()) {
            cachePath.mkdir();
        }
        File downloadPath = new File(ConstantManager.downloadPath);
        if (!downloadPath.isDirectory() || !downloadPath.exists()) {
            downloadPath.mkdir();
        }
        File logPath = new File(ConstantManager.logPath);
        if (!logPath.isDirectory() || !logPath.exists()) {
            logPath.mkdir();
        }
        File cameraPath = new File(ConstantManager.cameraPath);
        if (!cameraPath.isDirectory() || !cameraPath.exists()) {
            cameraPath.mkdir();
        }

        File datapath = new File(ConstantManager.dataPath);
        if (!datapath.isDirectory() || !datapath.exists()) {
            datapath.mkdir();
        }
        String save = getFilesDir().getAbsolutePath() + "/ls";
        File file = new File(save);
        if (!file.exists()) file.mkdirs();

        String str= getFilesDir().getAbsolutePath()+"/sykj.db";
        File filestr = new File(str);
        if(filestr.exists()) filestr.delete();

        String journal= getFilesDir().getAbsolutePath()+"/sykj.db-journal";
        File filejournal= new File(journal);
        if(filejournal.exists()) filejournal.delete();
    }

    private String mobile;
//    private ToolLogin toolLogin;

    private void upLogin() {
        LoginActivity.show(this);
        finish();
//        mobile = ToolFile.getString(ConstantManager.SP_USER_NAME);
//        String flag = ToolFile.getString(mobile + "flag");
//        toolLogin = new ToolLogin(this, mobile, 0);
//        if (flag.equals("1")) {
//            //访问登录接口并跳入主界面
//            if (mobile.trim().substring(0, 1).equals("2")) {//测试账号
//                //    MyApplication.getInstance().dialogShow(this,"你输入的电话号码格式不正确");
//
//                ToolFile.putString(mobile + "flag", 0 + "");
//                Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            } else {
//                LoginPost loginPost = new LoginPost(mobile, ToolFile.getString(ConstantManager.SP_USER_PSW));
//                String mac = ToolFile.getString(mobile + "authorization");
//                loginPost.setMac(mac);
//                toolLogin.jump(loginPost, 0);
//            }
//        } else {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }


    @Override
    public void resume() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void destroy() {
    }


//    @Override
//    public boolean isNeedRefreshBroadcast() {
//        return false;
//    }
}
