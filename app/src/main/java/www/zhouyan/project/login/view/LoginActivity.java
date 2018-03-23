package www.zhouyan.project.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import www.zhouyan.project.R;
import www.zhouyan.project.base.BaseActivity;

/**
 * Created by mac on 18/3/21.
 */

public class LoginActivity extends BaseActivity {



    private LoginFragment fragment;

    public static void show(Context mContext) {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_fragment;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {

        fragment = LoginFragment.newInstance();

        fm.beginTransaction()     //具体的操作类似数据库的事务处理过程
                .add(R.id.fl_layout_invent, fragment)
                .commit();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {
        fragment = null;
        super.destroy();
    }


//    @Override
//    public boolean isNeedRefreshBroadcast() {
//        return false;
//    }
}
