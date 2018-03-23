package www.zhouyan.project.retrofit;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.utils.MyLogger;
import www.zhouyan.project.utils.ToolDialog;

/**
 * 用于在Http请求开始时, 自动显示一个ProgressDialog
 * 在Http请求结束是, 关闭ProgressDialog
 * 调用者自己对请求数据进行处理
 * Created by zhouyan on 17/5/22.
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListener mSubscriberOnNextListener;
    private ProgressDialogHandler mProgressDialogHandler=null;
    private boolean isShowDialog = true;
    private SwipeRefreshLayout sw_layout;
    BaseActivity context;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context, int id) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        if (id == 0){
            this.context = (BaseActivity) context;
            mProgressDialogHandler = new ProgressDialogHandler(this.context, this, true);
        }
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context, boolean isShowDialog) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = (BaseActivity) context;
        this.isShowDialog = isShowDialog;
        mProgressDialogHandler = new ProgressDialogHandler(this.context, this, true);
    }

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener, Context context, boolean isShowDialog, SwipeRefreshLayout sw_layout) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = (BaseActivity) context;
        this.isShowDialog = isShowDialog;
        this.sw_layout = sw_layout;
        mProgressDialogHandler = new ProgressDialogHandler(this.context, this, true);
    }

    public void showProgressDialog() {
        if (mProgressDialogHandler != null && isShowDialog) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    public void dismissProgressDialog() {
        if (mProgressDialogHandler != null && isShowDialog) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }

    /**
     * 完成, 隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        dismissProgressDialog();
        dismissSwipeLayout();
    }

    private void dismissSwipeLayout() {
        if (sw_layout != null) {
            sw_layout.setRefreshing(false);
        }
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        String error = "";
        if (e instanceof SocketTimeoutException) {
            error = "网络出现异常, 请稍后重试";
        } else if (e instanceof ConnectException) {
            error = "网络出现异常, 请稍后重试";
        } else if (e instanceof HttpException) {
            error = "网络出现异常, 请稍后重试";
        } else if (e instanceof UnknownHostException) {
            error = "网络出现异常, 请稍后重试";
        } else {
            if (TextUtils.isEmpty(e.getMessage())) {
                error = "网络出现异常, 请稍后重试";
            } else {
                error = e.getMessage();
            }
        }


        MyLogger.xuanLog().e("onError   :   " + error);
        e.printStackTrace();
        ToolDialog.dialogShow(context, error);

        dismissProgressDialog();
        dismissSwipeLayout();
    }

    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }

    /**
     * 取消ProgressDialog的时候, 取消对observable的订阅, 同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }



//    public void saveFile(ResponseBody body) {
//        String fileStoreDir = Environment.getExternalStorageDirectory().getAbsolutePath();
//        String fileName = "sykj.txt";
//        InputStream is = null;
//        byte[] buf = new byte[2048];
//        int len;
//        FileOutputStream fos = null;
//        try {
//            is = body.byteStream();
//            File dir = new File(fileStoreDir);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            File file = new File(dir, fileName);
//            fos = new FileOutputStream(file);
//            while ((len = is.read(buf)) != -1) {
//                fos.write(buf, 0, len);
//            }
//            fos.flush();
//            unsubscribe();
//            //onCompleted();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (is != null) is.close();
//                if (fos != null) fos.close();
//            } catch (IOException e) {
//                Log.e("saveFile", e.getMessage());
//            }
//        }
//    }
}