package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 14:55
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 14:55
 * 修改备注: 门店信息
 */
@Entity(nameInDb = "Shops")
public class Shop implements Serializable{

    private String cguid;
    @Id
    @Property(nameInDb = "guid")
    private String guid;
    @Property(nameInDb = "name")
    private String name;
    private String tel;
    private String address;
    private String mobile;//店长手机 , 允许空
    private String createtime;
    private String updatetime;
    private boolean deleteflag;
    private boolean isstop;
    private int id;
    private String remark;
    private String mName;
    private String areacode;
    private String areaname;
    private String areanamefull;

    @Generated(hash = 1386038786)
    public Shop() {
    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreanamefull() {
        return areanamefull;
    }

    public void setAreanamefull(String areanamefull) {
        this.areanamefull = areanamefull;
    }

    public String getMname(){return  mName;}
    public void setMname(String mName) {
        this.mName = mName;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isstop() {
        return isstop;
    }

    public void setIsstop(boolean isstop) {
        this.isstop = isstop;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
