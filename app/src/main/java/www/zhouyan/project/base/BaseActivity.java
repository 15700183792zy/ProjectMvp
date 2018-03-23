package www.zhouyan.project.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;

import butterknife.ButterKnife;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.utils.MyLogger;
import www.zhouyan.project.utils.ToolPermisstionsUtils;

/**
 * Created by mac on 18/3/21.
 */

public abstract class BaseActivity extends PermissionsActivity implements
        IBaseActivity {

    /**
     * 全局的LayoutInflater对象, 已经完成初始化.
     */
    public LayoutInflater mInflater;
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;
    /*** 整个应用Applicaiton **/
    private MyApplication mApplication = null;
    /**
     * 当前Activity的弱引用, 防止内存泄露
     **/
    private WeakReference<Activity> context = null;
//    private int menuResId = 0;
//
//    private RefreshBroadcast broadcast;
//    private boolean isNeedRefreshBroadcast = false;

    private ProgressDialog progressDialog;
    public ExecutorService cachedThreadPool;
    public ToolPermisstionsUtils permisstionsUtils;
    //建立关联
    public FragmentManager fm;

    /**
     * 生成一个和状态栏大小相同的矩形条
     *
     * @param activity 需要设置的activity
     * @param color    状态栏颜色值
     * @return 状态栏矩形条
     */
    // 方式二: 使用静态方式创建并显示, 这种进度条只能是圆形条,设置title和Message提示内容
    public static View createStatusView(Activity activity, int color) {
        // 获得状态栏高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取出标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        /*//防止截屏
		Window win = getWindow();
		win.addFlags(WindowManager.LayoutParams.FLAG_SECURE);*/
        //设置渲染视图View
        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        super.setContentView(mContextView);
        permisstionsUtils = ToolPermisstionsUtils.getInstance(this);
        cachedThreadPool = ((MyApplication) getApplication()).cachedThreadPool;

//        MyApplication.getInstance().watcher.watch(this);

//		//状态栏透明
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//			localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//		}

//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//			getWindow().setStatusBarColor(Color.RED);
//		}

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成一个状态栏大小的矩形
            View statusView = createStatusView(this, Color.parseColor("#1e82d8"));

            // 添加 statusView 到布局中
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            decorView.addView(statusView);
            // 设置根布局的参数
            mContextView.setFitsSystemWindows(true);
        }


        // 获取应用Application
        mApplication = (MyApplication) getApplicationContext();

        // 将当前Activity压入栈
        context = new WeakReference<Activity>(this);
        mApplication.pushTask(context);

        //初始化控件
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initView(mContextView, savedInstanceState);
//        menuResId = setMenuResId();

//		MyLogger.xuanLog().i("onCreate BaseActivity "+this.getClass().getSimpleName());
//
//        //注册一个刷新广播
//        if (isNeedRefreshBroadcast() && broadcast == null) {
//            broadcast = new RefreshBroadcast();
//            registerReceiver(broadcast, new IntentFilter(getContext().getClass().getSimpleName()));
//        }

        //业务操作
        doBusiness();


    }

    /*
  * 提示加载
  */
    public void showProgressDialog(String title, String message) {
        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(this, title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }

        progressDialog.show();

    }

    /*
     * 隐藏提示加载
     */
    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.menu, menu);
//		/* ShareActionProvider配置 */
//		ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu
//				.findItem(R.id.toolbar_share));
//		Intent intent = new Intent(Intent.ACTION_SEND);
//		intent.setType("text/*");
//		mShareActionProvider.setShareIntent(intent);
//		return super.onCreateOptionsMenu(menu);
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		 switch (item.getItemId()) {
//		 case R.id.toolbar_search:
//		 Toast.makeText(this, "toolbar_search", 0).show();
//		 break;
//		 case R.id.toolbar_share:
//		 Toast.makeText(this, "toolbar_share", 0).show();
//		 break;
//		 case R.id.toolbar_settings:
//		 Toast.makeText(this, "toolbar_settings", 0).show();
//		 break;
//		 default:
//		 break;
//		 }
//		return super.onOptionsItemSelected(item);
//	}

//	/**
//	 * 设置系统状态栏
//	 */
//	private void setSystemBar() {
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//			setTranslucentStatus(true);
//		}
//
//		SystemBarTintManager mTintManager = new SystemBarTintManager(this);
//		mTintManager.setStatusBarTintEnabled(true);
//		mTintManager.setStatusBarTintResource(R.color.black);
//	}
//
//	@TargetApi(19)
//	private void setTranslucentStatus(boolean on) {
//		Window win = getWindow();
//		WindowManager.LayoutParams winParams = win.getAttributes();
//		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//		if (on) {
//			winParams.flags |= bits;
//		} else {
//			winParams.flags &= ~bits;
//		}
//		win.setAttributes(winParams);
//	}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 描述: Activity结束.
     *
     * @see Activity#finish()
     */
    @Override
    public void finish() {

        //关闭 软键盘
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
//        overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
        super.finish();
    }



    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void destroy() {

    }

    @Override
    protected void onDestroy() {
        destroy();
        ButterKnife.bind(this, mContextView).unbind();
        if (mApplication != null) {
            mApplication.removeTask(context);
        }
//        if (broadcast != null) {
//            unregisterReceiver(broadcast);
//        }

        super.onDestroy();
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    protected Activity getContext() {
        if (null != context)
            return context.get();
        else
            return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // 关闭窗体动画显示
        // overridePendingTransition(R.anim.activity_close,R.anim.alpha_out);
        // overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    MyLogger.systemlLog().e("onMenuOpened...unable to set icons for overflow menu", e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        if (menuResId != 0) {
//            // 為了讓 Toolbar 的 Menu 有作用
//            getMenuInflater().inflate(menuResId, menu);
//        }

        return super.onCreateOptionsMenu(menu);
    }


    private class RefreshBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(getContext().getClass().getSimpleName())) {
                doBusiness();
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //super.onSaveInstanceState(outState, outPersistentState);
    }
}
