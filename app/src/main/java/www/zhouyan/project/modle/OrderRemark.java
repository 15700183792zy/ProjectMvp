package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by mac on 17/11/10.
 */

public class OrderRemark implements Serializable{
    private String name;
    private String time;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
