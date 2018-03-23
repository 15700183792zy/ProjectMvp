package www.zhouyan.project.home.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;

import java.io.File;
import java.util.List;

import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.home.view.HomeActivity;
import www.zhouyan.project.login.presenter.LoginPresenter;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.modle.LoginPost;
import www.zhouyan.project.modle.OrderListTable;
import www.zhouyan.project.modle.OrderListTableDao;
import www.zhouyan.project.modle.UpdateResponse;
import www.zhouyan.project.modle.dao.DaoSession2;
import www.zhouyan.project.retrofit.GlobalResponse;
import www.zhouyan.project.retrofit.HttpResultFuncAll;
import www.zhouyan.project.retrofit.ProgressSubscriber;
import www.zhouyan.project.retrofit.RetrofitManager;
import www.zhouyan.project.retrofit.SubscriberOnNextListener;
import www.zhouyan.project.service.DownloadService;
import www.zhouyan.project.utils.ToolDateTime;
import www.zhouyan.project.utils.ToolFile;

/**
 * Created by mac on 18/3/22.
 */

public class HomeActPresenter {

    HomeActivity homeActView;
    String api2 = "";

    public HomeActPresenter(HomeActivity homeActView) {
        this.homeActView = homeActView;
        api2 = MyApplication.getInstance().getAPI2();
    }


