package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/7/14.
 */

public class DateSummaryInfo {
    


    private ArrayList<DetailsBean> details;
    private String remark;
    private String sname;
    private String cguid;
    private String sguid;
    private String date;
    private double sellamount;
    private double customerowing;
    private double customerrepay;
    private double otherincome;
    private double supplierpay;
    private double otherpay;
    private double pettyamount;
    private double diffamount;
    private boolean issettle;
    private String guid;
    private String sdate;
    private double inamount;
    private double outamount;
    private int id;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }





    public ArrayList<DetailsBean> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<DetailsBean> details) {
        this.details = details;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSellamount() {
        return sellamount;
    }

    public void setSellamount(double sellamount) {
        this.sellamount = sellamount;
    }

    public double getCustomerowing() {
        return customerowing;
    }

    public void setCustomerowing(double customerowing) {
        this.customerowing = customerowing;
    }

    public double getCustomerrepay() {
        return customerrepay;
    }

    public void setCustomerrepay(double customerrepay) {
        this.customerrepay = customerrepay;
    }

    public double getOtherincome() {
        return otherincome;
    }

    public void setOtherincome(double otherincome) {
        this.otherincome = otherincome;
    }

    public double getSupplierpay() {
        return supplierpay;
    }

    public void setSupplierpay(double supplierpay) {
        this.supplierpay = supplierpay;
    }

    public double getOtherpay() {
        return otherpay;
    }

    public void setOtherpay(double otherpay) {
        this.otherpay = otherpay;
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

    public boolean isIssettle() {
        return issettle;
    }

    public void setIssettle(boolean issettle) {
        this.issettle = issettle;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
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

    public void setOutamount(double outamount) {
        this.outamount = outamount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class DetailsBean {

        private String dguid;
        private String aguid;
        private String aname;
        private double inamount;
        private double outamount;
        private double curramount;
        private int id;

        public String getDguid() {
            return dguid;
        }

        public void setDguid(String dguid) {
            this.dguid = dguid;
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

        public double getInamount() {
            return inamount;
        }

        public void setInamount(double inamount) {
            this.inamount = inamount;
        }

        public double getOutamount() {
            return outamount;
        }

        public void setOutamount(double outamount) {
            this.outamount = outamount;
        }

        public double getCurramount() {
            return curramount;
        }

        public void setCurramount(double curramount) {
            this.curramount = curramount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
