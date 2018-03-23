package www.zhouyan.project.modle;

/**
 * Created by mac on 17/12/18.
 * <p>
 * 快递鸟轨迹查询
 * http://www.kdniao.com/api-track
 */

public class EbusinessOrderBean {
    /**
     * OrderCode ： "订单编号"
     * ShipperCode ："快递公司编码"
     * LogisticCode ： "物流单号"
     */
    private String OrderCode;
    private String ShipperCode;
    private String LogisticCode;

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    @Override
    public String toString() {
        return "{'OrderCode':'','ShipperCode':'" + ShipperCode + "','LogisticCode':'" + LogisticCode + "'}";
    }
}
