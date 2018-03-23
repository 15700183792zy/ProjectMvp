package www.zhouyan.project.login.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import www.zhouyan.project.R;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.base.BaseFragmentV4;
import www.zhouyan.project.base.TitleView;
import www.zhouyan.project.home.view.HomeActivity;
import www.zhouyan.project.login.presenter.LoginPresenter;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.modle.LoginPost;
import www.zhouyan.project.office.OfficeActivity;
import www.zhouyan.project.utils.NetWorkUtils;
import www.zhouyan.project.utils.StatusBarUtil;
import www.zhouyan.project.utils.ToolDialog;
import www.zhouyan.project.utils.ToolFile;
import www.zhouyan.project.utils.ToolPhoneEmail;
import www.zhouyan.project.widget.dialog.DialogShowCancle;
import www.zhouyan.project.widget.edittext.ClearEditText;

/**
 * Created by mac on 18/3/21.
 */

public class LoginFragment extends BaseFragmentV4 implements ILoginView{

    @BindView(R.id.met_login_phone)
    ClearEditText metLoginPhone;

    @BindView(R.id.met_login_password)
    ClearEditText metLoginPassword;

    @BindView(R.id.cb_check)
    CheckBox cb_check;

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.tv_password)
    LinearLayout tvPassword;

    @BindView(R.id.tv_regist)
    LinearLayout tvRegist;

    @BindView(R.id.tv_version)
    TextView tv_version;


    private LoginPresenter mLoginPresenter;
    @Override
    public boolean isActionBusiness() {
        return false;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    public LoginFragment() {
        super();
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void initView(View view) {
        mLoginPresenter = new LoginPresenter(this);

        View view_bottom = getTitleView(TitleView.view_bottom);
        view_bottom.setVisibility(View.GONE);
        // 生成一个状态栏大小的矩形
        View statusView = BaseActivity.createStatusView(activity, Color.WHITE);
        // 添加 statusView 到布局中
        ViewGroup decorView = (ViewGroup) ((LoginActivity) activity).getWindow().getDecorView();
        decorView.addView(statusView);

        if (Build.VERSION.SDK_INT >= 19) {//4.4 之上
            int type = StatusBarUtil.StatusBarLightMode(activity);
            StatusBarUtil.StatusBarLightMode(activity, type);
        } else {
            StatusBarUtil.transparencyBar(activity);
        }




        String mobile = ToolFile.getString(ConstantManager.SP_USER_NAME);
        metLoginPhone.setText(mobile);
        metLoginPassword.setText(ToolFile.getString(ConstantManager.SP_USER_PSW));



        setFocusListen();
        closeInputEditText();

        cb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.d(TAG, "onCheckedChanged: "+isChecked);
                if (isChecked) {
                    //选择状态 显示明文--设置为可见的密码
                    metLoginPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    metLoginPassword.setSelection(metLoginPassword.getText().toString().length());
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    metLoginPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    metLoginPassword.setSelection(metLoginPassword.getText().toString().length());
                }
            }
        });

        tv_version.setText("当前版本： v" + ToolFile.getString(activity, ConstantManager.SP_USER_VERSION));

    }


    /**
     * 监听输入框状态
     */
    private void setFocusListen() {

        metLoginPhone.setSelection(metLoginPhone.getText().toString().length());
        metLoginPassword.setSelection(metLoginPassword.getText().toString().length());


    }


    @OnClick(R.id.tv_regist)
    void tv_regist() {
        toRegisterAct();

    }

    @OnClick(R.id.tv_password)
    void tv_password() {
        toForgetPswAct();
    }

    SQLiteDatabase db = null;
    LoginPost loginPost=null;
    @OnClick(R.id.bt_login)
    public  void login() {

        if (TextUtils.isEmpty(metLoginPhone.getText().toString())) {
            showMessage( "你输入手机号不能为空");
        } else if (TextUtils.isEmpty(metLoginPassword.getText().toString())) {
            showMessage( "你输入密码不能为空");
        } else if (ToolPhoneEmail.isMobileNO(metLoginPhone.getText().toString().trim())) { //电话号码 格式判断
            loginPost = new LoginPost(metLoginPhone.getText().toString(), metLoginPassword.getText().toString());
            //是否网络异常，进入离线模式
            int netWorkState = NetWorkUtils.getNetworkState(instance);
            if (netWorkState == NetWorkUtils.NETWORN_NONE) {
                //网络异常是否进入离线模式
                DialogShowCancle mDialogShow = new DialogShowCancle(
                        activity);
                mDialogShow.setCanceledOnTouchOutside(true);
                mDialogShow.setTitleText("网络异常是否确定进入离线模式?");

                mDialogShow.setCancerClickListener(new DialogShowCancle.OnCustomDialogClickListener() {
                    @Override
                    public void onClick(DialogShowCancle customDialog) { //否
                        customDialog.dismiss();
                    }
                }).setConfirmClickListener(new DialogShowCancle.OnCustomDialogClickListener() {
                    @Override
                    public void onClick(DialogShowCancle customDialog) {
                        customDialog.dismiss();

                        //判断数据库是否存在
                        if (db == null || !db.isOpen())
                            db = instance.getGreenDaoManager().getWritableDatabase();
                        //同步数据库
                        Cursor cursor = db.rawQuery("select count(*) as num from sqlite_master where  name ='synctime'", null);
                        if (cursor != null) {
                            if (cursor.moveToFirst()) { //循环遍历查找数组
                                String string = cursor.getString(cursor.getColumnIndex("num"));
                                int index = Integer.parseInt(string.trim());
                                if (index == 1) {
                                    //离线上传
                                    instance.setOffline(true);
                                    toOffice();
                                }else{
                                    showMessage("请先下载数据库");
                                }
                            }

                            cursor.close();
                        }



                    }
                });
                mDialogShow.show();
            } else{
                mLoginPresenter.login(activity,loginPost,0);
            }

        } else {
           showMessage("你输入的电话号码格式不正确");
        }
    }

    private void closeInputEditText() {
        //关闭 软键盘
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputManger = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @Override
    public void showMessage(String msg) {
        ToolDialog.dialogShow(activity,msg);
    }



    @Override
    public void showErrorView() {

    }

    @Override
    public void toMainAct() {
        //跳转到主界面
        HomeActivity.show(activity);
        activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
        activity.finish();
    }

    @Override
    public void toRegisterAct() {
        RegistActivtiy.show(activity);//注册界面

    }

    @Override
    public void toForgetPswAct() {
        ResetPasswordActvitiy.show(activity);//忘记密码界面

    }

    @Override
    public void showDialogs(int code, String message) {

    }

    @Override
    public void toOffice() {
        OfficeActivity.show(activity);//调到离线界面
        activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
        activity.finish();
    }
}
