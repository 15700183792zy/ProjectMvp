package www.zhouyan.project.modle;

/**
 * Created by mac on 17/12/19.
 */

public class UserPrintIPGet {
    /**
     * cguid : b331a587-a872-4824-a698-b78e8a26b0cc
     * mobile : 15700183792
     * printtype : 1
     * ipaddress : 192.168.10.90
     * isselect : false
     * typename : 热敏
     * id : 19
     */

    private String cguid;
    private String mobile;
    private int printtype;
    private String ipaddress;
    private boolean isselect;
    private String typename;
    private int id;

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getPrinttype() {
        return printtype;
    }

    public void setPrinttype(int printtype) {
        this.printtype = printtype;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public boolean isIsselect() {
        return isselect;
    }

    public void setIsselect(boolean isselect) {
        this.isselect = isselect;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
