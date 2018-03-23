package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 18/1/31.
 */

public class ProStoreInfoV {
    //库存信息
    private  ArrayList<ProStoreInfo> stores;
    private ArrayList<Price> prices;

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
    }

    public ArrayList<ProStoreInfo> getStores() {
        return stores;
    }

    public void setStores(ArrayList<ProStoreInfo> stores) {
        this.stores = stores;
    }



    public  static class Price{
        private String colorguid;
        private String sizeguid;
        private double price;

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

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
}
