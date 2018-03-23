package www.zhouyan.project.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;

import www.zhouyan.project.R;
import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;
import www.zhouyan.project.base.BaseActivity;


/**
 * Title : 自定义Dialog
 * Description :
 * Author : zhouyan
 */
public class CircleDialog extends Dialog {

    private BaseActivity context;
    private ProgressBar pb;

    public CircleDialog(BaseActivity context) {
        super(context, R.style.TransparentDialogStyle);
        this.context=context;
        //设置dialog布局
        View view = View.inflate(context, R.layout.dialog_progress_circle, null);
        setContentView(view);
        pb=(ProgressBar) view.findViewById(R.id.pb);
        // 设置google样式
        pb.setIndeterminateDrawable(new IndeterminateProgressDrawable(context));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public ProgressBar getProgressBar(){
        return pb;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void show() {
        if(!this.isShowing()){
            super.show();
        }
    }

    @Override
    public void dismiss() {
        if (isShowing())
            super.dismiss();
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    /**
     * 清空dialog
     */
    public void cleanDrawable() {
        pb.setIndeterminateDrawable(null);
        pb.destroyDrawingCache();
    }
}
