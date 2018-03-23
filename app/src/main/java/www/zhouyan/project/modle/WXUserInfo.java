package www.zhouyan.project.modle;

import java.util.List;

/**
 * Created by mac on 17/11/17.
 */

public class WXUserInfo {

    /**
     * openid : oNwvU0sGqoEdviRvblIZ6e_aD1hk
     * nickname : 周岩
     * sex : 2
     * language : zh_CN
     * city : Hangzhou
     * province : Zhejiang
     * country : CN
     * headimgurl : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL4KYhMPjXu7qqdg4trKKiaeicDXx6ULXKLjF6sSEwtwxRNc116Ztf0mMGQGvfnDFn2NMuibJsia6pgrg/0
     * privilege : []
     * unionid : onnJ4xK4EYwQTZMjIxcEJKtVvB60
     */

    private String openid;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private String unionid;
    private List<?> privilege;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public List<?> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<?> privilege) {
        this.privilege = privilege;
    }
}
