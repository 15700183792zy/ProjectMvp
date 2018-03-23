package www.zhouyan.project.modle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhouyan on 2017/5/24.
 * 单据信息 详情
 */

public class InventoryDate implements Serializable {

    private String cguid;//公司的guid
    private String orderid;//单据id
    private String orderno;  //订单的orderno产生规则为: YYYYMMDDHHMMSS单据类型0001 单位类型: 销售（XS）, 入库（RK）, 盘点: （PD）
    private String ordertime;
    private int ordertype;//1 销售 2入库 3 盘点
    private String clientguid;//客户。供应商 guid
    private String mobile;//操作员
    private String name;//操作员
    private String remark;//备注
    private double totalamount;//全款
    private int rebate; //折扣 默认100
    private int clientrebate; //客户/供应商的 折扣 默认100
    private double actamount;//实际金额
    private double smallamount;//抹零金额
    private double payamount;//支付金额
    private int totalquantity; //总数量
    private double owing;//欠款
    private int id;
    private int upid;//挂单列表中的id 重挂单列表取出 upid= orderid
    private ArrayList<Pay> pays; //销售单据的信息
    private ArrayList<InventoryDateDetail> details; //单据详情
    private String clientname; //客户。供应商 name
    private String sguid; //门店 guid
    private String sname;//门店名称
    private String lguid;//客户, 供应商 的类别guid
    private int checktype;//1 全盘, 2 部分盘点
    private double hisbalance;// "上期余额，0"
    private double hisbalanceshop; //17.11.13 增加门店的hisbalanceshop 字段 本店上期余额
    private String cname;//公司名称
    //业务员
    private String salesname;//业务员
    private String salemobile;

    private String orderdate;//"单据时间0001-01-01T00:00:00",

    private double orderbalance;//开单时hisbalance-owing, 详情
    private double orderbalanceshop;//开单时增加门店的hisbalanceshop-owing, 详情 本店余额

    public int getUpid() {
        return upid;
    }

    public void setUpid(int upid) {
        this.upid = upid;
    }

    public double getOrderbalanceshop() {
        return orderbalanceshop;
    }

    public void setOrderbalanceshop(double orderbalanceshop) {
        this.orderbalanceshop = orderbalanceshop;
    }

    public double getHisbalanceshop() {
        return hisbalanceshop;
    }

    public void setHisbalanceshop(double hisbalanceshop) {
        this.hisbalanceshop = hisbalanceshop;
    }

    //remarks
    private ArrayList<OrderRemark> remarks;//17.11.06 增加备注的remarks字段

    public ArrayList<OrderRemark> getRemarks() {
        return remarks;
    }

    public void setRemarks(ArrayList<OrderRemark> remarks) {
        this.remarks = remarks;
    }

    public String getSalemobile() {
        return salemobile;
    }

    public void setSalemobile(String salemobile) {
        this.salemobile = salemobile;
    }

    public double getOrderbalance() {
        return orderbalance;
    }

    public void setOrderbalance(double orderbalance) {
        this.orderbalance = orderbalance;
    }

    public int getClientrebate() {
        return clientrebate;
    }

    public void setClientrebate(int clientrebate) {
        this.clientrebate = clientrebate;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSalesname() {
        return salesname;
    }

    public void setSalesname(String salesname) {
        this.salesname = salesname;
    }

    public int getChecktype() {
        return checktype;
    }

    public void setChecktype(int checktype) {
        this.checktype = checktype;
    }

    public double getHisbalance() {
        return hisbalance;
    }

    public void setHisbalance(double hisbalance) {
        this.hisbalance = hisbalance;
    }

    public String getLguid() {
        return lguid;
    }

    public void setLguid(String lguid) {
        this.lguid = lguid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
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

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
    }

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public int getRebate() {
        return rebate;
    }

    public void setRebate(int rebate) {
        this.rebate = rebate;
    }

    public double getActamount() {
        return actamount;
    }

    public void setActamount(double actamount) {
        this.actamount = actamount;
    }

    public double getSmallamount() {
        return smallamount;
    }

    public void setSmallamount(double smallamount) {
        this.smallamount = smallamount;
    }

    public double getPayamount() {
        return payamount;
    }

    public void setPayamount(double payamount) {
        this.payamount = payamount;
    }

    public int getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(int totalquantity) {
        this.totalquantity = totalquantity;
    }

    public double getOwing() {
        return owing;
    }

    public void setOwing(double owing) {
        this.owing = owing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ArrayList<Pay> getPays() {
        return pays;
    }

    public void setPays(ArrayList<Pay> pays) {
        this.pays = pays;
    }

    public ArrayList<InventoryDateDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<InventoryDateDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "InventoryDate{" +
                "cguid='" + cguid + '\'' +
                ", orderid='" + orderid + '\'' +
                ", details=" + details +
                ", sguid='" + sguid + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
