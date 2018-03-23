package www.zhouyan.project.login.presenter;

import android.app.Activity;

import java.util.ArrayList;

import www.zhouyan.project.base.BaseActivity;
import www.zhouyan.project.base.BasePresenter;
import www.zhouyan.project.login.view.IRegistView;
import www.zhouyan.project.modle.CategoryList;
import www.zhouyan.project.modle.Company;
import www.zhouyan.project.modle.LoginPost;
import www.zhouyan.project.retrofit.GlobalResponse;
import www.zhouyan.project.retrofit.HttpResultFuncAll;
import www.zhouyan.project.retrofit.ProgressSubscriber;
import www.zhouyan.project.retrofit.RetrofitManager;
import www.zhouyan.project.retrofit.SubscriberOnNextListener;

/**
 * Created by mac on 18/3/21.
 */

public class RegistPresenter  {

    IRegistView mView;

    public RegistPresenter(IRegistView mview) {
        this.mView = mview;
    }

    public void code(String message, BaseActivity activity) {
        //获取验证码
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                        GetIdentityCode(message)
                        .map(new HttpResultFuncAll<GlobalResponse>()),
                new ProgressSubscriber<GlobalResponse<GlobalResponse>>(new SubscriberOnNextListener<GlobalResponse>() {
                    @Override
                    public void onNext(final GlobalResponse response) {
                        if (response.code == 0) {
                            //30s后重发
                        } else {
                            mView.showDialogs(response.code, response.message);
                        }
                    }
                }, activity, 0));
    }

    public void regist(final Company company, final BaseActivity activity) {
        //        註冊公司
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                        CreateCompany(company)
                        .map(new HttpResultFuncAll<GlobalResponse>()),
                new ProgressSubscriber<GlobalResponse<GlobalResponse>>(new SubscriberOnNextListener<GlobalResponse>() {
                    @Override
                    public void onNext(final GlobalResponse response) {
                        if (response.code == 0) {
                            LoginPost loginPost = new LoginPost(company.getMobile(), company.getPwd());
                            //调取登录数据
                            LoginPresenter loginPresenter = new LoginPresenter(null);
                            loginPresenter.login(activity,loginPost,0);

                        } else {
                            mView.showDialogs(response.code, response.message);
                        }
                    }
                }, activity, 0));
    }


    public void categoryList(Activity activity){
        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
                                    CategoryList()
                                    .map(new HttpResultFuncAll<GlobalResponse<ArrayList<CategoryList>>>()),
                            new ProgressSubscriber<GlobalResponse<GlobalResponse<ArrayList<CategoryList>>>>(new SubscriberOnNextListener<GlobalResponse<ArrayList<CategoryList>>>() {
                                @Override
                                public void onNext(final GlobalResponse<ArrayList<CategoryList>> response) {
                                    if (response.code == 0) {
                                       mView.setCategoryList(response.data);
                                    } else {
                                        mView.showDialogs(response.code, response.message);
                                    }
                                }
                            }, activity, 0));
    }
}
