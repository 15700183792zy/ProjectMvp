package www.zhouyan.project.modle;

import java.io.Serializable;

/**
 * Created by mac on 17/10/9.
 */

public class SearchItemBean implements Serializable{

    private String guid;
    private String name;
    private String phone;
    private String pguid;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
