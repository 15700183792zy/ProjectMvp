package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2016/11/13.
 *   "lastver": "最新版本",
 *   "url": "下载地址",
 *   "type": "更新类型",
 *   "remark": "备注"
 */
public class UpdateResponse {

    private String lastver;
    private String url;//地址
    private int type; //type: 最新版本 = 1, 强制更新 = 2, 更新提醒 = 3,
    private String remark;//存储更新的信息（更新版本上的问题）

    public String getLastver() {
        return lastver;
    }

    public void setLastver(String lastver) {
        this.lastver = lastver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
