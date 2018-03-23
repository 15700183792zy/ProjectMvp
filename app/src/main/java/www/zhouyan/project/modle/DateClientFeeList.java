package www.zhouyan.project.modle;

/**
 * Created by mac on 17/9/6.
 */

public class DateClientFeeList {

    /**
     * feedate :
     * amount : 0.0
     * aname : 账号名称
     * fname : 费用名称
     * id : 0
     */

    private String feedate;
    private double amount;
    private String aname;
    private String fname;
    private int id;

    public String getFeedate() {
        return feedate;
    }

    public void setFeedate(String feedate) {
        this.feedate = feedate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
