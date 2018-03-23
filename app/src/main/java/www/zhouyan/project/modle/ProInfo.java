package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/6/30.
 */

public class ProInfo {
    private String guid;
    private String name;
    private String picurl;
    private String itemnum;
    private String itemno;
    private double cprice;
    private double tprice;
    private double clientprice;
    private int quantity;
    //包装数 默认值是1
    private  int packagecount=1;

    public int getPackagecount() {
        return packagecount;
    }

    public void setPackagecount(int packagecount) {
        this.packagecount = packagecount;
    }
    private ArrayList<SkuEntity> colors;

    public ArrayList<SkuEntity> getColors() {
        return colors;
    }

    public void setColors(ArrayList<SkuEntity> colors) {
        this.colors = colors;
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

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public double getClientprice() {
        return clientprice;
    }

    public void setClientprice(double clientprice) {
        this.clientprice = clientprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProInfo{" +
                "cprice=" + cprice +
                ", tprice=" + tprice +
                ", clientprice=" + clientprice +
                ", quantity=" + quantity +
                ", colors=" + colors +
                '}';
    }
}