    public void checkClientId(String mobile, String clientid) {
        String string = ToolFile.getString(mobile + "clientid");
        //判断接收个推clientid与登录拿到的cliendId的是否一致，不一致更新接口
        if (!string.trim().equals(clientid.trim())) {
            //保存个推信息
            RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                            UpDateGTClientID(mobile, clientid)
                            .map(new HttpResultFuncAll<GlobalResponse>()),
                    new ProgressSubscriber<GlobalResponse<GlobalResponse>>(new SubscriberOnNextListener<GlobalResponse>() {
                        @Override
                        public void onNext(final GlobalResponse response) {
//                            Log.e("-------------绑定个推的数据", response.code + "=======" + response.message);
                            if (response.code != 0) {//不绑定个推出错
                                homeActView.showDialogs(response.code, response.message);
                            }
                        }
                    }, null, 1));

        }

    }

    public void checkVersion(final String mobile) {
        //检查版本
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                        VersionVertify(2 + "", ToolFile.getString(ConstantManager.SP_USER_VERSION))
                        .map(new HttpResultFuncAll<GlobalResponse<UpdateResponse>>()),
                new ProgressSubscriber<GlobalResponse<GlobalResponse<UpdateResponse>>>(new SubscriberOnNextListener<GlobalResponse<UpdateResponse>>() {
                    @Override
                    public void onNext(final GlobalResponse<UpdateResponse> response) {
                        if (response.code == 0) {

                            String later = ToolFile.getString(mobile + "version").trim();
                            String flag = ToolFile.getString(mobile + "versionflag").trim();
//                            Log.e("----------", ToolGson.toJson(response.data)+"===="+later+"==="+flag);
                            //测试
//                            flag="0";
                            if (response.data == null) {

                            } else if (later.equals(response.data.getLastver().trim()) && flag.trim().equals("1")) {

                            } else if (response.data.getType() != 1) {
                                showUpdateDialog( response.data, mobile);
                            }
                        } else {
                            // 设置封面
                            homeActView.showDialogs(response.code, response.message);
                        }
                    }
                }, homeActView, 0));
    }


    /**
     * 弹出更新对话框
     */
    public void showUpdateDialog(final UpdateResponse info, final String mobile) {
        AlertDialog.Builder builder = new AlertDialog.Builder(homeActView);
//        final int strategy = info.getType();
        builder.setTitle("发现新版本, 请及时更新");
        // builder.setMessage((info.getRemark()==null|| info.getRemark().equals(""))?"有更新功能":info.getRemark());
        builder.setPositiveButton("马上安装", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (info.getType() == 2) {
                    ProgressDialog progressDialog = new ProgressDialog(homeActView);
                    progressDialog.setMessage("正在下载安装包, 请稍后...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
                if (mDownloadBinder != null)
                    mDownloadBinder.startDownload(info.getUrl());
                dialog.dismiss();
                homeActView.finish();
            }
        });
        if (info.getType() == 2) {
            builder.setNegativeButton("退出程序", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    homeActView.finish();
                }
            });
        } else {
            //下次再说在这个版本一直不显示, 新版本在显示

            builder.setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ToolFile.putString(mobile + "version", info.getLastver());
                    ToolFile.putString(mobile + "versionflag", "1");
                    dialog.dismiss();
                }
            });
        }

        builder.setCancelable(false);
        builder.show();
    }


    public void downsql() {

    }

    public void resume(String mobile) {
        String getdate = ToolDateTime.getdateTime();
        String logintime = ToolFile.getString(mobile + "logintime").trim();
        int hours = ToolDateTime.getTimeDifference(logintime, getdate);
        if (hours >= 1) {
            //清空 销售单
            ToolFile.putString(mobile + "XS", "");//清空 销售单
            ToolFile.putString(mobile + "RK", "");//清空 入库
            ToolFile.putString(mobile + "PD", "");//清空 盘点
            ToolFile.putString(mobile + "DC", "");//清空 调拨调出
        }
        //  Log.e("-------",hours+"你");
        if (hours >= 12) {

            //（网络）清理缓存数据
            File file = new File(ConstantManager.cachePath);
            ToolFile.deleteFileOrDir(file);

            // 调用登录
            ToolFile.putString(mobile + "logintime", ToolDateTime.getdateTime());

            toLogin(mobile);

        }
    }

    public void toLogin(String mobile) {
        LoginPresenter loginPresenter = new LoginPresenter(null);
        LoginPost loginPost = new LoginPost(mobile, ToolFile.getString(ConstantManager.SP_USER_PSW));
        loginPresenter.login(homeActView, loginPost, 1);
    }


    private SQLiteDatabase db;

    public void upload() {//上传数据
        if (db == null || !db.isOpen())
            db = MyApplication.getInstance().getGreenDaoManager().getWritableDatabase();
        //同步数据库
        Cursor cursor = db.rawQuery("select count(*) as num from sqlite_master where  name ='synctime'", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) { //循环遍历查找数组
                String string = cursor.getString(cursor.getColumnIndex("num"));
                int index = Integer.parseInt(string.trim());
                if (index == 1) {
                    //离线上传
                    upload2();
                }
            }

            cursor.close();
        }


    }

    private void upload2() {
        final DaoSession2 daoSession2 = MyApplication.getInstance().getDaoSession2();
        final OrderListTableDao orderListTableDao = daoSession2.getOrderListTableDao();
        List<OrderListTable> list = orderListTableDao.queryBuilder().list();

        if (list.size() != 0) {
            //上传代码 在下载数据库
            ProgressSubscriber<GlobalResponse<GlobalResponse>> progreUpdate = new ProgressSubscriber<>(new SubscriberOnNextListener<GlobalResponse>() {
                @Override
                public void onNext(final GlobalResponse response) {
                    if (response.code == 0) {
                        //删除所有数据
                        orderListTableDao.deleteAll();
                    } else {
                        homeActView.showDialogs(response.code, response.message);
                    }
                }
            }, null, 1);
            RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService(api2).
                            OrderSaveBatch(list)
                            .map(new HttpResultFuncAll<GlobalResponse>()),
                    progreUpdate);
        }
    }


    public void service() {
        //注册下载服务
        Intent intent = new Intent(homeActView, DownloadService.class);
        homeActView.startService(intent);
        homeActView.bindService(intent, mConnection, homeActView.BIND_AUTO_CREATE);//绑定服务
    }


    private DownloadService.DownloadBinder mDownloadBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            mDownloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mDownloadBinder = null;
        }
    };

    public void ondestory(){
        if(homeActView!=null && mConnection!=null)
        homeActView.unbindService(mConnection);
    }
}
