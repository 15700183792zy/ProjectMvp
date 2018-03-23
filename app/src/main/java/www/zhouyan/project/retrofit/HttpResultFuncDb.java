package www.zhouyan.project.retrofit;


import android.app.Activity;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.functions.Func1;


/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型, 也就是Data部分的数据类型
 *
 *           获取数据库 。。
 */
public class HttpResultFuncDb<T> implements Func1<Response, Response<T>> {

    private Activity activity;

    public HttpResultFuncDb() {

    }

    public HttpResultFuncDb(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Response<T> call(Response httpResult) {
        return httpResult;
        //throw new ApiException(httpResult.code, httpResult.message);
    }


}