package www.zhouyan.project.modle.daoarea;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by zhouyan on 2017/4/17.
 */

@Entity(nameInDb = "AreaCode")
public class AreaCode implements Serializable {
    @Id
    @Property(nameInDb = "areacode")
    private String areaCode;
    @Property(nameInDb = "areaname")
    private String areaName;
    @Property(nameInDb = "postcode")
    private String postCode;
    @Property(nameInDb = "zonecode")
    private String zoneCode;
    @Property(nameInDb = "areanamefull")
    private String areanamefull;


    @Generated(hash = 635321027)
    public AreaCode(String areaCode, String areaName, String postCode,
                    String zoneCode, String areanamefull) {
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.postCode = postCode;
        this.zoneCode = zoneCode;
        this.areanamefull = areanamefull;
    }
    @Generated(hash = 1386038786)
    public AreaCode() {
    }
    public String getAreaCode() {
        return this.areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getAreaName() {
        return this.areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getPostCode() {
        return this.postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getZoneCode() {
        return this.zoneCode;
    }
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }
    public String getareanamefull() {
        return this.areanamefull;
    }
    public void setareanamefull(String areanamefull) {
        this.areanamefull = areanamefull;
    }

    private boolean ischeck,isflag;//ischeck 选中，isflag 当前点击位置

    public boolean ischeck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public boolean isflag() {
        return isflag;
    }

    public void setIsflag(boolean isflag) {
        this.isflag = isflag;
    }


    @Override
    public String toString() {
        return "AreaCode{" +
                "areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' + '}';
    }
}
