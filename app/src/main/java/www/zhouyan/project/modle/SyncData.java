package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/9 14:24
 * 修改人: zhouyan
 * 修改时间: 2017/6/9 14:24
 * 修改备注:
 */

public class SyncData {
    private ArrayList<SynAreaCode> areacodes;
    private ArrayList<BannerInfo> bannerinfos;

    public SyncData() {
    }

    public ArrayList<BannerInfo> getBannerinfos() {
        return bannerinfos;
    }

    public void setBannerinfos(ArrayList<BannerInfo> bannerinfos) {
        this.bannerinfos = bannerinfos;
    }

    public ArrayList<SynAreaCode> getAreacodes() {
        return areacodes;
    }

    public void setAreacodes(ArrayList<SynAreaCode> areacodes) {
        this.areacodes = areacodes;
    }

}
