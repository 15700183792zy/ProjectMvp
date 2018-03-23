package www.zhouyan.project.modle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhouyan on 17/6/26.
 * 周岩
 *
 */

public class InventoryDateDetail implements Serializable {
    private String cguid;//"公司ID，"
    private String sguid;//门店id
    private String oguid;//单据id
    private String clientguid;//客户/供应商id
    private String lguid;//客户/供应商 等级id
    private String pguid;//商品id
    private String itemno;//商品的货号
    private String itemnum;//商品纯数字货号
    private String name;//商品名称
    private int quantity;//数量
    private double amount;//金额
    private double price;//价格
    private int id;
    private String picurl;//图片id
    public boolean flag;//是否展开
    private int rebate; //商品折扣, 默认是客户/供应商 折扣 默认100

    private int packagecount=1;//包装数
    private int groupcount=0;//手数
    private int piececount=0;//件数

    //是否使用历史价格 默认使用
    private boolean ishistoryprice = true;

    //特价, 促销 "","特", "促"
    private String specialinfo;

    public int getPackagecount() {
        return packagecount;
    }

    public void setPackagecount(int packagecount) {
        this.packagecount = packagecount;
    }

    public int getGroupcount() {
        return groupcount;
    }

    public void setGroupcount(int groupcount) {
        this.groupcount = groupcount;
    }

    public int getPiececount() {
        return piececount;
    }

    public void setPiececount(int piececount) {
        this.piececount = piececount;
    }

    public boolean ishistoryprice() {
        return ishistoryprice;
    }

    public void setIshistoryprice(boolean ishistoryprice) {
        this.ishistoryprice = ishistoryprice;
    }

    private ArrayList<InventoryItemData> colorsizes;

    public String getSpecialinfo() {
        return specialinfo;
    }

    public void setSpecialinfo(String specialinfo) {
        this.specialinfo = specialinfo;
    }

    public int getRebate() {
        return rebate;
    }

    public void setRebate(int rebate) {
        this.rebate = rebate;
    }

    public String getLguid() {
        return lguid;
    }

    public void setLguid(String lguid) {
        this.lguid = lguid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<InventoryItemData> getColorsizes() {
        return colorsizes;
    }

    public void setColorsizes(ArrayList<InventoryItemData> colorSizes) {
        this.colorsizes = colorSizes;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getOguid() {
        return oguid;
    }

    public void setOguid(String oguid) {
        this.oguid = oguid;
    }

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "InventoryDateDetail{" +
                "cguid='" + cguid + '\'' +
                ", sguid='" + sguid + '\'' +
                ", oguid='" + oguid + '\'' +
                ", clientguid='" + clientguid + '\'' +
                ", pguid='" + pguid + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", price=" + price +
                ", picurl=" + picurl +
                '}';
    }
}
