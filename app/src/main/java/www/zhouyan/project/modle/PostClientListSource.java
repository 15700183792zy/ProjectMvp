package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 18/1/8.
 */

public class PostClientListSource {
    private String key;//否	模糊查询的参数
    private int clienttype;//int	否	合作伙伴类型，客户=1，供应商=2
    private int pageindex;//	int	是
    private int pagesize;//	int	是
//    private boolean toexcel = false;//	boolen	是	false:显示数据，true：导出为excel 手机端设置为false
    private ArrayList<String> areacodes;//是 字符串数组
    private ArrayList<String> levels;//是

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getClienttype() {
        return clienttype;
    }

    public void setClienttype(int clienttype) {
        this.clienttype = clienttype;
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


    public ArrayList<String> getAreacodes() {
        return areacodes;
    }

    public void setAreacodes(ArrayList<String> areacodes) {
        this.areacodes = areacodes;
    }

    public ArrayList<String> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<String> levels) {
        this.levels = levels;
    }
}
