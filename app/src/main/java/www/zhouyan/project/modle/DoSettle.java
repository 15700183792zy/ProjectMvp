package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/14.
 */

public class DoSettle {
    private String guid;
    private double pettyamount;//备用金
    private double diffamount;//差额
    private String remark;
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public double getPettyamount() {
        return pettyamount;
    }

    public void setPettyamount(double pettyamount) {
        this.pettyamount = pettyamount;
    }

    public double getDiffamount() {
        return diffamount;
    }

    public void setDiffamount(double diffamount) {
        this.diffamount = diffamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
