package www.zhouyan.project.modle;

/**
 * Created by 周岩 on 17/7/6.
 */

public class AccountInfo {
    private String cguid;
    private String guid;
    private String sguid;
    private String sname;
    private int orderno;//排序 默认 0
    private String name;//
    private String bankaccount;//账号
    private String openbank;//开户银行
    private String bankname;//银行名称
    private int accounttype;  //账户类型 现金1 银行卡2 支付宝3 微信4 其他5
    private double initamount;//初始金额
    private double balanceamount;//当前余额
    private boolean isstop;
    private String remark;//备注
    private boolean deleteflag;//删除标记
    private int id;
    private boolean isprint;//是否打印账户信息

    public boolean isprint() {
        return isprint;
    }

    public void setIsprint(boolean isprint) {
        this.isprint = isprint;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getOpenbank() {
        return openbank;
    }

    public void setOpenbank(String openbank) {
        this.openbank = openbank;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public int getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(int accounttype) {
        this.accounttype = accounttype;
    }

    public double getInitamount() {
        return initamount;
    }

    public void setInitamount(double initamount) {
        this.initamount = initamount;
    }

    public double getBalanceamount() {
        return balanceamount;
    }

    public void setBalanceamount(double balanceamount) {
        this.balanceamount = balanceamount;
    }

    public boolean isIsstop() {
        return isstop;
    }

    public void setIsstop(boolean isstop) {
        this.isstop = isstop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
