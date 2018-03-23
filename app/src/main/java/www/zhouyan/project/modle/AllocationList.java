package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/10/17.
 */

public class AllocationList {

    private OnwayinfoBean onwayinfo;
    private ArrayList<AllocationinfosBean> allocationinfos;

    public OnwayinfoBean getOnwayinfo() {
        return onwayinfo;
    }

    public void setOnwayinfo(OnwayinfoBean onwayinfo) {
        this.onwayinfo = onwayinfo;
    }

    public ArrayList<AllocationinfosBean> getAllocationinfos() {
        return allocationinfos;
    }

    public void setAllocationinfos(ArrayList<AllocationinfosBean> allocationinfos) {
        this.allocationinfos = allocationinfos;
    }

    public static class OnwayinfoBean {
     

        private int totalcount;
        private int onwaycount;//调入在途的单据个数

        public int getTotalcount() {
            return totalcount;
        }

        public void setTotalcount(int totalcount) {
            this.totalcount = totalcount;
        }

        public int getOnwaycount() {
            return onwaycount;
        }

        public void setOnwaycount(int onwaycount) {
            this.onwaycount = onwaycount;
        }
    }

    public static class AllocationinfosBean {
       

        private int id;
        private String orderid;
        private String orderno;
        private int ordertype;
        private String fromname;
        private String toname;
        private String orderdate;
        private int totalquantity;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getOrderno() {
            return orderno;
        }

        public void setOrderno(String orderno) {
            this.orderno = orderno;
        }

        public int getOrdertype() {
            return ordertype;
        }

        public void setOrdertype(int ordertype) {
            this.ordertype = ordertype;
        }

        public String getFromname() {
            return fromname;
        }

        public void setFromname(String fromname) {
            this.fromname = fromname;
        }

        public String getToname() {
            return toname;
        }

        public void setToname(String toname) {
            this.toname = toname;
        }

        public String getOrderdate() {
            return orderdate;
        }

        public void setOrderdate(String orderdate) {
            this.orderdate = orderdate;
        }

        public int getTotalquantity() {
            return totalquantity;
        }

        public void setTotalquantity(int totalquantity) {
            this.totalquantity = totalquantity;
        }
    }
}
