package www.zhouyan.project.modle;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/9 14:57
 * 修改人: zhouyan
 * 修改时间: 2017/6/9 14:57
 * 修改备注:
 */

public class BannerInfo {


    private int id;
    private String picurl;
    private String jumpurl;
    private int orderno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getJumpurl() {
        return jumpurl;
    }

    public void setJumpurl(String jumpurl) {
        this.jumpurl = jumpurl;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }
}
