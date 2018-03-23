package www.zhouyan.project.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import www.zhouyan.project.R;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.home.presenter.HomeActPresenter;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.order.SaleOrderActivity;
import www.zhouyan.project.utils.SPUtils;
import www.zhouyan.project.utils.StatusBarUtil;
import www.zhouyan.project.utils.ToolAlert;
import www.zhouyan.project.utils.ToolDialog;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.utils.ToolPermisstionsUtils;

/**
 * Created by mac on 18/3/21.
 */

public class HomeActivity extends BaseActivity implements IHomeActView,RadioGroup.OnCheckedChangeListener{
    public static void show(Context mContext) {
        Intent intent = new Intent(mContext, HomeActivity.class);
        mContext.startActivity(intent);
    }
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_file)
    RadioButton rbFile;
    @BindView(R.id.rb_export)
    RadioButton rbExport;
    @BindView(R.id.rb_work)
    RadioButton rbWork;
    @BindView(R.id.rb_set)
    RadioButton rbSet;
    @BindView(R.id.rg_bottom)
    RadioGroup rgBottom;


    //    private ActionBarDrawerToggle mDrawerToggle;
    public ArrayList<Fragment> fragments;


    @Override
    public int bindLayout() {

        return R.layout.activity_home;
    }

    HomeActPresenter homeActPresenter;

    private String mobile;
    //清楚缓存不允许

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        sellorder_save = ToolPermisstionsUtils.getInstance(this).getPermissions("sellorder_save");
        int type = StatusBarUtil.StatusBarLightMode(this);
        StatusBarUtil.StatusBarDarkMode(this, type);
        mobile = ToolFile.getString(ConstantManager.SP_USER_NAME);


        //初始化 toolbar 防止第一个fragment不显示toolbar
        view_pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });

        view_pager.getParent().requestDisallowInterceptTouchEvent(true);
        setRadioGroups();
        setFragments();
        setViewPager();


//        rbHome.setText("工作台");//正式版本  测试工作台

        homeActPresenter = new HomeActPresenter(this);
//
       upload();



        //检测个推的clientID
        checkClientId();


      homeActPresenter.service();



        //测试自动下载安装apk
        checkVersion();


        sql();//
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void upload() {
       homeActPresenter.upload();
    }


    @Override
    public void toMainOrder() {

    }
    @Override
    public void checkClientId() {
        if (!mobile.equals("")) {

            String clientid = SPUtils.getString(HomeActivity.this, "clientid");
            homeActPresenter.checkClientId(mobile,clientid);
        }
    }


    private boolean sellorder_save;

    @Override
    public void checkVersion() {
       homeActPresenter.checkVersion(mobile);
    }

    @Override
    public void sql() {
        homeActPresenter.downsql();
    }





    private int type = 0;

    @Override
    protected void onResume() {
        super.onResume();
        //判断时间是否大于24小时，大于 重新获取登录数据
        // toolLogin.write();
        type++;
        if (type == 1) {
           homeActPresenter.resume(mobile);
            type = 0;
        }
    }


    private int position = 0;

    private void setRadioGroups() {
        rgBottom.setOnCheckedChangeListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                position = 0;
                view_pager.setCurrentItem(0, false);

                break;
            case R.id.rb_file:
                position = 1;
                view_pager.setCurrentItem(1, false);

                break;
            case R.id.rb_export:
//                Intent intent = new Intent(HomeActivity.this, SaleOrderActivity.class);
//                startActivity(intent);
                break;
            case R.id.rb_work:
                position = 3;
                view_pager.setCurrentItem(3, false);

                break;
            case R.id.rb_set:
                position = 4;
                view_pager.setCurrentItem(4, false);
                break;

        }
    }

    private void setFragments() {
        fragments = new ArrayList<>();
        //HomeFragment
        fragments.add(HomeFragment.newInstance());//工作台
        fragments.add(InventFragment.newInstance());//档案

        fragments.add(EmptyFragment.newInstance());//空的
        fragments.add(FilesFragment.newInstance());//业务管理
        fragments.add(FinanceFragment.newInstance());//我的
    }

    private void setViewPager() {
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        view_pager.setOffscreenPageLimit(4);
    }


    @Override
    public void resume() {
        view_pager.setCurrentItem(position);
        if (position == 0) rbHome.setChecked(true);
        else if (position == 1) rbFile.setChecked(true);
        else if (position == 3) rbWork.setChecked(true);
        else if (position == 4) rbSet.setChecked(true);
    }




    //二次点击间隔小于2000毫秒才会退出应用
    private long waitTime = 2000;
    //点击时的时间
    private long touchTime = 0;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                ToolAlert.showShortToast("再按一次, 退出程序。");
                touchTime = currentTime;
            } else {
                ((MyApplication) getApplicationContext()).removeAll();
                super.onBackPressed();
            }
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }


    @OnClick(R.id.btn_export)
    public void onViewClicked() {
        if (sellorder_save) {
            SaleOrderActivity.show(this);
        } else {
            showMessage("没有权限");
        }
    }

    @Override
    protected void onDestroy() {
        // TODO 自动生成的方法存根
        super.onDestroy();

        homeActPresenter.ondestory();
        for (Fragment f : fragments) {
            f = null;
        }

       homeActPresenter=null;
    }



    @Override
    public void showMessage(String msg) {
        ToolDialog.dialig(this,msg);
    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showDialogs(int code, String message) {

    }




//    @Override
//    public int setMenuResId() {
//        return 0;
//    }
//
//    @Override
//    public boolean isNeedRefreshBroadcast() {
//        return false;
//    }
}
