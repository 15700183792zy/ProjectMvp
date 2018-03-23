package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 */

public class Company {
    private String mobile	;//是	手机号
    private String icode;//是	验证码
    private  int cid	;//是	行业
    private String cname;//	是	公司名称
    private String   pwd;//是	密码


    public Company() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
