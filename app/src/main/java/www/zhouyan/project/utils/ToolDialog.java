package www.zhouyan.project.utils;

import android.content.Context;
import android.content.Intent;

import www.zhouyan.project.login.LauncherActivity;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.login.view.LoginActivity;
import www.zhouyan.project.login.view.ResetPasswordActvitiy;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.widget.dialog.DialogShow;
import www.zhouyan.project.widget.dialog.DialogShowCancle;

/**
 * Created by mac on 18/3/21.
 */

public class ToolDialog  {


    public static  DialogShow dialig(Context context2, final String msg){
        final BaseActivity context = (BaseActivity) context2;
        try {
            // 设置封面
            DialogShow mDialogShow = new DialogShow(
                    context);
            mDialogShow.setCanceledOnTouchOutside(true);
            mDialogShow.setTitleText(msg + "。");
            if (!mDialogShow.isShowing() && !context.isDestroyed()) mDialogShow.show();
            return mDialogShow;
        } catch (Exception e) {
            // Log.e("AlertDialog  Exception:" + e.getMessage());
        }
        return null;
    }

    public static void dialogShow(Context context2, final String msg) {
        final BaseActivity context = (BaseActivity) context2;
        if (context instanceof LoginActivity) {
            if (msg.equals("网络出现异常, 请稍后重试")) {
                try {
                    //网络异常是否进入离线模式
                    DialogShowCancle mDialogShow = new DialogShowCancle(
                            context);
                    mDialogShow.setCanceledOnTouchOutside(true);
                    mDialogShow.setTitleText("网络异常是否确定进入离线模式?");

                    mDialogShow.setCancerClickListener(new DialogShowCancle.OnCustomDialogClickListener() {
                        @Override
                        public void onClick(DialogShowCancle customDialog) { //否
                            customDialog.dismiss();
                        }
                    }).setConfirmClickListener(new DialogShowCancle.OnCustomDialogClickListener() {
                        @Override
                        public void onClick(DialogShowCancle customDialog) {
                            customDialog.dismiss();
                            MyApplication.getInstance().setOffline(true);
                           String  name = ToolFile.getString(ConstantManager.SP_USER_NAME);
                            ToolFile.putString(name + "flag", 0 + "");
                            //跳转界面
                            Intent intent = new Intent(context, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("id",1);
                            context.startActivity(intent);
                            context.finish();
                        }
                    });
                    if (!mDialogShow.isShowing() && !context.isDestroyed()) mDialogShow.show();
                } catch (Exception e) {
                    // Log.e("AlertDialog  Exception:" + e.getMessage());
                }
            } else {
                try {
                    // 设置封面
                    DialogShow mDialogShow = new DialogShow(
                            context);
                    mDialogShow.setCanceledOnTouchOutside(true);
                    mDialogShow.setTitleText(msg + "。");
                    if (!mDialogShow.isShowing() && !context.isDestroyed()) mDialogShow.show();
                } catch (Exception e) {
                    // Log.e("AlertDialog  Exception:" + e.getMessage());
                }
            }
        } else {

            try {
                // 设置封面
                DialogShow mDialogShow = new DialogShow(
                        context);
                mDialogShow.setCanceledOnTouchOutside(true);
                mDialogShow.setTitleText(msg + "。");
                mDialogShow.setCancerClickListener(new DialogShow.OnCustomDialogClickListener() {
                    @Override
                    public void onClick(DialogShow customDialog) {
                        customDialog.dismiss();
                        if (msg.equals("网络出现异常, 请稍后重试")) {
                            if (context instanceof LauncherActivity||context instanceof ResetPasswordActvitiy) {
                                String name = ToolFile.getString(ConstantManager.SP_USER_NAME);
                                ToolFile.putString(name + "flag", 0 + "");
                                //跳转界面
                                Intent intent = new Intent(context, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("id",1);
                                context.startActivity(intent);
                                context.finish();
                            }
                        }
                    }
                });
                if (!mDialogShow.isShowing() && !context.isDestroyed()) mDialogShow.show();

            } catch (Exception e) {
                // Log.e("AlertDialog  Exception:" + e.getMessage());
            }
        }
    }

    public static void dialogShow(Context context2, final int code, String msg) {
        final  BaseActivity context = (BaseActivity) context2;
        try {
            // 设置封面
            DialogShow mDialogShow = new DialogShow(
                    context);
            mDialogShow.setCanceledOnTouchOutside(true);
            mDialogShow.setTitleText(msg + "(" + code + ")").setCancerClickListener(new DialogShow.OnCustomDialogClickListener() {
                @Override
                public void onClick(DialogShow customDialog) {
                    if (code == ConstantManager.SUCCESS_REQUEST3) {
                        MyApplication.getInstance().removeToTop();
                        ToolFile.putString(ConstantManager.SP_USER_PSW, "");
                        ToolFile.putString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "flag", 0 + "");
                        if (!(context instanceof LoginActivity)) {
                            Intent mintent = new Intent();
                            mintent.setClass(context, LoginActivity.class);
                            mintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(mintent);
                            context.finish();
                        }
                        customDialog.dismiss();
                    } else {
                        customDialog.dismiss();
                    }
                }
            });
            if (!mDialogShow.isShowing() && !context.isDestroyed()) mDialogShow.show();
        } catch (Exception e) {
            ///  DebugUtil.e("AlertDialog  Exception:" + e.getMessage());
        }


    }
}
