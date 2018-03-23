package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/6.
 */

public class LoginPost {

    private String username;
    private String pwd;
    private String mac;//上次登录的mac，pc端不传
    private int logintype;//登录方式：0手机，1pc
    private int  versiontype=2;//	int	是	版本类型：1-IOS，2-android，3-pc
    private String  version	;//	是	软件版本号
    private String  mobiletype	;//	是	手机型号
    private String   remark	;//	是	备注

    public int getVersiontype() {
        return versiontype;
    }

    public void setVersiontype(int versiontype) {
        this.versiontype = versiontype;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMobiletype() {
        return mobiletype;
    }

    public void setMobiletype(String mobiletype) {
        this.mobiletype = mobiletype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getLogintype() {
        return logintype;
    }

    public void setLogintype(int logintype) {
        this.logintype = logintype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public LoginPost(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
}
