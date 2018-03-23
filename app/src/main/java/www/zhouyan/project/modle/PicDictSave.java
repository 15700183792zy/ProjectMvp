package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/20 18:38
 * 修改人: zhouyan
 * 修改时间: 2017/6/20 18:38
 * 修改备注:
 * 这项表 ProDicts 字典
 */
@Entity(nameInDb = "ProDicts")
public class PicDictSave implements Serializable {

    @Id
    @Property(nameInDb = "guid")
    private String guid;//新增不传
    @Property(nameInDb = "orderno")
    private String orderno;
    @Property(nameInDb = "dtype")
    private int dtype;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "pguid") //商品详情颜色尺码指向商品guid，属性指向上级
    private String pguid;//如果不存在上级, pguid传“00000000-0000-0000-0000-000000000000”
    @Property(nameInDb = "issys")
    private String issys = "False";

    @Property(nameInDb = "isstop")
    private String isstop = "False";
    private String isstop2 = "false"; //表示商品中停用
    @Property(nameInDb = "shortspell")
    private String shortspell;
    public boolean flag = false;

    private double cprice;
    private double tprice;
    private String picurl;
    private String dguid;
    private String cguid;
    private String issysParent = "False";//父类的 issys
    private String  nameParent=null;//父类的 name
//    private int state; //0 无变化 , 1 添加 , 2 修改 3 删除
    private ArrayList<PicDictSave> childs;
    private int refcount = -1;//商品引用次数

    public int like = 0; // spellsort1 表示存在 2 表示不存在


    public String getNameParent() {
        return nameParent;
    }

    public void setNameParent(String nameParent) {
        this.nameParent = nameParent;
    }

    public String getIssysParent() {
        return issysParent;
    }

    public void setIssysParent(String issysParent) {
        this.issysParent = issysParent;
    }

    public String getIsstop2() {
        return isstop2;
    }

    public void setIsstop2(String isstop2) {
        this.isstop2 = isstop2;
    }

    public String getShortspell() {
        return shortspell;
    }

    public void setShortspell(String shortspell) {
        this.shortspell = shortspell;
    }

    public int getRefcount() {
        return refcount;
    }

    public void setRefcount(int refcount) {
        this.refcount = refcount;
    }

    @Generated(hash = 1386038786)
    public PicDictSave() {
    }

    @Generated(hash = 1386038787)
    public PicDictSave(String name, String dguid, String guid) {
        this.guid = guid;
        this.name = name;
        this.dguid = dguid;
    }

    @Generated(hash = 1386038785)
    public PicDictSave(String name) {
        this.name = name;

    }

    @Generated(hash = 1386038788)
    public PicDictSave(int dtype, String name, String guid) {
        this.dtype = dtype;
        this.name = name;
        this.guid = guid;
    }

    @Generated(hash = 1386038789)
    public PicDictSave(/*int state,*/ double cprice,
                       double tprice, String picurl, String pguid, String dguid, String name) {
        this.cprice = cprice;
        this.tprice = tprice;
        this.picurl = picurl;
        this.pguid = pguid;
        this.guid = dguid;
        this.dguid = dguid;
        this.name = name;

    }

    @Generated(hash = 1386038710)
    public PicDictSave(String name, String guid) {
        this.name = name;
        this.dguid = guid;
        this.guid = guid;
    }



    public String getIsstop() {
        return isstop;
    }

    public void setIsstop(String isstop) {
        this.isstop = isstop;
    }

    public String getIssys() {
        return issys;
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getDguid() {
        return dguid;
    }

    public void setDguid(String dguid) {
        this.dguid = dguid;
//        this.guid = dguid;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public ArrayList<PicDictSave> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<PicDictSave> childs) {
        this.childs = childs;
    }

    public String issys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }

    @Override
    public String toString() {
        return "PicDictSave{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", pguid='" + pguid + '\'' +
                ", issysParent='" + issysParent + '\'' +
                ", nameParent='" + nameParent + '\'' +
                ", childs=" + childs +
                '}';
    }
}
