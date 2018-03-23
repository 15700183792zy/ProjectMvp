package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/7.
 */

public class AccountInit {
    //账户初始化

   private String id;//账户id
    private String initamount;//初始化金额
    private String remark;//初始化备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitamount() {
        return initamount;
    }

    public void setInitamount(String initamount) {
        this.initamount = initamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
