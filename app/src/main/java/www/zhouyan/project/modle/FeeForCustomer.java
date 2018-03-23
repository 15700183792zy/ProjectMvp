package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/7.
 */

public class FeeForCustomer {
    private String aguid;//	是	account的guid
    private String aname;//是	账号名称
    private double amount;//	是	发生金额
    private String remark;//	是	备注
    private String clientguid;//	是	合作伙伴id
    private String clientname;//	是	合作伙伴名称
    private String feedate;
    private String sname;//门店名称
    private String sguid;//门店guid


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getFeedate() {
        return feedate;
    }

    public void setFeedate(String feedate) {
        this.feedate = feedate;
    }

    public String getAguid() {
        return aguid;
    }

    public void setAguid(String aguid) {
        this.aguid = aguid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
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

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }
}
