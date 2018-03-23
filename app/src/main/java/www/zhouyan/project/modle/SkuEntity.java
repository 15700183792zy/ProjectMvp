package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/6/28.
 */

public class SkuEntity {
    private String picurl;
    private String colorguid;
    private String name;
    private ArrayList<Sku> sizes;
    private boolean flag;
    private double num;
    private double num2;
    private int quantity;

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColorguid() {
        return colorguid;
    }

    public void setColorguid(String colorguid) {
        this.colorguid = colorguid;
    }

    public double getNum() {
        return num;
    }
    public void setNum(double num) {
        this.num = num;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public ArrayList<Sku> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Sku> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "SkuEntity{" +
                "colorguid='" + colorguid + '\'' +
                ", Name='" + name + '\'' +
                ", sizes=" + sizes +
                ", num=" + num +
                '}';
    }
}
