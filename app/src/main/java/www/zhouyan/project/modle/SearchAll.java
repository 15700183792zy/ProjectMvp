package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/21.
 */

public class SearchAll {

    private int type;//1产品, 2客户, 3供应商
    private String name;
    private String lguid;//客户等级
    private String guid;//id
    private int rebate;//折扣
    private String itemno;
    private String areanamefull;
    private String contractmobile;
    private String mobile;
    public boolean flag;
    private double balance;
    public boolean isFlag() {
        return flag;
    }

    public String getLguid() {
        return lguid;
    }

    public void setLguid(String lguid) {
        this.lguid = lguid;
    }

    public int getRebate() {
        return rebate;
    }

    public void setRebate(int rebate) {
        this.rebate = rebate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getAreanamefull() {
        return areanamefull;
    }

    public void setAreanamefull(String areanamefull) {
        this.areanamefull = areanamefull;
    }

    public String getContractmobile() {
        return contractmobile;
    }

    public void setContractmobile(String contractmobile) {
        this.contractmobile = contractmobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
