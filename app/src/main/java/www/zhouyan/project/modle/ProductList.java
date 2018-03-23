package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/25.
 */

public class ProductList {
    private int pageindex;//		是
    private int pagesize;//	是
    private String key;
    //库存查询 shops,propertys,sizes,colors
    private ArrayList<SearchItemBean> propertys,sizes,colors;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
}
