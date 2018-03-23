package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/7/17.
 */

public class ProStoreAll{
    private ArrayList<StoresBean> stores;
    private SummaryBean summary;


    public SummaryBean getSummary() {
        return summary;
    }

    public void setSummary(SummaryBean summary) {
        this.summary = summary;
    }

    public ArrayList<StoresBean> getStores() {
        return stores;
    }

    public void setStores(ArrayList<StoresBean> stores) {
        this.stores = stores;
    }

    public static class SummaryBean {

        private int totalcount;
        private int quantity;
        private double amount;

        public int getTotalcount() {
            return totalcount;
        }

        public void setTotalcount(int totalcount) {
            this.totalcount = totalcount;
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
    }

    public static class StoresBean {
        private String pguid;
        private String name;
        private String itemno;
        private String itemnum;
        private String picurl;
        private double cprice;
        private String shortspell;
        private int quantity;
        private double amount;
        private ArrayList<DetailBean> details;
        public boolean flag;
        public ArrayList<DetailBean> getDetails() {
            return details;
        }

        public void setDetails(ArrayList<DetailBean> details) {
            this.details = details;
        }

        public String getPguid() {
            return pguid;
        }

        public void setPguid(String pguid) {
            this.pguid = pguid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getItemno() {
            return itemno;
        }

        public void setItemno(String itemno) {
            this.itemno = itemno;
        }

        public String getItemnum() {
            return itemnum;
        }

        public void setItemnum(String itemnum) {
            this.itemnum = itemnum;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public double getCprice() {
            return cprice;
        }

        public void setCprice(double cprice) {
            this.cprice = cprice;
        }

        public String getShortspell() {
            return shortspell;
        }

        public void setShortspell(String shortspell) {
            this.shortspell = shortspell;
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

        public static class DetailBean {
            private String sname;
            private String colorname;
            private String sizename;
            private int quantity;
            private double amount;

            public String getSname() {
                return sname;
            }

            public void setSname(String sname) {
                this.sname = sname;
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
        }
    }
}
