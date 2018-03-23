package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by mac on 17/11/12.
 */

public class ClientShopList implements Serializable{
    private String sguid;
    private String sname;
    private double initamount;
    private double balance;
    private boolean isselect;
    private double shopbalance;

    public double getShopbalance() {
        return shopbalance;
    }

    public void setShopbalance(double shopbalance) {
        this.shopbalance = shopbalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInitamount() {
        return initamount;
    }

    public void setInitamount(double initamount) {
        this.initamount = initamount;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public boolean isIsselect() {
        return isselect;
    }

    public void setIsselect(boolean isselect) {
        this.isselect = isselect;
    }
}
