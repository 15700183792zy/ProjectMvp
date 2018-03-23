package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhouyan on 2017/5/24.
 */
@Entity(nameInDb = "Products")
public class Goodsinfo implements Serializable{
    @Id
    @Property(nameInDb = "guid")
    private String guid;

    private String cguid;

    @Property(nameInDb = "itemno")
    private String itemno;
    @Property(nameInDb = "itemnum")
    private String itemnum;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "cprice")
    private double cprice;//成本价
    @Property(nameInDb = "tprice")
    private double tprice;//销售价
    @Property(nameInDb = "clevel")
    private String clevel;//客户
    @Property(nameInDb = "slevel")
    private String slevel;//供应商
    @Property(nameInDb = "rprice")
    private double rprice;

    private String remark;
    @Property(nameInDb = "picurl")
    private String picurl;
    @Property(nameInDb = "shortspell")
    private String shortspell;

    private boolean isstop;
    private int quantity;
    private boolean deleteflag;
    private int id;
    public boolean flag;
    private ArrayList<PicDictSave> propertys;
    private ArrayList<PicDictSave> colors;
    private ArrayList<PicDictSave> sizes;
    private ArrayList<Sku> skus;
    private int refcount;

    private String updatetime,createtime;

    //包装数 默认值是1
    private  int packagecount=1;

    public int getPackagecount() {
        return packagecount;
    }

    public void setPackagecount(int packagecount) {
        this.packagecount = packagecount;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Generated(hash = 1386038786)
    public Goodsinfo() {
    }

    public String getSlevel() {
        return slevel;
    }

    public void setSlevel(String slevel) {
        this.slevel = slevel;
    }


    public ArrayList<Sku> getSkus() {
        return skus;
    }

    public void setSkus(ArrayList<Sku> skus) {
        this.skus = skus;
    }

    public int getRefcount() {
        return refcount;
    }

    public void setRefcount(int refcount) {
        this.refcount = refcount;
    }

    public ArrayList<PicDictSave> getPropertys() {
        return propertys;
    }

    public void setPropertys(ArrayList<PicDictSave> propertys) {
        this.propertys = propertys;
    }

    public ArrayList<PicDictSave> getColors() {
        return colors;
    }

    public void setColors(ArrayList<PicDictSave> colors) {
        this.colors = colors;
    }

    public ArrayList<PicDictSave> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<PicDictSave> sizes) {
        this.sizes = sizes;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getClevel() {
        return clevel;
    }

    public void setClevel(String clevel) {
        this.clevel = clevel;
    }

    public double getRprice() {
        return rprice;
    }

    public void setRprice(double rprice) {
        this.rprice = rprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public boolean isIsstop() {
        return isstop;
    }

    public void setIsstop(boolean isstop) {
        this.isstop = isstop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Goodsinfo{" +
                ", guid='" + guid + '\'' +
                ", itemno='" + itemno + '\'' +
                ", itemnum='" + itemnum + '\'' +
                ", name='" + name + '\'' +
                ", cprice='" + cprice + '\'' +
                ", tprice='" + tprice + '\'' +
                ", propertys=" + propertys +
                ", colors=" + colors +
                ", sizes=" + sizes +
                ", url=" + picurl +
                '}';
    }
}
