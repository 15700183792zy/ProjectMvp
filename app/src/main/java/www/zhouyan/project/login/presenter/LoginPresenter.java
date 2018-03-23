package www.zhouyan.project.login.presenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Response;
import www.zhouyan.project.R;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.home.view.HomeActivity;
import www.zhouyan.project.login.view.ILoginView;
import www.zhouyan.project.login.view.LoginActivity;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.modle.CompanyConfigs;
import www.zhouyan.project.modle.LoginPost;
import www.zhouyan.project.modle.LoginResponse;
import www.zhouyan.project.retrofit.GlobalResponse;
import www.zhouyan.project.retrofit.HttpResultFuncAll;
import www.zhouyan.project.retrofit.HttpResultFuncDb;
import www.zhouyan.project.retrofit.ProgressSubscriber;
import www.zhouyan.project.retrofit.RetrofitManager;
import www.zhouyan.project.retrofit.SubscriberOnNextListener;
import www.zhouyan.project.utils.ToolDateTime;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.utils.ToolSysEnv;
import www.zhouyan.project.widget.dialog.DialogShow;

/**
 * Created by mac on 18/3/21.
 */

public class LoginPresenter {

    private String TAG = getClass().getSimpleName();
    private BaseActivity activity;
    private String areacodetime;
    private String synctime;
    private int flag = 0;

    ILoginView iLoginView;

    public LoginPresenter(ILoginView mview) {
        this.iLoginView = mview;
    }

