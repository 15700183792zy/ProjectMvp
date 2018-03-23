package www.zhouyan.project.modle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyan on 17/7/24.
 */

public class OrderPrint {


    private String printremark;
    private ArrayList<AccountinfosBean> accountinfos;

    public String getPrintremark() {
        return printremark;
    }

    public void setPrintremark(String printremark) {
        this.printremark = printremark;
    }

    public List<AccountinfosBean> getAccountinfos() {
        return accountinfos;
    }

    public void setAccountinfos(ArrayList<AccountinfosBean> accountinfos) {
        this.accountinfos = accountinfos;
    }

    public static class AccountinfosBean {

        private String openbank;
        private String bankaccount;
        private String bankname;

        public String getOpenbank() {
            return openbank;
        }

        public void setOpenbank(String openbank) {
            this.openbank = openbank;
        }

        public String getBankaccount() {
            return bankaccount;
        }

        public void setBankaccount(String bankaccount) {
            this.bankaccount = bankaccount;
        }

        public String getBankname() {
            return bankname;
        }

        public void setBankname(String bankname) {
            this.bankname = bankname;
        }
    }
}
