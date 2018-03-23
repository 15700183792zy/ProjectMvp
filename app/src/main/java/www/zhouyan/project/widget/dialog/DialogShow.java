package www.zhouyan.project.widget.dialog;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

import www.zhouyan.project.R;
import www.zhouyan.project.utils.OptAnimationLoader;


/**
 * @author zhouyan
 * @description 自定义对话框 提示错误
 * @data 2016-03－18
 * @class DialogShow 继承Dialog
 */
public class DialogShow extends AlertDialog implements View.OnClickListener {
    private View mDialogView;
    @SuppressWarnings("unused")
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private TextView tv_dialog_title;
    private Button btn_dialog_confirm;
    private OnCustomDialogClickListener mCancerClickListener;

    private boolean mCloseFromCancel;
    public static final int NORMAL_TYPE = 0;
    private String mTitleText;

    public static interface OnCustomDialogClickListener {
        public void onClick(DialogShow customDialog);
    }

    public DialogShow(Context context) {
        this(context, NORMAL_TYPE);
    }

    public DialogShow(Context context, int alertType) {

        super(context, R.style.custom_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);

        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.dialogslide_in_bottom);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.dialogslide_out_bottom);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCloseFromCancel) {
                            DialogShow.super.cancel();
                        } else {
                            DialogShow.super.dismiss();
                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @Override
    public void show() {
        super.show();
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_show);
        //   Typeface fzjlFont = AppApplication.getInstace().getLightFont();
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        btn_dialog_confirm = (Button) findViewById(R.id.btn_dialog_confirm);
        tv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);

        btn_dialog_confirm.setOnClickListener(this);
        setTitleText(mTitleText);
    }
    public DialogShow setTitleText(String text) {
        mTitleText = text;
        if (tv_dialog_title != null && mTitleText != null) {
            tv_dialog_title.setText(mTitleText);
        }else if(mTitleText==null||mTitleText.equals("")){
            tv_dialog_title.setVisibility(View.GONE);
        }
        return this;
    }



    public String getTitleText() {
        return mTitleText;
    }

    public DialogShow setCancerClickListener(OnCustomDialogClickListener listener) {
        mCancerClickListener = listener;
        return this;
    }

    /**
     * The real Dialog.cancel() will be invoked async-ly after the animation finishes.
     */
    @Override
    public void cancel() {
        dismissWithAnimation(true);
    }

    /**
     * The real Dialog.dismiss() will be invoked async-ly after the animation finishes.
     */
    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        mCloseFromCancel = fromCancel;
        mDialogView.startAnimation(mModalOutAnim);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_dialog_confirm) {
            if (mCancerClickListener != null) {
                mCancerClickListener.onClick(DialogShow.this);
            } else {
                dismissWithAnimation();
            }
        }
    }

}