package www.zhouyan.project.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import www.zhouyan.project.utils.ToolAlert;

/**
 * 微信客户端回调activity示例
 * <p>
 * 作者：JerryloveEmily
 * 链接：http://www.jianshu.com/p/d95e4343e231
 * 來源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WXEntryActivity extends WechatHandlerActivity implements IWXAPIEventHandler {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Constants.wx_api.handleIntent(getIntent(), this);
//        Log.e("------WXEntryActivity", Constants.wx_api + "");
    }

    /**
     * 处理微信发出的向第三方应用请求app message
     * <p>
     * 在微信客户端中的聊天页面有“添加工具”, 可以将本应用的图标添加到其中
     * 此后点击图标, 下面的代码会被执行。Demo仅仅只是打开自己而已, 但你可
     * 做点其他的事情, 包括根本不打开任何页面
     */
    public void onGetMessageFromWXReq(WXMediaMessage msg) {
        if (msg != null) {
//            Log.e("------WXEntryActivity-1", ToolGson.toJson(msg));
            Intent iLaunchMyself = getPackageManager().getLaunchIntentForPackage(getPackageName());
            startActivity(iLaunchMyself);
        }
    }

    /**
     * 处理微信向第三方应用发起的消息
     * <p>
     * 此处用来接收从微信发送过来的消息, 比方说本demo在wechatpage里面分享
     * 应用时可以不分享应用文件, 而分享一段应用的自定义信息。接受方的微信
     * 客户端会通过这个方法, 将这个信息发送回接收方手机上的本demo中, 当作
     * 回调。
     * <p>
     * 本Demo只是将信息展示出来, 但你可做点其他的事情, 而不仅仅只是Toast
     */
    public void onShowMessageFromWXReq(WXMediaMessage msg) {
//        Log.e("------WXEntryActivity-2", ToolGson.toJson(msg));
        if (msg != null && msg.mediaObject != null
                && (msg.mediaObject instanceof WXAppExtendObject)) {
            WXAppExtendObject obj = (WXAppExtendObject) msg.mediaObject;
            Toast.makeText(this, obj.extInfo, Toast.LENGTH_SHORT).show();
        }
    }

    //微信请求相应   // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq baseReq) {
        //发出请求
    }

    //发送到微信请求的响应结果  // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    @Override
    public void onResp(BaseResp resp) {
//        Log.e("------WXEntryActivity", resp.errCode + "======" + resp.transaction);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                if (resp instanceof SendAuth.Resp) {
//                    Log.e("------WXEntryActivity", "onResp OK");

                    if (resp instanceof SendAuth.Resp) {
                        SendAuth.Resp newResp = (SendAuth.Resp) resp;
                        //获取微信传回的code
                        String code = newResp.code;
//                        Log.e("------WXEntryActivity", "onResp code = " + code);
//                        getAccessToken(code);
                    }

                } else {//否则是分享的回调
//                    ToolAlert.showShortToast("分享成功");
                    finish();
                }
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
//                Log.e("------WXEntryActivity", "onResp ERR_USER_CANCEL ");
                ToolAlert.showShortToast("用户取消。");
                finish();
                //发送取消
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
//                Log.e("------WXEntryActivity", "onResp ERR_AUTH_DENIED");
                //发送被拒绝
                break;
            default:
//                Log.e("------WXEntryActivity", "onResp default errCode " + resp.errCode);
                //发送返回
                break;
        }
        finish();
    }
//
//    /**
//     * 获取授权口令
//     */
//    private void getAccessToken(String code) {
//        // 网络请求获取 access_token
//        RetrofitManager.getInstance().getApiServiceWX(ConstantManager.WX_URL)
//                .access_token(Constants.APP_ID, Constants.APP_SCRET, code, "authorization_code")
//                .enqueue(new Callback<WXAccessTokenInfo>() {
//                    @Override
//                    public void onResponse(Call<WXAccessTokenInfo> call, final Response<WXAccessTokenInfo> response) {
//                        processGetAccessTokenResult(response.body());
//                    }
//
//                    @Override
//                    public void onFailure(Call<WXAccessTokenInfo> call, Throwable t) {
//                        ToolAlert.showShortToast("绑定微信失败。");
//                    }
//                });
//    }
//
//    /**
//     * 处理获取的授权信息结果
//     *
//     * @param response 授权信息结果
//     */
//    private void processGetAccessTokenResult(WXAccessTokenInfo response) {
//////        Log.e("------WXEntryActivity", ToolGson.toJson(response));
////        // 验证获取授权口令返回的信息是否成功
////        if (validateSuccess(response.toString())) {
////            // 保存信息到手机本地
//////            saveAccessInfotoLocation(response);
////            // 获取用户信息
////            getUserInfo(response.getAccess_token(), response.getOpenid());
////        } else {
//////            // 授权口令获取失败，解析返回错误信息
//////           Log.e("------WXEntryActivity", response.toString());
//////            // 提示错误信息
////            ToolAlert.showShortToast("绑定微信失败" + response.getErrmsg()+"。");
////        }
//    }
////
////    //
////    private void getUserInfo(String access_token, String openid) {
//////        String url = "https://api.weixin.qq.com/sns/userinfo?" +
//////                "access_token=" + access_token +
//////                "&openid=" + openid;
////        RetrofitManager.getInstance().getApiServiceWX(ConstantManager.WX_URL)
////                .userinfo(access_token, openid)
////                .enqueue(new Callback<WXUserInfo>() {
////                    @Override
////                    public void onResponse(Call<WXUserInfo> call, final Response<WXUserInfo> response) {
////                        // 解析获取的用户信息
////                        WXUserInfo userInfo = response.body();
////                        save(userInfo);
////                    }
////
////                    @Override
////                    public void onFailure(Call<WXUserInfo> call, Throwable t) {
////                        ToolAlert.showShortToast("获取微信用户信息失败。");
////                    }
////                });
////    }
////
////
////    private void save(WXUserInfo userInfo) {
////        UpDateUserWXInfo upDateUserWXInfo = new UpDateUserWXInfo();
////        String mobile = ToolFile.getString(ConstantManager.SP_USER_NAME);
////        upDateUserWXInfo.setMobile(mobile);
////        upDateUserWXInfo.setHeadimg(userInfo.getHeadimgurl());
////        upDateUserWXInfo.setNickname(userInfo.getNickname());
////        upDateUserWXInfo.setOpenid(userInfo.getOpenid());
////        upDateUserWXInfo.setUnionid(userInfo.getUnionid());
////        ToolFile.putString(mobile + "wxname", userInfo.getNickname());
////        //更新微信信息
////        RetrofitManager.getInstance().toSubscribe(RetrofitManager.getInstance().getApiService().
////                        UpDateUserWXInfo(upDateUserWXInfo)
////                        .map(new HttpResultFuncAll<GlobalResponse>()),
////                new ProgressSubscriber<GlobalResponse<GlobalResponse>>(
////                        new SubscriberOnNextListener<GlobalResponse>() {
////                            @Override
////                            public void onNext(final GlobalResponse response) {
////                                if (response.code == 0) {
////                                    ToolAlert.showShortToast("微信绑定成功。");
////                                    finish();
////                                }
////                            }
////                        }, null, 1));
////    }

    /**
     * 验证是否成功
     *
     * @param response 返回消息
     * @return 是否成功
     */
    private boolean validateSuccess(String response) {
        String errFlag = "errmsg";
        return (errFlag.contains(response) && !"ok".equals(response))
                || (!"errcode".contains(response) && !errFlag.contains(response));
    }
}