package www.zhouyan.project.retrofit;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.widget.dialog.CircleDialog;


/**
 * Title : 进程弹框Handler
 * Description :
 * Author : zhouyan
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private CircleDialog dialog;

    private BaseActivity context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(BaseActivity context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    private void initProgressDialog(){

        if (dialog == null) {
            if(context!=null&& !context.isDestroyed()) {
                dialog = new CircleDialog(context);

                dialog.setCancelable(cancelable);

                if (cancelable) {
                    dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            mProgressCancelListener.onCancelProgress();
                        }
                    });
                }

                if (dialog!=null && !dialog.isShowing()) {
                    dialog.show();
                }
            }
        }else{
            if(context!=null&& !context.isDestroyed())
            if (!dialog.isShowing()) {
                dialog.show();
            }
        }
    }

    private void dismissProgressDialog(){
        if (dialog != null) {
            if(dialog.isShowing() && !context.isDestroyed())
               dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }

}
