package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/9/6.
 */

public class DateOrderList {

    private SummaryinfoBean summaryinfo;
    private ArrayList<OrderList> orderlists;

    public ArrayList<OrderList> getOrderlists() {
        return orderlists;
    }

    public void setOrderlists(ArrayList<OrderList> orderlists) {
        this.orderlists = orderlists;
    }

    public SummaryinfoBean getSummaryinfo() {
        return summaryinfo;
    }

    public void setSummaryinfo(SummaryinfoBean summaryinfo) {
        this.summaryinfo = summaryinfo;
    }

    public static class SummaryinfoBean {


        private int count;
        private double totalamount;
        private double actamount;
        private double owing;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getTotalamount() {
            return totalamount;
        }

        public void setTotalamount(double totalamount) {
            this.totalamount = totalamount;
        }

        public double getActamount() {
            return actamount;
        }

        public void setActamount(double actamount) {
            this.actamount = actamount;
        }

        public double getOwing() {
            return owing;
        }

        public void setOwing(double owing) {
            this.owing = owing;
        }
    }


}


