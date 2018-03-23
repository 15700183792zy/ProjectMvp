package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by zhouyan on 2017/5/24.
 */

public class InventoryItemData implements Serializable {
    private String cguid;//"公司ID，"
    private String sguid;//门店id
    private String oguid;//单据id
    private String pguid;//商品 id
    private String colorguid;//颜色 id
    private String colorname;//颜色名称
    private String sizeguid;//尺码 id
    private String sizename;//尺码名称
    private String picurl;  //颜色所对应的图片
    private double clientprice; //合作伙伴合作分类设置的价格
    private double skuprice; //sku的价格
    private double baseprice; //(basePrice 销售单 tprice,其他单据 cprice)
    //  "originprice": "原价= baseprice + skuprice + clientprice;",
    private double price;//  （skuprice+clientprice+basePrice）*合作伙伴折扣/100
    private int originstore;//库存
    private int breakqty;// quantity - originstore " 盈亏数量 = originstore - quantity",
    private int quantity; // "数量，盘点时为 实际库存",
    private boolean issys;//系统增加数据  --》  避免盘点出错
    private double amount;//qantity*price
    private int id;
    private double cprice;// skuprice+cprice
    private int packagecount=1;//包装数
    private int groupcount=0;//手数
    private int piececount=0;//件数

    private boolean iszero;//是否盘点为0

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

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public boolean issys() {
        return issys;
    }

    public boolean iszero() {
        return iszero;
    }

    public void setIszero(boolean iszero) {
        this.iszero = iszero;
    }

    public int getBreakqty() {
        return breakqty;
    }

    public void setBreakqty(int breakqty) {
        this.breakqty = breakqty;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
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

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }

    public String getColorguid() {
        return colorguid;
    }

    public void setColorguid(String colorguid) {
        this.colorguid = colorguid;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public String getSizeguid() {
        return sizeguid;
    }

    public void setSizeguid(String sizeguid) {
        this.sizeguid = sizeguid;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    public double getClientprice() {
        return clientprice;
    }

    public void setClientprice(double clientprice) {
        this.clientprice = clientprice;
    }

    public double getSkuprice() {
        return skuprice;
    }

    public void setSkuprice(double skuprice) {
        this.skuprice = skuprice;
    }

    public double getBaseprice() {
        return baseprice;
    }

    public void setBaseprice(double basePrice) {
        this.baseprice = basePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOriginstore() {
        return originstore;
    }

    public void setOriginstore(int originstore) {
        this.originstore = originstore;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIssys() {
        return issys;
    }

    public void setIssys(boolean issys) {
        this.issys = issys;
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

    @Override
    public String toString() {
        return "InventoryItemData{" +
                "colorguid='" + colorguid + '\'' +
                ", sizeguid='" + sizeguid + '\'' +
                ", baseprice=" + baseprice +
                ", clientprice=" + clientprice +
                ", skuprice=" + skuprice +
                ", price=" + price +
                ", originstore=" + originstore +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
