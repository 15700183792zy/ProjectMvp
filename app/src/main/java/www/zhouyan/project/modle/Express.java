package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 2017/6/5.
 * 物流
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "Express")
public class Express {
    @Id
    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "expresstype")
    private int expresstype;

    @Property(nameInDb = "canquery")
    private int canquery;

    @Property(nameInDb = "code")
    private String code;

    @Property(nameInDb = "canorder")
    private String canorder;

    @Property(nameInDb = "shortspell")
    private String shortspell;

    @Property(nameInDb = "firstletter")
    private String firstletter;

    @Property(nameInDb = "iscommon")
    private int iscommon;

    @Generated(hash = 1386038786)
    public Express() {
    }

    public String getCanorder() {
        return canorder;
    }

    public void setCanorder(String canorder) {
        this.canorder = canorder;
    }

    public int getExpresstype() {
        return expresstype;
    }

    public void setExpresstype(int expresstype) {
        this.expresstype = expresstype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCanquery() {
        return canquery;
    }

    public void setCanquery(int canquery) {
        this.canquery = canquery;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortspell() {
        return shortspell;
    }

    public void setShortspell(String shortspell) {
        this.shortspell = shortspell;
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

    public int getIscommon() {
        return iscommon;
    }

    public void setIscommon(int iscommon) {
        this.iscommon = iscommon;
    }

    @Override
    public String toString() {
        return "Express{" +
                "name='" + name + '\'' +
                ", expresstype=" + expresstype +
                ", canquery=" + canquery +
                ", code='" + code + '\'' +
                ", canorder='" + canorder + '\'' +
                ", shortspell='" + shortspell + '\'' +
                ", firstletter='" + firstletter + '\'' +
                ", iscommon=" + iscommon +
                '}';
    }
}
