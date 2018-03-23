package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/3.
 */

public class OrderUpList {
    private int id;
    private String customername;
    private String clientname;
    private int totalquantity;
    private double actamount;
    private String uptime;
    private String ordertime;

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

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
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

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }
}
