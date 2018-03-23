package www.zhouyan.project.modle;

/**
 * Created by 周岩 on 17/7/7.
 */

public class AccountMutu {
    private String fromguid;//	是	支出的account的guid
    private String fromname;//	是	账号名称
    private String toguid;//	是	收入的account的guid
    private String toname;//是	账号名称
    private double amount;//	是	发生金额
    private String remark;//	是	备注
    private String feedate;//费用日期

    public String getFeedate() {
        return feedate;
    }

    public void setFeedate(String feedate) {
        this.feedate = feedate;
    }

    public String getFromguid() {
        return fromguid;
    }

    public void setFromguid(String fromguid) {
        this.fromguid = fromguid;
    }

    public String getToguid() {
        return toguid;
    }

    public void setToguid(String toguid) {
        this.toguid = toguid;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFromname() {
        return fromname;
    }

    public void setFromname(String fromname) {
        this.fromname = fromname;
    }
}
