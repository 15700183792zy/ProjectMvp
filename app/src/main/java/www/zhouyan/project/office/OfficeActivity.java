package www.zhouyan.project.office;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import www.zhouyan.project.base.BaseActivity;

/**
 * Created by mac on 18/3/21.
 */

public class OfficeActivity extends BaseActivity {

    public static void show(Context mContext) {
        Intent intent = new Intent(mContext, OfficeActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public int bindLayout() {
        return 0;
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


//    @Override
//    public boolean isNeedRefreshBroadcast() {
//        return false;
//    }
}
