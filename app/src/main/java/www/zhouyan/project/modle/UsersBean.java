package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/23 13:53
 * 修改人: zhouyan
 * 修改时间: 2017/6/23 13:53
 * 修改备注:
 */
public class UsersBean implements Serializable {
    private String mobile;
    private String name;
    private String guid;
    private String sguid;
    private  String flag;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String isFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UsersBean{" +
                "mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", sguid='" + sguid + '\'' +
                ", flag=" + flag +
                '}';
    }
}