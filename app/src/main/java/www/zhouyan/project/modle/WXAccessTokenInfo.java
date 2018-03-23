package www.zhouyan.project.modle;

/**
 * Created by mac on 17/11/17.
 */

public class WXAccessTokenInfo {
    /**
     * access_token : 3_77w1yNTbp2NwGlcyUZQc8PZLLlQn-hAxry03XxS3mzIase4oM4GT1WB-MRmLE-QiYJ7BUgoSxfPInPtI_1f2skjBZutIky4WwVTvyeJZpgw
     * expires_in : 7200
     * refresh_token : 3_J49dUfdct9Xh-idZ-PaPUmr57Yj4EqExQhQ1d2jXLUWg8Wb7wSHUAli0esZ0SaitH7OzvDCbbdrjKuwUOg0Zhs19i7qjlfqV9I64Dr__mpQ
     * openid : oNwvU0sGqoEdviRvblIZ6e_aD1hk
     * scope : snsapi_userinfo
     * unionid : onnJ4xK4EYwQTZMjIxcEJKtVvB60
     */

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Override
    public String toString() {
        return "WXAccessTokenInfo{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
