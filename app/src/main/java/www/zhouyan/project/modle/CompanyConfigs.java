package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 * 同步设置
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "CompanyConfigs")
public class CompanyConfigs {
    @Id
    @Property(nameInDb = "configid")
    private int configid;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "type")
    private int type;
    @Property(nameInDb = "configvalue")
    private String configvalue;
    @Property(nameInDb = "value")
    private String value;


    @Generated(hash = 1386038786)
    public CompanyConfigs() {
    }
    @Generated(hash = 635321027)
    public CompanyConfigs(int configid, String name, int type, String configvalue, String value) {
        this.configid = configid;
        this.name = name;
        this.type = type;
        this.configvalue = configvalue;
        this.value = value;
    }

    public int getConfigid() {
        return configid;
    }

    public void setConfigid(int configid) {
        this.configid = configid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
