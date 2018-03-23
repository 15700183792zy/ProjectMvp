package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/22 18:46
 * 修改人: zhouyan
 * 修改时间: 2017/6/22 18:46
 * 修改备注:
 */

public class CustomerPrice implements Serializable {

    private String  guid;
    private double tprice;
    private String name;

    public CustomerPrice(){

    }

    public CustomerPrice(String guid, String name, double tprice) {
        this.guid = guid;
        this.tprice = tprice;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }
}
