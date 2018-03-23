package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/28.
 */

public class OrderReportPost {
    private int pageindex;//	是
    private int pagesize;//	是
    private String bdate;//	是
    private String edate;//	是
    private int ordertype;//		是	销售单 = 1, 采购单 = 2,
    private ArrayList<String> clientguids;//		是	List<guid> 合作伙伴列表
    private ArrayList<String> shops;//	是	List<guid> 门店列表
    private ArrayList<String> pguids;//	是	List<pguid> 产品列表
    private ArrayList<String> salemobiles;//		是	List<string> 业务员手机号列表
    private ArrayList<String> mobiles;//	是	List<string> 开单员手机号列表
    private int orderby;//	int	是	排序方式 1:数量，2：销售额，3：毛利
//    private boolean desc;//boolen	是	True:升序，False:降序, 空：不使用
    private int orderkind;//	int	是	1升序，2降序，3：按日期
    private int grouptype;//	int	是	分组方式：产品 = 1,日期=2,合作伙伴=3,按门店=4,开单员=5,业务员=6


    //库存查询 shops,propertys,sizes,colors
    private ArrayList<SearchItemBean> propertys,sizes,colors;

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

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
    }

    public ArrayList<String> getClientguids() {
        return clientguids;
    }

    public void setClientguids(ArrayList<String> clientguids) {
        this.clientguids = clientguids;
    }

    public ArrayList<String> getShops() {
        return shops;
    }

    public void setShops(ArrayList<String> shops) {
        this.shops = shops;
    }

    public ArrayList<String> getPguids() {
        return pguids;
    }

    public void setPguids(ArrayList<String> pguids) {
        this.pguids = pguids;
    }

    public ArrayList<String> getSalemobiles() {
        return salemobiles;
    }

    public void setSalemobiles(ArrayList<String> salemobiles) {
        this.salemobiles = salemobiles;
    }

    public ArrayList<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(ArrayList<String> mobiles) {
        this.mobiles = mobiles;
    }

    public int getOrderby() {
        return orderby;
    }

    public void setOrderby(int orderby) {
        this.orderby = orderby;
    }

//    public boolean isDesc() {
//        return desc;
//    }
//
//    public void setDesc(boolean desc) {
//        this.desc = desc;
//    }

    public int getOrderkind() {
        return orderkind;
    }

    public void setOrderkind(int orderkind) {
        this.orderkind = orderkind;
    }

    public int getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(int grouptype) {
        this.grouptype = grouptype;
    }
}
