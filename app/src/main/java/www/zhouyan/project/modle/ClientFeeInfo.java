package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/7.
 */

public class ClientFeeInfo {

    private String cguid;
    private String clientguid;
    private String fguid;
    private String fname;
    private String clientname;
    private double curramount;
    private double amount;
    private double balanceamount;
    private String remark;
    private String mobile;
    private String uname;
    private String opttime;
    private int id;

    private double currshopamount;
    private double balanceshopamount;
    private String sname;//门店名称
    private String sguid;//门店guid

    private String feedate;
    private int feeorder;//101表示期初设置

    public String getFeedate() {
        return feedate;
    }

    public void setFeedate(String feedate) {
        this.feedate = feedate;
    }

    public int getFeeorder() {
        return feeorder;
    }

    public void setFeeorder(int feeorder) {
        this.feeorder = feeorder;
    }

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
    public double getCurrshopamount() {
        return currshopamount;
    }

    public void setCurrshopamount(double currshopamount) {
        this.currshopamount = currshopamount;
    }

    public double getBalanceshopamount() {
        return balanceshopamount;
    }

    public void setBalanceshopamount(double balanceshopamount) {
        this.balanceshopamount = balanceshopamount;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }

    public String getFguid() {
        return fguid;
    }

    public void setFguid(String fguid) {
        this.fguid = fguid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public double getCurramount() {
        return curramount;
    }

    public void setCurramount(double curramount) {
        this.curramount = curramount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceamount() {
        return balanceamount;
    }

    public void setBalanceamount(double balanceamount) {
        this.balanceamount = balanceamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getOpttime() {
        return opttime;
    }

    public void setOpttime(String opttime) {
        this.opttime = opttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
