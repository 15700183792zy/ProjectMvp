package www.zhouyan.project.modle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhouyan on 17/7/6.\
 *
 */

public class AccountFlow implements Serializable{

    private double inamount;
    private double outamount;
    private double amount;//"收款或者打款金额",
    private double orderamount;//"订单总额",
    private double initamount;//"期初金额, 流水账用",
    private double balanceamount;//"当前余额, 对账单用",
    private ArrayList<FeesBean> fees;
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(double orderamount) {
        this.orderamount = orderamount;
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

    public double getInamount() {
        return inamount;
    }

    public void setInamount(double inamount) {
        this.inamount = inamount;
    }

    public double getOutamount() {
        return outamount;
    }

    public void setOutamount(double  outamount) {
        this.outamount = outamount;
    }

    public ArrayList<FeesBean> getFees() {
        return fees;
    }

    public void setFees(ArrayList<FeesBean> fees) {
        this.fees = fees;
    }

    public static class FeesBean implements Serializable{
        private String sname;//"账户名称",
        private String shopname;//门店名称
        private String fname;//费用名称
        private int feetype; //收入 1, 支出 2
        private double curramount;
        private double amount;
        private double balanceamount;
        private String opttime;//操作时间
        private int id;
        private double orderamount;//订单金额
        private String feedate;//发生时间
        private String orderid;//单据id
        private String orderno;//"单据号",
        private double payamount;//单据支付金额
        private  boolean iscancelorder;//是否是撤销单

        public boolean iscancelorder() {
            return iscancelorder;
        }

        public void setIscancelorder(boolean iscancelorder) {
            this.iscancelorder = iscancelorder;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public double getPayamount() {
            return payamount;
        }

        public void setPayamount(double payamount) {
            this.payamount = payamount;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getFeedate() {
            return feedate;
        }

        public void setFeedate(String feedate) {
            this.feedate = feedate;
        }

        public double getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(double orderamount) {
            this.orderamount = orderamount;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public int getFeetype() {
            return feetype;
        }

        public void setFeetype(int feetype) {
            this.feetype = feetype;
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

        @Override
        public String toString() {
            return "FeesBean{" +
                    "sname='" + sname + '\'' +
                    ", fname='" + fname + '\'' +
                    ", feetype=" + feetype +
                    ", curramount=" + curramount +
                    ", amount=" + amount +
                    ", balanceamount=" + balanceamount +
                    ", opttime='" + opttime + '\'' +
                    ", id=" + id +
                    ", orderamount=" + orderamount +
                    ", feedate='" + feedate + '\'' +
                    ", orderid='" + orderid + '\'' +
                    ", orderno='" + orderno + '\'' +
                    ", payamount=" + payamount +
                    '}';
        }
    }
}
