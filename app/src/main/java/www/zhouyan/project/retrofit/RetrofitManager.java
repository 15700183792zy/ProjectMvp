package www.zhouyan.project.retrofit;


import android.text.TextUtils;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.manager.ConstantManager;
import www.zhouyan.project.utils.NetWorkUtils;
import www.zhouyan.project.utils.ToolFile;

/**
 * Title : 接口BasePath定义
 * Author : zhouyan
 */
public class RetrofitManager {

//    public static final String api = ConstantManager.API;


    // public static final long CONNECT_TIME = 8000;
    public static final long CONNECT_TIME = 120;

    private Retrofit.Builder retrofit;
    private OkHttpClient client;
    private ApiService apiService, apiService2, apiServicePic, apiServiceWX, apiServiceMobile;
    private ApiService apiServiceKDN;

    public ApiService getApiServiceKDN() {
        return apiServiceKDN;
    }


    /**
     * MD5 混合加密秘钥
     */
    public static final String mMD5Key = "";
    /**
     * 请求协议参数
     */

    public static String authorization;

    /**
     * @param params 进行URLEncoder
     */
    public JSONObject setParamsURLEncoder(JSONObject params) {
        try {
            JSONObject obj = new JSONObject();
            Iterator<?> it = params.keys();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = params.getString(key);
                obj.put(key, URLEncoder.encode(value, "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * @param params 进行URLEncoder
     */
    public ArrayList<String> setParamsURLEncoder(ArrayList<String> params) {
        try {
            for (String string : params) {
                URLEncoder.encode(string, "utf-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 添加协议参数 跟在url后面
     */
    /*public static void appendUrlParams(TreeMap<String, String> paramsMap) {
        paramsMap.put(clientCategoryKey, 4+"");
        paramsMap.put(clientVersionKey, version+"");
     //   Log.e("-->ver=",version);
        paramsMap.put(sessionIdKey, sesstions);
       // Log.e("=========session===",sesstions);
    }*/


    /**
     * @param paramsMap
     * @return 协议拼接值
     * 获取协议的md5值
     */
    public static void getParamsSign(TreeMap<String, String> paramsMap) {
        StringBuilder sb = new StringBuilder();
//        StringBuilder params = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getKey()).append(entry.getValue());
//                    params.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "utf-8")).append("&");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        paramsMap.put(sign, ToolMd5.getMD5Sign(sb.toString(), mMD5Key));
    }

    private RetrofitManager() {
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }

    //获取单例
    public static RetrofitManager getInstance() {
       /* if(version==null) version = www.zhouyan.project.utils.ToolSysEnv.getVersionName();
        if(sesstions==null) sesstions = www.zhouyan.project.utils.ToolFile.getString(ConstantManager.SP_USER_SESSION);*/
        return SingletonHolder.INSTANCE;
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = RxManager.createApi(ApiService.class);
        }
        return apiService;
    }

    public ApiService getApiService(String api) {
        if (api == null) {
            api = ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "api");
        }

        if (apiService2 == null) {
            apiService2 = RxManager.createApi(ApiService.class, api);
        }
        return apiService2;
    }

    public ApiService getApiServicePic(String api) {
        if (apiServicePic == null) {
            apiServicePic = RxManager.createApi(ApiService.class, api);
        }
        return apiServicePic;
    }

    public ApiService getApiServiceWX(String api) {
        if (apiServiceWX == null) {
            apiServiceWX = RxManager.createApi(ApiService.class, api);
        }
        return apiServiceWX;
    }

    public ApiService getApiServiceKDN(String api) {
        if (apiServiceKDN == null) {
            apiServiceKDN = RxManager.createApi(ApiService.class, api);
        }
        return apiServiceKDN;
    }

    //获取手机验证码
    public ApiService getApiServiceMobile() {
        if (apiServiceMobile == null) {
            apiServiceMobile = RxManager.createApi(ApiService.class, "http://apis.juhe.cn/");
        }
        return apiServiceMobile;
    }

    public Retrofit.Builder getBuilder() {
        if (retrofit == null) {
            synchronized (RetrofitManager.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder();
                }
            }
        }
        return retrofit;
    }

    public OkHttpClient getClient() {

        if (client == null) {
            synchronized (RetrofitManager.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .cache(new Cache(new File(ConstantManager.cachePath), 1024 * 1024 * 50))
                            .retryOnConnectionFailure(true) //方法为设置出现错误进行重新连接。
                            .connectTimeout(CONNECT_TIME, TimeUnit.SECONDS) //设置超时时间 2s
                            .readTimeout(CONNECT_TIME, TimeUnit.SECONDS) //读取时间2s
                            .addInterceptor(new SignInterceptor())//拦截器 添加的是aplication拦截器，他只会在response被调用一次
                            .addNetworkInterceptor(new HeadInterceptor()) //添加的是网络拦截器，他会在在request和resposne是分别被调用一次，
                            .addInterceptor(new MyHttpLoggingInterceptor().setLevel(MyHttpLoggingInterceptor.Level.BODY))
                            .addInterceptor(new CacheInterceptor())
                            .build();
                }
            }
        }
        return client;
    }


    public Retrofit getRetrofit(String api) {
        return getBuilder()
                .baseUrl(api)
                .client(getClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //rxjava 异步消息传递监听
                .addConverterFactory(GsonConverterFactory.create())///gson解析
                .build();
    }

    public Retrofit getRetrofit() {
        return getBuilder()
                .baseUrl(ConstantManager.API)
                .client(getClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}

//添加的是网络拦截器
class HeadInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request authorised;
        Request originalRequest = null;

        originalRequest = chain.request();
        authorised = originalRequest.newBuilder()
                .build();


        return chain.proceed(authorised);
    }
}


//缓存
class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //获取网络状态
        int netWorkState = NetWorkUtils.getNetworkState(MyApplication.getInstance());
        //无网络, 请求强制使用缓存
        if (netWorkState == NetWorkUtils.NETWORN_NONE) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        Response originalResponse = chain.proceed(request);

        switch (netWorkState) {
            case NetWorkUtils.NETWORN_MOBILE://mobile network 情况下缓存一分钟
                int maxAge = 60;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();

            case NetWorkUtils.NETWORN_WIFI://wifi network 情况下不使用缓存
                maxAge = 0;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();

            case NetWorkUtils.NETWORN_NONE://none network 情况下离线缓存4周
                int maxStale = 60 * 60 * 24 * 4 * 7;
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            default:
                throw new IllegalStateException("network state  is Erro!");
        }
    }
}

//拦截器
class SignInterceptor implements Interceptor {
    private TreeMap<String, String> paramsMap;

    public SignInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        paramsMap = new TreeMap<>();

        //添加协议参数
        //RetrofitManager.appendUrlParams(paramsMap);

        if (oldRequest.url().queryParameterNames() != null && oldRequest.url().queryParameterNames().size() > 0) {
            for (String key : oldRequest.url().queryParameterNames()) {
                paramsMap.put(key, oldRequest.url().queryParameter(key));
            }
        }


        //获取sign
        RetrofitManager.getParamsSign(paramsMap);
        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());
        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .addHeader("accept", "*/*")
                .addHeader("connection", "Keep-Alive")
                .addHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                .addHeader("lsVersion", "Android_" + ToolFile.getString(ConstantManager.SP_USER_VERSION))
                .addHeader("authorization", ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "authorization"))
                .build();
        return chain.proceed(newRequest);
    }
}