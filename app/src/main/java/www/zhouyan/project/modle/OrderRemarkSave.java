package www.zhouyan.project.modle;

/**
 * Created by mac on 17/11/10.
 */

public class OrderRemarkSave {
    private String oguid;//	string	是	订单的orderid
    private String remark;//	string	是	补充的备注内容

    public String getOguid() {
        return oguid;
    }

    public void setOguid(String oguid) {
        this.oguid = oguid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
