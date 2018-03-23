package www.zhouyan.project.base;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import www.zhouyan.project.R;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.utils.ToolPermisstionsUtils;
import www.zhouyan.project.widget.dialog.CircleDialog;

/**
 * Fragment基类(V4包)
 *
 * @author zhouyan
 */
public abstract class BaseFragmentV4 extends Fragment implements IBaseFragment {

    /**
     * 当前Fragment渲染的视图View
     **/
    private View mContextView = null;
    private boolean actionBusiness = false;
    public boolean product_costprice; //product_costprice  成本价格
    public Handler mHandler;
    public String api2 = null;
    public boolean isOffline;//是否离线
    public ToolPermisstionsUtils permisstionsUtils;
    public int totalcount = 0;
    public MyApplication instance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }





    private FrameLayout flBaseContent;
    private RelativeLayout view_bottom;
    protected ImageView tv_right_btn;
    private TextView tv_back;
    protected TextView tv_center;
    protected TextView tv_save;
    protected ImageView tv_right_search;

    public void initDefaultView(View view,int layoutResId,LayoutInflater inflater){
        flBaseContent = (FrameLayout) view.findViewById(R.id.fl_activity_child_container);
        view_bottom = (RelativeLayout) view.findViewById(R.id.commonTitle_rl);
        tv_back = (TextView) view.findViewById(R.id.ll_back);
        tv_center = (TextView) view.findViewById(R.id.tv_center);
        tv_save = (TextView) view.findViewById(R.id.tv_save);
        tv_right_btn = (ImageView) view.findViewById(R.id.tv_right_btn);
        tv_right_search = (ImageView) view.findViewById(R.id.tv_right_search);

//        tv_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getActivity().finish();
//            }
//        });
        View childView = inflater.inflate(layoutResId, null);
        flBaseContent.addView(childView, 0);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//		// 渲染视图View(防止切换时重绘View)
//		if (null != mContextView) {
//			ViewGroup parent = (ViewGroup) mContextView.getParent();
//			if (null != parent) {
//				parent.removeView(mContextView);
//			}
//		} else {
//			MyLogger.xuanLog().i("onCreateView    "+this.getClass().getSimpleName());
//
//			mContextView = inflater.inflate(bindLayout(), container, false);
//			// 控件初始化
//			ButterKnife.bind(this, mContextView);
//			initView(mContextView);
//		}

        if (activity != null) {
            permisstionsUtils = ((BaseActivity) activity).permisstionsUtils;
            product_costprice = permisstionsUtils.getPermissions("product_costprice");
            //可能有联动问题
            instance = MyApplication.getInstance();
            api2 = instance.getAPI2();
            if(api2==null){
                api2 = ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "api");
            }
            isOffline = instance.isOffline();

            mHandler = new Handler();
            if (null == mContextView) {
                mContextView = inflater.inflate(R.layout.fragment_base,container,false);
                //加载子类fragment的布局
                initDefaultView(mContextView,bindLayout(),inflater);

                // 控件初始化
                ButterKnife.bind(this, mContextView);

                initView(mContextView);
            }/*else{
            // 控件初始化
			ButterKnife.bind(this, mContextView);
		}*/


            isPrepared = true;

            if (isActionBusiness() && isPrepared) {
                doBusiness();
            } else if (isPrepared && isVisible) {
                doBusiness();
            }

            if (isActionBusiness() && !isPrepared) {
                setActionBusiness(true);
            }

            return mContextView;
        } else return null;
    }


    /**
     * 用户返回首页中的view
     *
     * @param titleView
     * @return
     */
    public View getTitleView(TitleView titleView) {
        switch (titleView) {
            case tv_center:
                return tv_center;
            case tv_back:
                return tv_back;
            case tv_save:
                return tv_save;
            case tv_right_btn:
                return tv_right_btn;
            case tv_right_search:
                return tv_right_search;
            case view_bottom:
                return view_bottom;
            default:
                return null;
        }
    }

    /**
     * fragment视图是否显示
     */
    protected boolean isVisible = false;
    /**
     * 是否初始化完成, 即onCreateView过, 才可以doBusiness, 否则会nullpoint
     */
    protected boolean isPrepared = false;

    /**
     * 在onCreateView之前调用
     * 在这里实现Fragment数据的缓加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    public void setActionBusiness(boolean actionBusiness) {
        this.actionBusiness = actionBusiness;
    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void initView(View view) {

    }

    public BaseFragmentV4() {
    }

    @Override
    public void doBusiness() {
    }

    protected void onVisible() {
        // 业务处理
        if (isPrepared && isVisible) {
            doBusiness();
        }
    }

    protected void onInvisible() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
//        Log.e("--------", activity.toString() + "被onDestroy");
        super.onDestroy();
        //避免内泄露
        if (mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }

        permisstionsUtils=null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public BaseActivity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (BaseActivity) activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解绑butterknife

        ButterKnife.bind(this, mContextView).unbind();

    }

    boolean cancelProgressBar;
    private CircleDialog progressBarDialog;
    public void showProgressBar(boolean isShow) {
        if (progressBarDialog == null) {
            progressBarDialog = new CircleDialog((BaseActivity) activity);
        }
        if (isShow) {
            progressBarDialog.show();
        } else {
            progressBarDialog.dismiss();
        }
        //rlLoading.setVisibility(isShow?View.VISIBLE:View.GONE);
        cancelProgressBar = isShow;
    }

}