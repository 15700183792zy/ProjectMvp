package www.zhouyan.project.retrofit;

import android.app.Activity;

import rx.functions.Func1;
import www.zhouyan.project.app.MyApplication;


/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型, 也就是Data部分的数据类型
 */
public class HttpResultFuncAll<T> implements Func1<GlobalResponse, GlobalResponse<T>> {

    private Activity activity;

    public HttpResultFuncAll() {

    }

    public HttpResultFuncAll(Activity activity) {
        this.activity = activity;
    }

    @Override
    public GlobalResponse call(GlobalResponse httpResult) {
        return httpResult;
        //throw new ApiException(httpResult.code, httpResult.message);
    }
}