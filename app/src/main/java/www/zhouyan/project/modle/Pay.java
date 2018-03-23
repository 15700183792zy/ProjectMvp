package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by zhouyan on 17/6/26.
 */
@Entity(nameInDb = "CompanyAccounts")
public class Pay implements Serializable {
    @Id
    @Property(nameInDb = "guid")
    private String guid;
    @Property(nameInDb = "sguid")
    private String sguid;
    @Property(nameInDb = "orderno")
    private int orderno;
    @Property(nameInDb = "name")
    private String name;//"账户名称",
    @Property(nameInDb = "accounttype")
    private int accounttype;// "账户类型",
    private String aguid;// "账户ID"
    private String accountname;//"账户名称",
    private double amount;
    @Generated(hash = 1386038786)
    public Pay() {
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAguid() {
        return aguid;
    }

    public void setAguid(String aguid) {
        this.aguid = aguid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(int accounttype) {
        this.accounttype = accounttype;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