    public   void login( final BaseActivity activity, final LoginPost loginPost, int flag) {
        Log.e(TAG, "login: ");
        this.flag = flag;
        areacodetime = ToolFile.getString(loginPost.getUsername() + "areatime", "");
        synctime = ToolFile.getString(loginPost.getUsername() + "synctime", "");
        loginPost.setLogintype(0);
        loginPost.setVersiontype(2);
        loginPost.setVersion(ToolFile.getString(ConstantManager.SP_USER_VERSION));
        loginPost.setMobiletype(Build.MODEL);
        loginPost.setRemark(ToolSysEnv.getBrand());
        this.activity = activity;
        //发起网络请求 调用登录 接口
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                        Login(loginPost)
                        .map(new HttpResultFuncAll<GlobalResponse<LoginResponse>>()),
                new ProgressSubscriber<GlobalResponse<GlobalResponse<LoginResponse>>>(new SubscriberOnNextListener<GlobalResponse<LoginResponse>>() {
                    @Override
                    public void onNext(final GlobalResponse<LoginResponse> response) {
                        if (response.code == 0) {
                            //
                            String phone = ToolFile.getString(ConstantManager.SP_USER_PSW);
                            // 不同用户清空数据
                            if (!phone.equals(response.data.getMobile())) {
                                ToolFile.putString(phone + "XS", ""); //清空 销售单
                                ToolFile.putString(phone + "RK", "");//清空 入库
                                ToolFile.putString(phone + "PD", "");//清空 盘点
                                ToolFile.putString(phone + "DC", "");//清空 调拨调出
                            }

                            ToolFile.putString(ConstantManager.SP_USER_PSW, loginPost.getPwd());
                            ToolFile.putString(ConstantManager.SP_USER_NAME, response.data.getMobile());

                            write(response.data, response.data.getMobile());
                        } else if (response.code != 0) {
                            if (response.code == 7) {
                                ToolFile.putString(ConstantManager.SP_USER_NAME, loginPost.getUsername());
                                ToolFile.putString(ConstantManager.SP_USER_PSW, "");
                                ToolFile.putString(loginPost.getUsername() + "flag", 0 + "");
                                ToolFile.putString(loginPost.getUsername() + "logintime", ToolDateTime.getdateTime());
                            }
                            if (response.code == ConstantManager.SUCCESS_REQUEST4 || response.code == ConstantManager.SUCCESS_REQUEST3) {
                                ToolFile.putString(ConstantManager.SP_USER_PSW, "");
                                ToolFile.putString(loginPost.getUsername() + "flag", 0 + "");
                                ToolFile.putString(loginPost.getUsername() + "logintime", ToolDateTime.getdateTime());
                            }
                            if(activity!=null) {
                                // 设置封面
                                DialogShow mDialogShow = new DialogShow(
                                        activity);
                                mDialogShow.setCanceledOnTouchOutside(true);
                                mDialogShow.setTitleText(response.message + "(" + response.code + ")")
                                        .setCancerClickListener(new DialogShow.OnCustomDialogClickListener() {
                                            @Override
                                            public void onClick(DialogShow customDialog) {
                                                customDialog.dismiss();
                                                if (activity instanceof LoginActivity) {

                                                } else {
                                                    ToolFile.putString(loginPost.getUsername() + "flag", 0 + "");
                                                    ToolFile.putString(loginPost.getUsername() + "logintime", ToolDateTime.getdateTime());

                                                    LoginActivity.show(activity);
                                                    activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
                                                    activity.finish();
                                                }
                                            }
                                        });
                                mDialogShow.show();
                            }
                        }
                    }
                }, activity, 0));
    }


    SQLiteDatabase db = null;

    public void write(LoginResponse loginResponse, String mobile) {

        MyApplication.getInstance().setName(mobile);
        ToolFile.putString(ConstantManager.SP_USER_URL, "1");

        ToolFile.putString(mobile + "api", loginResponse.getApihost() + "");
        ToolFile.putString(mobile + "authorization", loginResponse.getMac());
        RetrofitManager.getInstance().authorization = loginResponse.getMac();
        ToolFile.putString(mobile + "flag", 1 + "");
        //sguid
        ToolFile.putString(mobile + "sguid", loginResponse.getSguid());
        //name
        ToolFile.putString(mobile + "sname", loginResponse.getSname());

        CrashReport.setUserId(mobile); // 用户 ID

        ToolFile.putString(mobile + "cid", loginResponse.getCid());
        //sguid
        ToolFile.putString(mobile + "cname", loginResponse.getCname());
        //name
        ToolFile.putString(mobile + "uname", loginResponse.getUname());

        //cguid
        ToolFile.putString(mobile + "cguid", loginResponse.getCguid());

        //clientId 个推
        if (loginResponse.getClientid() != null)
            ToolFile.putString(mobile + "clientid", loginResponse.getClientid());
        //rolestring
        if (loginResponse.getRolestring() != null)
            ToolFile.putString(mobile + "rolestring", loginResponse.getRolestring().toString());
        else {//表示没有权限
            ToolFile.putString(mobile + "rolestring", "1");
        }
//        ToolFile.putString(mobile + "printremark", loginResponse.getPrintremark());
        for (CompanyConfigs companyConfigList : loginResponse.getConfigs()) {
            if (companyConfigList.getConfigid() == 3) {
                //产品维护级别
                if (companyConfigList.getValue() != null && !companyConfigList.getValue().equals("")) {
                    ToolFile.putString(mobile + "configvalue", companyConfigList.getValue() + "");
                } else {
                    ToolFile.putString(mobile + "configvalue", "货号级");

                }
            } else if (companyConfigList.getConfigid() == 2) {
                if (companyConfigList.getValue() != null && !companyConfigList.getValue().equals("")) {
                    ToolFile.putString(mobile + "print", companyConfigList.getValue() + "");
                } else {
                    ToolFile.putString(mobile + "print", "1");
                }
            } else if (companyConfigList.getConfigid() == 6) {//立即打印回款单
                //产品维护级别
                if (companyConfigList.getValue() != null && !companyConfigList.getValue().equals("")) {
                    ToolFile.putString(mobile + "customer", companyConfigList.getValue() + "");
                } else {
                    ToolFile.putString(mobile + "customer", "0");
                }
            } else if (companyConfigList.getConfigid() == 7) {//立即打印打款单
                if (companyConfigList.getValue() != null && !companyConfigList.getValue().equals("")) {
                    ToolFile.putString(mobile + "supplier", companyConfigList.getValue() + "");
                } else {
                    ToolFile.putString(mobile + "supplier", "0");
                }
            } else if (companyConfigList.getConfigid() == 8) {//立即打印打款单
                if (companyConfigList.getValue() != null && !companyConfigList.getValue().equals("")) {
                    ToolFile.putString(mobile + "balance", companyConfigList.getValue() + "");
                } else {
                    ToolFile.putString(mobile + "balance", "0");
                }
            }
        }

        //保存 areacodetime
        if (areacodetime == null || areacodetime.equals("")) {
            areacodetime = loginResponse.getAreacodetime();
            ToolFile.putString(mobile + "areatime", areacodetime);
        }

        if (synctime == null || synctime.equals("")) {
            synctime = loginResponse.getServicetime();
            ToolFile.putString(mobile + "synctime", synctime);
        }

        if (ToolFile.getString(mobile + "logintime").trim().equals("")) {
            //登录时间
            ToolFile.putString(mobile + "logintime", ToolDateTime.getdateTime());

        }

        if (db == null || !db.isOpen())
            db = MyApplication.getInstance().getGreenDaoManagerAreaCode().getWritableDatabase();
        //同步数据库
        Cursor cursor = db.rawQuery("select count(*) as num from sqlite_master where  name ='AreaCode'", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) { //循环遍历查找数组
                String string = cursor.getString(cursor.getColumnIndex("num"));
                int index = Integer.parseInt(string.trim());
//            Log.e("-----------string", string);
                if (index == 0) {
                    down();
                } else {
                    handler.sendEmptyMessage(2);
                }
            }

            cursor.close();
            cursor = null;
        }
    }

    private void down() {
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                        InitAreaCode().map(new HttpResultFuncDb<ResponseBody>()),
                new ProgressSubscriber<Response<ResponseBody>>(
                        new SubscriberOnNextListener<Response<ResponseBody>>() {
                            @Override
                            public void onNext(final Response<ResponseBody> response) {
                                if (response != null && response.body() != null) {
                                    ((BaseActivity) activity).cachedThreadPool.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                InputStream body = response.body().byteStream();
                                                saveFile(body);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }


                                        }
                                    });
                                }
                            }
                        }, activity, 0));
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(android.os.Message msg) {
            switch (msg.what) {

                case 2:
                    if (iLoginView != null) {
                        iLoginView.toMainAct();
                    } else if (activity != null) {
                        HomeActivity.show(activity);
                        activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
                        activity.finish();
                    }else{

                    }
                    break;

                case 3:
                    Log.e("--------", "数据库下载成功");
                    break;
            }
            return true;
        }
    });


    public void saveFile(InputStream is) {
        String save = activity.getFilesDir().getAbsolutePath() + "/ls";
        FileOutputStream fos = null;
        try {
            File file = new File(save);
            if (!file.exists()) file.mkdirs();

            fos = new FileOutputStream(file.getAbsoluteFile() + "/sykj.db");
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (fos != null)
                    fos.close();

                if (flag == 0)
                    handler.sendEmptyMessage(2);
                else handler.sendEmptyMessage(3);

            } catch (Exception ex) {

            }
        }

    }
}
