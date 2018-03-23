package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/11/13.
 */

public class ClientInitAmountSet {
    //shops
    private ArrayList<ClientShopList> shops;//sguid,sname,initamount
    private int clienttype;//	int	是	1客户，2供应商
    private String clientguid;//	string	是

    public ArrayList<ClientShopList> getShops() {
        return shops;
    }

    public void setShops(ArrayList<ClientShopList> shops) {
        this.shops = shops;
    }

    public int getClienttype() {
        return clienttype;
    }

    public void setClienttype(int clienttype) {
        this.clienttype = clienttype;
    }

    public String getClientguid() {
        return clientguid;
    }

    public void setClientguid(String clientguid) {
        this.clientguid = clientguid;
    }
}
