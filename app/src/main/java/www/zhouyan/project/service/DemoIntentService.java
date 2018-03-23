package www.zhouyan.project.service;

/**
 * Created by zhouyan on 2017/5/20.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

import www.zhouyan.project.R;
import www.zhouyan.project.utils.SPUtils;


/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class DemoIntentService extends GTIntentService {

    public DemoIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();

        // 第三方回执调用接口, actionid范围为90000-90999, 可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context,
                taskid, messageid, 90001);
        Log.d(TAG, "call sendFeedbackMessage = "
                + (result ? "success" : "failed"));

        Log.d(TAG, "onReceiveMessageData -> " + "appid = " + appid
                + "\ntaskid = " + taskid + "\nmessageid = " + messageid
                + "\npkg = " + pkg + "\ncid = " + cid);

        if (payload == null) {
            Log.e(TAG, "receiver payload = null");
        } else {
            String data = new String(payload);
            Log.e(TAG, "receiver payload = " + data);
            showNotification(R.drawable.ls_logo, data, "恋商进销存", data);
//            EventBus_Config config = new EventBus_Config();
//            config.msg = "refreshMessage";
//            EventBus.getDefault().postSticky(config);
        }

    }

    public void showNotification(int icon, String tickertext, String title,
                                 String content) {
        //全局通知管理者, 通过获取系统服务获取
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //通知栏构造器,创建通知栏样式
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        // 将来意图, 用于点击通知之后的操作,内部的new intent()可用于跳转等操作
        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 1, new Intent(), Notification.FLAG_AUTO_CANCEL);

        //设置通知栏标题
        mBuilder.setContentTitle(title)
                //设置通知栏显示内容
                .setContentText(content)
                //设置通知栏点击意图
                .setContentIntent(mPendingIntent)
                //通知首次出现在通知栏, 带上升动画效果的
                .setTicker(tickertext)
                //通知产生的时间, 会在通知信息里显示, 一般是系统获取到的时间
                .setWhen(System.currentTimeMillis())
                //设置该通知优先级
                .setPriority(Notification.PRIORITY_DEFAULT)
                //设置这个标志当用户单击面板就可以让通知将自动取消
                .setAutoCancel(true)
                //使用当前的用户默认设置
                .setDefaults(Notification.DEFAULT_VIBRATE)
                //设置通知小ICON(应用默认图标)
                .setSmallIcon(icon);

        mNotificationManager.notify(15648, mBuilder.build());

    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
//        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
        SPUtils.putString(this, "clientid", clientid);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }
}