package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by mac on 17/11/29.
 */
@Entity(nameInDb = "orderlist")
public class OrderListTable {
    @Id
    @Property(nameInDb = "id")
    private Long id;
    @Property(nameInDb = "orderno")
    private String orderno;
    @Property(nameInDb = "clientname")
    private String clientname;
    @Property(nameInDb = "totalquantity")
    private int totalquantity;
    @Property(nameInDb = "gactamountuid")
    private double actamount;
    @Property(nameInDb = "orderjson")
    private String orderjson;
    @Property(nameInDb = "state")
    private int state; //0 挂单,1正常
    @Property(nameInDb = "ordertime")
    private String ordertime;
    @Property(nameInDb = "sname")
    private String sname;

    @Generated(hash = 1386038786)
    public OrderListTable() {
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getOrderjson() {
        return orderjson;
    }

    public void setOrderjson(String orderjson) {
        this.orderjson = orderjson;
    }
}
