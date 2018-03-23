package www.zhouyan.project.manager;

import android.os.Environment;


/**
 * Title : 常量管理
 * Author : zhouyan
 */
public interface ConstantManager {

    /**
     * 访问链接
     */
    String API = "https://g1api.4yankj.cn/";
    /**
     * 分享 webhost
     */
    String webHost = "https://g1.4yankj.cn/";
    /**
     * //调试模式  开发1,测试2 还是上线模式 3
     */
    boolean isDebug = API.trim().equals("https://g3api.4yankj.cn/");
    /**
     * 快递鸟
     * 正式 http://api.kdniao.cc/
     * 测试 http://testapi.kdniao.cc:8081/
     */
    String KDN_URL = "http://testapi.kdniao.cc:8081/";


    //图片上传地址 https://mdapi.zjwist.com/MediaInfo3/Save"
    String UPLOAD_URL = "https://mdapi.zjwist.com/MediaInfo3/";
    int SYSID = 10;
    int MID = 0;

    //微信授权
    //图片地址 https://api.weixin.qq.com/sns/oauth2/access_token"
    String WX_URL = "https://api.weixin.qq.com/sns/";


    /**
     * 全局tag
     */
    String TAG = "PrintSystem";

    /**
     * 全局缓存路径
     */
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/lsjxc/";
    String allNumberZero = "00000000-0000-0000-0000-000000000000";
    /**
     * 缓存路径
     */
    String cachePath = path + "cache/";

    /**
     * 下载路径
     */
    String downloadPath = path + "download/";

    /**
     * 日志路径
     */
    String logPath = path + "log/";
    /**
     * 数据库
     */
    String dataPath = path + "database";

    /**
     * 相机路径
     */
    String cameraPath = path + "camera/";

    /**
     * 刷新
     */
    int onRefresh = 0;

    /**
     * 加载更多
     */
    int onLoadMore = 1;
    String CODE = "UTF-8";
    String SP_USER_NAME = "sp_user_name";
    String SP_USER_PSW = "sp_user_psw";
    String SP_USER_VERSION = "sp_user_version";
    String SP_USER_URL = "sp_user_url";//公司url
    String DATE = "sp_user_date";//单据日期
    String TYPENUMBER_RK = "sp_user_rknumber";
    String TYPENUMBER_XS = "sp_user_xsnumber";
    String TYPENUMBER_PD = "sp_user_pdnumber";
    String TYPENUMBER_DR = "sp_user_drnumber";
    String TYPENUMBER_DC = "sp_user_dcnumber";

    int SUCCESS_REQUEST4 = 130;//其他设备登录后不能自动登录
    int SUCCESS_REQUEST = 0;//请求成功
    int SUCCESS_REQUEST2 = 1107; //未注册
    int SUCCESS_REQUEST3 = 1000;//已在别处登录
    int SUCCESS_REQUEST5 = 1002;//本地数据库需要初始化
    int HANDLERWHAT_PRICE = 1;
}
