package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/25.
 */

public class ShowPrintRemarkInfo {

    private int id;
    private String cguid;
    private int ordertype;
    private boolean printclient;//是否打印合作伙伴信息
    private int printmode;//打印模式 1货号级 2 颜色级 3 尺码级
    private boolean printorderremark;//是否打印单据备注
    private boolean printshop;//是否打印门店信息
    private boolean printremote;//是否远程打印
    private String sguid;
    private String shopremark;
    private int printcount;

    public boolean isPrintremote() {
        return printremote;
    }

    public void setPrintremote(boolean printremote) {
        this.printremote = printremote;
    }

    public int getPrintcount() {
        return printcount;
    }

    public void setPrintcount(int printcount) {
        this.printcount = printcount;
    }

    //图片的路径
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public int getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(int ordertype) {
        this.ordertype = ordertype;
    }

    public boolean isPrintclient() {
        return printclient;
    }

    public void setPrintclient(boolean printclient) {
        this.printclient = printclient;
    }

    public int getPrintmode() {
        return printmode;
    }

    public void setPrintmode(int printmode) {
        this.printmode = printmode;
    }

    public boolean isPrintorderremark() {
        return printorderremark;
    }

    public void setPrintorderremark(boolean printorderremark) {
        this.printorderremark = printorderremark;
    }

    public boolean isPrintshop() {
        return printshop;
    }

    public void setPrintshop(boolean printshop) {
        this.printshop = printshop;
    }

    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getShopremark() {
        return shopremark;
    }

    public void setShopremark(String shopremark) {
        this.shopremark = shopremark;
    }
}
