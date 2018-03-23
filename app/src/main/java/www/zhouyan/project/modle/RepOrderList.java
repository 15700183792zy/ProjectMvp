package www.zhouyan.project.modle;

/**
 * Created by mac on 17/9/7.
 */

public class RepOrderList {

    private String oguid;
    private String clientname;
    private String orderdate;
    private String ordername;
    private String salename;
    private String sname;
    private int totalquantity;
    private double totalamount;
    private double actamount;
    private double gainamount;
    private String orderno;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOguid() {
        return oguid;
    }

    public void setOguid(String oguid) {
        this.oguid = oguid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getSalename() {
        return salename;
    }

    public void setSalename(String salename) {
        this.salename = salename;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public double getActamount() {
        return actamount;
    }

    public void setActamount(double actamount) {
        this.actamount = actamount;
    }

    public double getGainamount() {
        return gainamount;
    }

    public void setGainamount(double gainamount) {
        this.gainamount = gainamount;
    }
}
