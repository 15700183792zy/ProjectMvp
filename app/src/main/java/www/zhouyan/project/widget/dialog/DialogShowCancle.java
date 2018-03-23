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
import android.widget.ImageView;
import android.widget.TextView;

import www.zhouyan.project.R;
import www.zhouyan.project.utils.OptAnimationLoader;


/**
 * @author zhouyan
 * @description 自定义对话框 提示信息, 是, 否
 * @data 2016-03－18
 * @class DialogShowCancle 继承Dialog
 */
public class DialogShowCancle extends AlertDialog implements View.OnClickListener {
    private View mDialogView;
    @SuppressWarnings("unused")
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private TextView tv_dialog_title;
    private Button btn_dialog_confirm;
    private Button btn_dialog_cancle;
    private ImageView iv_remark_dialog_cancer;
    private OnCustomDialogClickListener mCancerImageClickListener;
    private OnCustomDialogClickListener mConfirmClickListener;
    private OnCustomDialogClickListener mCancerClickListener;

    private boolean mCloseFromCancel;
    public static final int NORMAL_TYPE = 0;
    private String mTitleText;
    private String mLeftText = "确定";
    private String mRightText = "取消";

    public static interface OnCustomDialogClickListener {
        public void onClick(DialogShowCancle customDialog);
    }

    public DialogShowCancle(Context context) {
        this(context, NORMAL_TYPE);
    }

    public DialogShowCancle(Context context, int alertType) {

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
                            DialogShowCancle.super.cancel();
                        } else {
                            DialogShowCancle.super.dismiss();
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

        if (iv_remark_dialog_cancer != null)
            if (isshow) {
                iv_remark_dialog_cancer.setVisibility(View.VISIBLE);
            } else iv_remark_dialog_cancer.setVisibility(View.GONE);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_show_cancle);
        //   Typeface fzjlFont = AppApplication.getInstace().getLightFont();
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        btn_dialog_confirm = (Button) findViewById(R.id.btn_dialog_confirm);
        tv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);
        btn_dialog_cancle = (Button) findViewById(R.id.btn_dialog_cancle);
        iv_remark_dialog_cancer = (ImageView) findViewById(R.id.iv_remark_dialog_cancer);

        btn_dialog_confirm.setOnClickListener(this);
        btn_dialog_cancle.setOnClickListener(this);
        iv_remark_dialog_cancer.setOnClickListener(this);
        setTitleText(mTitleText, mLeftText, mRightText);
    }


    boolean isshow = false;

    public void setshow(boolean flag) {
        isshow = flag;
    }

    public DialogShowCancle setTitleText(String text, String text1, String text2) {
        mTitleText = text;
        mLeftText = text1;
        mRightText = text2;

        if (btn_dialog_cancle != null && mRightText != null) {
            btn_dialog_cancle.setText(mRightText);
        }

        if (btn_dialog_confirm != null && mLeftText != null) {
            btn_dialog_confirm.setText(mLeftText);
        }

        if (tv_dialog_title != null && mTitleText != null) {
            tv_dialog_title.setText(mTitleText);
        } else if (mTitleText == null || mTitleText.equals("")) {
            if (tv_dialog_title != null)
                tv_dialog_title.setVisibility(View.GONE);
        }
        return this;
    }

    public DialogShowCancle setTitleText(String text) {
        return setTitleText(text, "确定", "取消");
    }


    public String getTitleText() {
        return mTitleText;
    }

    public DialogShowCancle setConfirmClickListener(OnCustomDialogClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }

    public DialogShowCancle setCancerClickListener(OnCustomDialogClickListener listener) {
        mCancerClickListener = listener;
        return this;
    }

    public DialogShowCancle setmCancerImageClickListener(OnCustomDialogClickListener listener) {
        this.mCancerImageClickListener = listener;
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
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(DialogShowCancle.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.btn_dialog_cancle) {
            if (mCancerClickListener != null) {
                mCancerClickListener.onClick(DialogShowCancle.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.iv_remark_dialog_cancer) {
            if (mCancerImageClickListener != null) {
                mCancerImageClickListener.onClick(DialogShowCancle.this);
            } else {
                dismissWithAnimation();
            }
        }
    }

}