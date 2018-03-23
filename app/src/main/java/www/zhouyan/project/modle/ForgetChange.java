package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/6.
 * <p>
 * 忘记密码
 */
public class ForgetChange {

    private String mobile;
    private String pwd;
    private String icode;

    public ForgetChange(String mobile, String pwd, String icode) {
        this.mobile = mobile;
        this.pwd = pwd;
        this.icode = icode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }
}
