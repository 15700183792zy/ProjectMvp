package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by mac on 17/10/18.
 */

public class AllocationRemarkSave implements Serializable {
    private String orderid;//是
    private String remark;//是
    private String orderdate;//是
    private String salemobile;//是
    private String salesname;//是

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getSalemobile() {
        return salemobile;
    }

    public void setSalemobile(String salemobile) {
        this.salemobile = salemobile;
    }

    public String getSalesname() {
        return salesname;
    }

    public void setSalesname(String salesname) {
        this.salesname = salesname;
    }
}
