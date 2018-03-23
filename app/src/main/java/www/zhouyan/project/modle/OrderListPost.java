package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/27.
 */

public class OrderListPost {
    private int ordertype;//是
    private int pageindex;//	是
    private int pagesize;//	是
    private String bdate;//	是
    private String edate;//	是
    private boolean existsowing;//	是	只显示存在欠款的单据，默认false
    private ArrayList<String> mobiles;//	是	 开单员的手机号
    private ArrayList<String> salemobiles;//	是	 业务员的手机号
    private ArrayList<String> shops;//	是 门店的guid
    private ArrayList<String> clientguids;//	是 合作伙伴的guid
    private String orderno;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
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

    public boolean isExistsowing() {
        return existsowing;
    }

    public void setExistsowing(boolean existsowing) {
        this.existsowing = existsowing;
    }

    public ArrayList<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(ArrayList<String> mobiles) {
        this.mobiles = mobiles;
    }

    public ArrayList<String> getSalemobiles() {
        return salemobiles;
    }

    public void setSalemobiles(ArrayList<String> salemobiles) {
        this.salemobiles = salemobiles;
    }

    public ArrayList<String> getShops() {
        return shops;
    }

    public void setShops(ArrayList<String> shops) {
        this.shops = shops;
    }

    public ArrayList<String> getClientguids() {
        return clientguids;
    }

    public void setClientguids(ArrayList<String> clientguids) {
        this.clientguids = clientguids;
    }
}
