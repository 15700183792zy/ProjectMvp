package www.zhouyan.project.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import www.zhouyan.project.R;
import www.zhouyan.project.base.BaseActivity;

/**
 * Created by mac on 18/3/22.
 */

public class SaleOrderActivity extends BaseActivity {
    public static void show(Context mContext) {
        Intent intent = new Intent(mContext, SaleOrderActivity.class);
        mContext.startActivity(intent);
    }
    @Override
    public int bindLayout() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void resume() {

    }
}
