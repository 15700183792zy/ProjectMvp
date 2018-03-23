package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/18.
 */

public class FinanceTotalInfo {


    private double customamount;
    private int slowcount;
    private int notbuybackcount;
    public double getCustomamount() {
        return customamount;
    }
    public void setCustomamount(double customamount) {
        this.customamount = customamount;
    }

    public int getSlowcount() {
        return slowcount;
    }

    public void setSlowcount(int slowcount) {
        this.slowcount = slowcount;
    }

    public int getNotbuybackcount() {
        return notbuybackcount;
    }

    public void setNotbuybackcount(int notbuybackcount) {
        this.notbuybackcount = notbuybackcount;
    }
}
