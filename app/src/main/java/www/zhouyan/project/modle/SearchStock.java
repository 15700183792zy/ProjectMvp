package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/15.
 */

public class SearchStock {
    //库存查询 shops,sizes,colors
    private ArrayList<String> shops,sizes,colors;
    //库存查询 propertys
    private ArrayList<SearchItemBean> propertys;
    private boolean showzero,showminus;//showzero  不显示0 ，showminus 不显示负数
    private String key;
    private int pageindex;//		是
    private int pagesize;//	是

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

    public ArrayList<String> getShops() {
        return shops;
    }

    public void setShops(ArrayList<String> shops) {
        this.shops = shops;
    }

    public ArrayList<String> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<String> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<SearchItemBean> getPropertys() {
        return propertys;
    }

    public void setPropertys(ArrayList<SearchItemBean> propertys) {
        this.propertys = propertys;
    }
}
