package www.zhouyan.project.modle;

import java.io.Serializable;
import java.util.ArrayList;

import www.zhouyan.project.modle.daoarea.AreaCode;

/**
 * Created by mac on 17/8/17.
 */

public class SearchBean implements Serializable {
    public int type;
    //searchBean.type 1 采购入库 ，销售入库，盘点单
    // 2 采购报表，销售报表 4表示库存
    // 5 调拨单
    // 6客户对账，7 供应商对账
    // 8 商品列表
    //9客户列表，10供应商列表
    //

    private String clientname;
    private String clientguid;

    private String sguid;
    private String sname;

    private String bdate;
    private String edate;

    private int pageindex;//		是
    private int pagesize;//	是
    private int ordertype;//是
    private String ordertypename;
    private String pguid;//是 商品
    private String pname;
    private String salemobile;//	是
    private String ordermobile;//	是
    private String salename;//	是 业务苑
    private String ordername;//	是 开单员
    private int orderby;//是	排序方式 1:数量，2：销售额，3：毛利
    //private boolean desc;//是	升序，降序
    private int orderkind; //1升序，2降序，3按日期

    private boolean showzero, showminus;//showzero  不显示0 ，showminus 不显示负数
    private String key;

    private String fromsguid, fromsname, tosguid, toname;
    //库存查询 shops,propertys,sizes,colors
    private ArrayList<SearchItemBean> mobiles, salemobiles, clientguids, pguids;
    //库存查询 shops,propertys,sizes,colors
    private ArrayList<SearchItemBean> shops, propertys, sizes, colors;

    private boolean existsowing;//只显示存在欠款的单据，默认false
    private String fguid, fname; //选择合作伙伴账目类型
    private String aguid, aname; //选择合作伙伴账目类型
    private int grouptype;

    //客户供应商列表 搜索条件
    private ArrayList<AreaCode> areacodes; //省市县
    private ArrayList<SearchItemBean> levels;//等级

    //合作伙伴对账列表
    private boolean showcancel;//是否显示撤销单，默认为false


    private int timetype;//时间类型：1业务日期，2操作日期（默认）


    private String orderno;//单据列表的单号

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
    public int getTimetype() {
        return timetype;
    }

    public void setTimetype(int timetype) {
        this.timetype = timetype;
    }

    public String getAguid() {
        return aguid;
    }

    public void setAguid(String aguid) {
        this.aguid = aguid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public boolean isShowcancel() {
        return showcancel;
    }

    public void setShowcancel(boolean showcancel) {
        this.showcancel = showcancel;
    }

    public ArrayList<AreaCode> getAreacodes() {
        return areacodes;
    }

    public void setAreacodes(ArrayList<AreaCode> areacodes) {
        this.areacodes = areacodes;
    }

    public ArrayList<SearchItemBean> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<SearchItemBean> levels) {
        this.levels = levels;
    }

    public int getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(int grouptype) {
        this.grouptype = grouptype;
    }

    public ArrayList<SearchItemBean> getPguids() {
        return pguids;
    }

    public void setPguids(ArrayList<SearchItemBean> pguids) {
        this.pguids = pguids;
    }

    public ArrayList<SearchItemBean> getMobiles() {
        return mobiles;
    }

    public void setMobiles(ArrayList<SearchItemBean> mobiles) {
        this.mobiles = mobiles;
    }

    public ArrayList<SearchItemBean> getSalemobiles() {
        return salemobiles;
    }

    public void setSalemobiles(ArrayList<SearchItemBean> salemobiles) {
        this.salemobiles = salemobiles;
    }

    public ArrayList<SearchItemBean> getClientguids() {
        return clientguids;
    }

    public void setClientguids(ArrayList<SearchItemBean> clientguids) {
        this.clientguids = clientguids;
    }

    public boolean isExistsowing() {
        return existsowing;
    }

    public void setExistsowing(boolean existsowing) {
        this.existsowing = existsowing;
    }

    public String getFguid() {
        return fguid;
    }

    public void setFguid(String fguid) {
        this.fguid = fguid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getOrderkind() {
        return orderkind;
    }

    public void setOrderkind(int orderkind) {
        this.orderkind = orderkind;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFromsguid() {
        return fromsguid;
    }

    public void setFromsguid(String fromsguid) {
        this.fromsguid = fromsguid;
    }

    public String getFromsname() {
        return fromsname;
    }

    public void setFromsname(String fromsname) {
        this.fromsname = fromsname;
    }

    public String getTosguid() {
        return tosguid;
    }

    public void setTosguid(String tosguid) {
        this.tosguid = tosguid;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public ArrayList<SearchItemBean> getShops() {
        return shops;
    }

    public void setShops(ArrayList<SearchItemBean> shops) {
        this.shops = shops;
    }

    public ArrayList<SearchItemBean> getPropertys() {
        return propertys;
    }

    public void setPropertys(ArrayList<SearchItemBean> propertys) {
        this.propertys = propertys;
    }

    public ArrayList<SearchItemBean> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<SearchItemBean> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<SearchItemBean> getColors() {
        return colors;
    }

    public void setColors(ArrayList<SearchItemBean> colors) {
        this.colors = colors;
    }

    public boolean isShowzero() {
        return showzero;
    }

    public void setShowzero(boolean showzero) {
        this.showzero = showzero;
    }

    public boolean isShowminus() {
        return showminus;
    }

    public void setShowminus(boolean showminus) {
        this.showminus = showminus;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOrdertypename() {
        return ordertypename;
    }

    public void setOrdertypename(String ordertypename) {
        this.ordertypename = ordertypename;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSalename() {
        return salename;
    }

    public void setSalename(String salename) {
        this.salename = salename;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
    }

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }

    public String getSalemobile() {
        return salemobile;
    }

    public void setSalemobile(String salemobile) {
        this.salemobile = salemobile;
    }

    public String getOrdermobile() {
        return ordermobile;
    }

    public void setOrdermobile(String ordermobile) {
        this.ordermobile = ordermobile;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }


    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }
}
