package www.zhouyan.project.modle;

/**
 * Created by mac on 18/1/24.
 */

public class DataInit {
    private String icode;//	string	是	验证码
    private boolean clearshop;//	boolen	是	清除门店
    private boolean clearuser	;//boolen	是	清除员工
    private boolean  clearcustomer;//	boolen	是	清除客户
    private boolean  clearsupplier;//	boolen	是	清除供应商
    private boolean  clearproduct;//	boolen	是	清除产品
    private boolean   clearfee	;//boolen	是	清除费用科目

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public boolean isClearshop() {
        return clearshop;
    }

    public void setClearshop(boolean clearshop) {
        this.clearshop = clearshop;
    }

    public boolean isClearuser() {
        return clearuser;
    }

    public void setClearuser(boolean clearuser) {
        this.clearuser = clearuser;
    }

    public boolean isClearcustomer() {
        return clearcustomer;
    }

    public void setClearcustomer(boolean clearcustomer) {
        this.clearcustomer = clearcustomer;
    }

    public boolean isClearsupplier() {
        return clearsupplier;
    }

    public void setClearsupplier(boolean clearsupplier) {
        this.clearsupplier = clearsupplier;
    }

    public boolean isClearproduct() {
        return clearproduct;
    }

    public void setClearproduct(boolean clearproduct) {
        this.clearproduct = clearproduct;
    }

    public boolean isClearfee() {
        return clearfee;
    }

    public void setClearfee(boolean clearfee) {
        this.clearfee = clearfee;
    }
}
