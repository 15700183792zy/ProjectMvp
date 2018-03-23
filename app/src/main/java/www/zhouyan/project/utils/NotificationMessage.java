package www.zhouyan.project.utils;

import android.os.Bundle;
import android.widget.RemoteViews;

/**
 * 发送Notification通知实体
 *
 * @author zhouyan
 * @version 1.0
 *
 */
public class NotificationMessage extends Message {

    /**
     *
     */
    private static final long serialVersionUID = 681166507845221063L;

    /**
     * 状态栏提示信息图标
     */
    private int iconResId;

    /**
     * 状态栏提示信息图标
     */
    private String statusBarText;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 点击消息跳转的界面
     */
    private Class forwardComponent;

    /**
     * 点击消息跳转界面需携带的数据
     */
    private Bundle extras;

    /**
     * 自定义消息通知布局View
     */
    private RemoteViews mRemoteViews;

    public int getIconResId() {
        return iconResId;
    }

    /**
     * @param iconResId
     *  设置图标
     */
    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getStatusBarText() {
        return statusBarText;
    }

    /**
     * @param statusBarText
     * 提示信息图标
     */
    public void setStatusBarText(String statusBarText) {
        this.statusBarText = statusBarText;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * @param msgTitle
     * 标题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    /**
     * @param msgContent
     * 	消息内容
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Class getForwardComponent() {
        return forwardComponent;
    }

    /**
     * @param forwardComponent
     *  跳转的类
     */
    public void setForwardComponent(Class forwardComponent) {
        this.forwardComponent = forwardComponent;
    }

    public Bundle getExtras() {
        return extras;
    }

    /**
     * @param extras
     *  传递的数据
     */
    public void setExtras(Bundle extras) {
        this.extras = extras;
    }

    public RemoteViews getmRemoteViews() {
        return mRemoteViews;
    }

    /**
     * @param mRemoteViews
     * 	自定义布局
     */
    public void setmRemoteViews(RemoteViews mRemoteViews) {
        this.mRemoteViews = mRemoteViews;
    }
}
