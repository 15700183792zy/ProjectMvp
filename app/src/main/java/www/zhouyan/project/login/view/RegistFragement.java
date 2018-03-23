package www.zhouyan.project.login.view;

import android.graphics.Color;
import android.os.Build;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import www.zhouyan.project.R;
import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.base.BaseFragmentV4;
import www.zhouyan.project.base.TitleView;
import www.zhouyan.project.home.view.HomeActivity;
import www.zhouyan.project.login.presenter.RegistPresenter;
import www.zhouyan.project.modle.CategoryList;
import www.zhouyan.project.modle.Company;
import www.zhouyan.project.utils.StatusBarUtil;
import www.zhouyan.project.utils.ToolDialog;
import www.zhouyan.project.utils.ToolPhoneEmail;
import www.zhouyan.project.widget.edittext.ClearEditText;

/**
 * Created by mac on 18/3/21.
 */

public class RegistFragement extends BaseFragmentV4 implements IRegistView {


    RegistPresenter registPresenter;
    Company company;
    @BindView(R.id.tv_regist_trade)
    TextView tv_regist_trade;
    @BindView(R.id.ll_trade_all)
    LinearLayout llTrade;
    @BindView(R.id.met_cname)
    ClearEditText metCname;
    @BindView(R.id.met_reset_phone)
    ClearEditText metResetPhone;
    @BindView(R.id.met_reset_password)
    ClearEditText metResetPassword;
    @BindView(R.id.met_phone_no)
    ClearEditText metPhoneNo;
    @BindView(R.id.bt_get)
    TextView btGet;
    @BindView(R.id.bt_regist)
    Button btRegist;
    @BindView(R.id.cb_check)
    CheckBox cb_check;
    @BindView(R.id.iv_check)
    ImageView ivCheck;
    @BindView(R.id.tv_regist)
    TextView tvRegist;
    @BindView(R.id.ll_refis)
    LinearLayout ll_refis;

    int cid = -1;

    public RegistFragement() {
        super();
    }

    public static RegistFragement newInstance() {
        RegistFragement fragment = new RegistFragement();
        return fragment;
    }


