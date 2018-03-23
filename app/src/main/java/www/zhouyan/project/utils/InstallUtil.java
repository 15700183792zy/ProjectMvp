package www.zhouyan.project.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.widget.Toast;

import java.io.File;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * If there is no bug, then it is created by ChenFengYao on 2017/4/19,
 * otherwise, I do not know who create it either.
 */
public class InstallUtil {
    /**
     * @param context
     * @param apkPath  要安装的APK
     * @param rootMode 是否是Root模式
     */
    public static void install(Context context, String apkPath, boolean rootMode) {
//        Log.d("SystemManager", rootMode + "");
        if (rootMode) {
            installRoot(context, apkPath);
        } else {
            installNormal(context, apkPath);
        }

//        installNormal(context, apkPath);
    }

    /**
     * 通过非Root模式安装
     *
     * @param context
     * @param apkPath
     */
    public static void install(Context context, String apkPath) {
        install(context, apkPath, false);
    }

    //普通安装
    private static void installNormal(Context context, String apkPath) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        File file = (new File(apkPath));
        //版本在7.0以上是不能直接通过uri访问的
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            // 由于没有在Activity环境下启动Activity,设置下面的标签
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri = FileProvider.getUriForFile(context, "www.zhouyan.project.fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    //通过Root方式安装 静默安装
    private static void installRoot(final Context context, final String apkPath) {
        //        Observable.just(apkPath)
//                .map(mApkPath -> "pm install -r " + mApkPath)
//                .map(SystemManager::RootCommand)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(integer -> {
//                    if (integer == 0) {
//                        Toast.makeText(context, "安装成功", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(context, "root权限获取失败,尝试普通安装", Toast.LENGTH_SHORT).show();
//                        install(context,apkPath);
//                    }
//                });
//    }


        Observable.just(apkPath)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String apkPath) {
//                        Log.e("-----------apkPath",apkPath+"");
                        String i = "pm install -r " + apkPath;
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
                            i = "pm install -i www.zhouyan.project -–user 0" + apkPath;
                        }

                        return i;
                    }
                }).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {

                return SystemManager.RootCommand(s);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer i) {

                        if (i == 0) {
                            Toast.makeText(context, "安装成功", Toast.LENGTH_SHORT).show();
                            //自动打开项目
                        } else {
                            Toast.makeText(context, "root权限获取失败,尝试普通安装", Toast.LENGTH_SHORT).show();
                            install(context, apkPath);
                        }
                    }
                });
    }
}
