package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/13 10:37
 * 修改人: zhouyan
 * 修改时间: 2017/6/13 10:37
 * 修改备注:
 */

public class GvDate implements Serializable{
    private String name;
    private String img;//图标
    private  boolean state;
    private  int num;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public GvDate(int num,boolean state,String name, String icon) {
        this.num=num;
        this.state=state;
        this.name = name;
        this.img = icon;
    }

    public GvDate(String name, String icon) {
        this.name = name;
        this.img = icon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "GvDate{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", state=" + state +
                ", num=" + num +
                '}';
    }
}