    @Override
    public boolean isActionBusiness() {
        return false;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_regist;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        registPresenter = new RegistPresenter(this);
        View view_bottom = getTitleView(TitleView.view_bottom);
        view_bottom.setVisibility(View.GONE);

        // 生成一个状态栏大小的矩形
        View statusView = BaseActivity.createStatusView(activity, Color.WHITE);
        // 添加 statusView 到布局中
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        decorView.addView(statusView);

        if (Build.VERSION.SDK_INT >= 19) {//4.4 之上
            int type = StatusBarUtil.StatusBarLightMode(activity);
            StatusBarUtil.StatusBarLightMode(activity, type);
        } else {
            StatusBarUtil.transparencyBar(activity);
        }
        ll_refis.setVisibility(View.VISIBLE);
        tvRegist.setText("我已阅读并同意《服务协议和隐私政策》");


        company = new Company();
        cb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.d(TAG, "onCheckedChanged: "+isChecked);
                if (isChecked) {
                    //选择状态 显示明文--设置为可见的密码
                    metResetPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    metResetPassword.setSelection(metResetPassword.getText().toString().length());
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    metResetPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    metResetPassword.setSelection(metResetPassword.getText().toString().length());
                }
            }
        });
    }

    @Override
    public void showMessage(String msg) {
        ToolDialog.dialogShow(activity, msg);
    }


    @Override
    public void showErrorView() {

    }

    @Override
    public void showDialogs(int code, String message) {
        ToolDialog.dialogShow(activity, code, message);
    }

    @Override
    public void toMainAct() {
        //跳转到主界面
        HomeActivity.show(activity);
        activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
        activity.finish();
    }

    @Override
    public void setCategoryList(ArrayList<CategoryList> categoryLists2) {
        this.categoryLists = categoryLists2;
        String tx = categoryLists.get(0).getPickerViewText();
        if (tv_regist_trade != null) tv_regist_trade.setText(tx);
        company.setCid(categoryLists.get(0).getId());
        cid = company.getCid();
        //执行选择界面
        selectorCategory(categoryLists);

    }

    private OptionsPickerView pvCustomOptions;

    private void selectorCategory(ArrayList<CategoryList> categoryLists) {
        //条件选择器
        if (pvCustomOptions == null) initCustomOptionPicker(categoryLists);

        if (pvCustomOptions != null) {
            //pvCustomOptions.setPicker(options1Items)
            pvCustomOptions.show();
        }
    }

    private void initCustomOptionPicker(final ArrayList<CategoryList> categoryLists) {//条件选择器初始化, 自定义布局
        /**
         * @description
         *
         * 注意事项:
         * 自定义布局中, id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有, 否则会报空指针。
         * 具体可参考demo 里面的两个自定义layout布局。
         */
        pvCustomOptions = new OptionsPickerView.Builder(activity, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = categoryLists.get(options1).getPickerViewText();
                tv_regist_trade.setText(tx);
                company.setCid(categoryLists.get(options1).getId());
                cid = company.getCid();
            }
        }).setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
            @Override
            public void customLayout(View v) {
                final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                TextView tv_cancel = (TextView) v.findViewById(R.id.tv_cancel);
                tvSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvCustomOptions.returnData();
                        pvCustomOptions.dismiss();
                    }
                });

                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pvCustomOptions.dismiss();
                    }
                });

            }
        })
                .isDialog(true)
                .build();

        pvCustomOptions.setPicker(categoryLists);//添加数据

    }


    @Override
    public void getCode(boolean code) {

    }

    private static final int SECOND = 60;

    private void countDownTime() {
        Observable.interval(1, TimeUnit.SECONDS,
                AndroidSchedulers.mainThread()).take(SECOND)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        try {
                            RxView.enabled(btGet).call(false);
                            RxTextView.text(btGet).call("剩余" + (SECOND - aLong) + "秒");
                            btGet.setBackgroundResource(R.drawable.bg_login_shape_b2b2b2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onCompleted() {
                        try {
                            RxTextView.text(btGet).call("重新发送");
                            RxView.enabled(btGet).call(true);
                            btGet.setBackgroundResource(R.drawable.bg_login_shape);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private ArrayList<CategoryList> categoryLists=null;
    int check = 1;

    @OnClick({R.id.ll_trade_all, R.id.bt_get, R.id.bt_regist, R.id.tv_back, R.id.tv_regist, R.id.iv_check})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_regist:
                //跳转加载协议
//                Intent intent = new Intent(activity,ProtocolActivity.class);
//                activity.overridePendingTransition(R.anim.layout_next_in, R.anim.layout_next_out);
//                startActivity(intent);
                break;
            case R.id.iv_check:
                check++;
                check = check % 2;
                if (check == 1) {
                    ivCheck.setImageResource(R.drawable.icon_checked);
                } else {
                    ivCheck.setImageResource(R.drawable.icon_check_notyet);
                }
                break;
            case R.id.tv_back:
                activity.overridePendingTransition(R.anim.layout_pre_in, R.anim.layout_pre_out);
                activity.finish();
                break;
            case R.id.ll_trade_all:
                //行业 CategoryList
                if (categoryLists == null ||categoryLists.size()==0) {
                    registPresenter.categoryList(activity);
                } else {
                    //执行选择界面
                    selectorCategory(categoryLists);
                }
                break;
            case R.id.bt_get:

//                验证手机号是否正确
                if (ToolPhoneEmail.isMobileNO(metResetPhone.getText().toString().trim())) { //电话号码 格式判断
                    countDownTime();
                    registPresenter.code(metResetPhone.getText().toString(), activity);
                } else {
                    showMessage("你输入的电话号码格式不正确");
                }

                break;
            case R.id.bt_regist:

                company.setMobile(metResetPhone.getText().toString().trim());//手机号
                company.setPwd(metResetPassword.getText().toString().trim());//密码
                company.setIcode(metPhoneNo.getText().toString().trim());//验证码
                company.setCname(metCname.getText().toString().trim());//公司名
                if (TextUtils.isEmpty(metResetPhone.getText().toString().trim())) {
                    showMessage("手机号不能为空");
                } else if (!ToolPhoneEmail.isMobileNO(metResetPhone.getText().toString().trim())) {
                    showMessage("手机号格式不争取");
                } else if (TextUtils.isEmpty(metResetPassword.getText().toString().trim())) {
                    showMessage("密码不能为空");
                } else if (TextUtils.isEmpty(metPhoneNo.getText().toString().trim())) {
                    showMessage("验证码不能为空");
                } else if (TextUtils.isEmpty(metCname.getText().toString().trim())) {
                    showMessage("公司名不能为空");
                } else if (cid == -1) {
                    showMessage("请选择行业类别");
                } else {
                    if (check == 1) {
                        registPresenter.regist(company, activity);
                    } else {
                        showMessage("请先阅读协议");
                    }
                }

                break;
        }
    }

}
