package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/9/5.
 */

public class OrderReport {

    private SummaryBean summary;
    private ArrayList<DetailsBean> details;
    private int totalcount; //总条数

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public SummaryBean getSummary() {
        return summary;
    }

    public void setSummary(SummaryBean summary) {
        this.summary = summary;
    }

    public ArrayList<DetailsBean> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<DetailsBean> details) {
        this.details = details;
    }

    public static class SummaryBean {

        private int totalcount; //款数
        private int totalquantity;
        private double totalamount;
        private double gainamount;

        public int getTotalcount() {
            return totalcount;
        }

        public void setTotalcount(int totalcount) {
            this.totalcount = totalcount;
        }

        public int getTotalquantity() {
            return totalquantity;
        }

        public void setTotalquantity(int totalquantity) {
            this.totalquantity = totalquantity;
        }

        public double getTotalamount() {
            return totalamount;
        }

        public void setTotalamount(double totalamount) {
            this.totalamount = totalamount;
        }

        public double getGainamount() {
            return gainamount;
        }

        public void setGainamount(double gainamount) {
            this.gainamount = gainamount;
        }
    }

    public static class DetailsBean {

        private String guid;
        private String name;
        private int quantity;
        private double amount;
        private double gainamount;
        private ArrayList<ColorsizesBean> colorsizes;
        public boolean flag;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getGainamount() {
            return gainamount;
        }

        public void setGainamount(double gainamount) {
            this.gainamount = gainamount;
        }

        public ArrayList<ColorsizesBean> getColorsizes() {
            return colorsizes;
        }

        public void setColorsizes(ArrayList<ColorsizesBean> colorsizes) {
            this.colorsizes = colorsizes;
        }

        public static class ColorsizesBean {
            private String guid;
            private String colorname;
            private String sizename;
            private int quantity;
            private double amount;
            private double gainamount;

            public String getGuid() {
                return guid;
            }

            public void setGuid(String guid) {
                this.guid = guid;
            }

            public String getColorname() {
                return colorname;
            }

            public void setColorname(String colorname) {
                this.colorname = colorname;
            }

            public String getSizename() {
                return sizename;
            }

            public void setSizename(String sizename) {
                this.sizename = sizename;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public double getGainamount() {
                return gainamount;
            }

            public void setGainamount(double gainamount) {
                this.gainamount = gainamount;
            }
        }
    }
}
