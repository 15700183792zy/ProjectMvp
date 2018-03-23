package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by mac on 17/8/22.
 */

public class ShopRemarkImg implements Serializable{
    private String imgname;
    private String url;

    public ShopRemarkImg() {
    }

    public ShopRemarkImg(String imgname, String url) {
        this.imgname = imgname;
        this.url = url;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
