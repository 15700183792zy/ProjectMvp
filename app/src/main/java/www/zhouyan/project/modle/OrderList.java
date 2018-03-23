package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/4.
 */

public class OrderList {
    private int id;
    private String clientname;
    private int totalquantity;
    private double actamount;
    private String ordertime;
    private String sname;
    private String orderno;
    private String orderid;
    private String orderdate;
    private double owing;

    public double getOwing() {
        return owing;
    }

    public void setOwing(double owing) {
        this.owing = owing;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    public double getActamount() {
        return actamount;
    }

    public void setActamount(double actamount) {
        this.actamount = actamount;
    }

}
