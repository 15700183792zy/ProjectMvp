package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by mac on 17/11/29.
 */
@Entity(nameInDb = "ProSizes")
public class ProSizes {

    @Id
    @Property(nameInDb = "pguid")
    private String pguid;
    @Property(nameInDb = "dguid")
    private String dguid;
    @Property(nameInDb = "name")
    private String name;

    @Generated(hash = 1386038786)
    public ProSizes() {
    }


    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }

    public String getDguid() {
        return dguid;
    }

    public void setDguid(String dguid) {
        this.dguid = dguid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
