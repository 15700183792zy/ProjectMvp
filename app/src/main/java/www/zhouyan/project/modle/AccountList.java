package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by zhouyan on 17/7/6.
 */

public class AccountList {
    

    private String guid;
    private String name;
    private int accountcount;//账户总个数
    private double accountamount;//账户总金额
    private ArrayList<AccountsBean> accounts;

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

    public int getAccountcount() {
        return accountcount;
    }

    public void setAccountcount(int accountcount) {
        this.accountcount = accountcount;
    }

    public double getAccountamount() {
        return accountamount;
    }

    public void setAccountamount(double accountamount) {
        this.accountamount = accountamount;
    }

    public ArrayList<AccountsBean> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<AccountsBean> accounts) {
        this.accounts = accounts;
    }

    public static class AccountsBean {

        private String sguid;
        private String guid;
        private double balanceamount;//账户 name 的当前余额
        private String name;
        private boolean isstop;
        private int id;

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isstop() {
            return isstop;
        }

        public void setIsstop(boolean isstop) {
            this.isstop = isstop;
        }

        public String getSguid() {
            return sguid;
        }

        public void setSguid(String sguid) {
            this.sguid = sguid;
        }

        public double getBalanceamount() {
            return balanceamount;
        }

        public void setBalanceamount(double balanceamount) {
            this.balanceamount = balanceamount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "AccountsBean{" +
                    "sguid='" + sguid + '\'' +
                    ", guid='" + guid + '\'' +
                    ", balanceamount=" + balanceamount +
                    ", name='" + name + '\'' +
                    ", isstop=" + isstop +
                    ", id=" + id +
                    '}';
        }
    }
}
