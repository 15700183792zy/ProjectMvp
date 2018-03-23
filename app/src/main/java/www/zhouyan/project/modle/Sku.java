package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by zhouyan on 17/6/28.
 */
@Entity(nameInDb = "ProSKUs")
public class Sku implements Serializable {
    @Id
    @Property(nameInDb = "pguid")
    private String pguid;
    @Property(nameInDb = "colorguid")
    private String colorguid;

    @Property(nameInDb = "sizeguid")
    private String sizeguid;
    @Property(nameInDb = "cprice")
    private double cprice;
    @Property(nameInDb = "tprice")
    private double tprice;

    private double price=-1; //存储 历史价格

    private String name;//尺码的名臣
    private int id;
    private int quantity;

    @Generated(hash = 1386038786)
    public Sku() {
    }

    @Generated(hash = 635321027)
    public Sku(String pguid, String colorguid, String sizeguid, double cprice, double tprice) {
        this.pguid = pguid;
        this.colorguid = colorguid;
        this.sizeguid = sizeguid;
        this.cprice = cprice;
        this.tprice = tprice;
        this.id = 0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPguid() {
        return pguid;
    }

    public void setPguid(String pguid) {
        this.pguid = pguid;
    }

    public String getColorguid() {
        return colorguid;
    }

    public void setColorguid(String colorguid) {
        this.colorguid = colorguid;
    }

    public String getSizeguid() {
        return sizeguid;
    }

    public void setSizeguid(String sizeguid) {
        this.sizeguid = sizeguid;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "name='" + name + '\'' +
                ", sizeguid='" + sizeguid + '\'' +
                ", cprice=" + cprice +
                ", tprice=" + tprice +
                ", colorguid=" + colorguid +
                '}';
    }
}
