package www.zhouyan.project.modle;

/**
 * Created by mac on 17/12/18.
 */

public class EbusinessOrderOnLineHandle {


    private String EBusinessID; //用户ID
    private OrderBean Order;
    private boolean Success;//	成功与否	R
    private String ResultCode;//	错误编码	R
    private String Reason;//	失败原因	O
    private String UniquerRequestNumber;//	唯一标识	R
    private String PrintTemplate;//	面单打印模板	O
    private String EstimatedDeliveryTime;//	订单预计到货时间yyyy-mm-dd	O
    private String Callback;//	用户自定义回调信息	O


    public String getEstimatedDeliveryTime() {
        return EstimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        EstimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getCallback() {
        return Callback;
    }

    public void setCallback(String callback) {
        Callback = callback;
    }


    public String getUniquerRequestNumber() {
        return UniquerRequestNumber;
    }

    public void setUniquerRequestNumber(String uniquerRequestNumber) {
        UniquerRequestNumber = uniquerRequestNumber;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public OrderBean getOrder() {
        return Order;
    }

    public void setOrder(OrderBean Order) {
        this.Order = Order;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String ResultCode) {
        this.ResultCode = ResultCode;
    }

    public String getPrintTemplate() {
        return PrintTemplate;
    }

    public void setPrintTemplate(String PrintTemplate) {
        this.PrintTemplate = PrintTemplate;
    }

    public static class OrderBean {
        /**
         * OrderCode : 012657700387
         * ShipperCode : SF
         * LogisticCode : 444032185113
         * OriginCode : 021
         * DestinatioCode : 010
         * KDNOrderCode : KDN1712181500000248
         */

        private String OrderCode;//	订单编号	R
        private String ShipperCode;//	快递公司编码	R
        private String LogisticCode;//	快递单号	R
        private String MarkDestination;//	大头笔	O
        private String OriginCode;//	始发地区域编码	O
        private String OriginName;//	始发地/始发网点	O
        private String DestinatioCode;//	目的地区域编码	O
        private String DestinatioName;//	目的地/到达网点	O
        private String SortingCode;//	分拣编码	O
        private String PackageCode;//	集包编码	O
        private String KDNOrderCode;//
        public String getMarkDestination() {
            return MarkDestination;
        }

        public void setMarkDestination(String markDestination) {
            MarkDestination = markDestination;
        }

        public String getOriginName() {
            return OriginName;
        }

        public void setOriginName(String originName) {
            OriginName = originName;
        }

        public String getDestinatioName() {
            return DestinatioName;
        }

        public void setDestinatioName(String destinatioName) {
            DestinatioName = destinatioName;
        }

        public String getSortingCode() {
            return SortingCode;
        }

        public void setSortingCode(String sortingCode) {
            SortingCode = sortingCode;
        }

        public String getPackageCode() {
            return PackageCode;
        }

        public void setPackageCode(String packageCode) {
            PackageCode = packageCode;
        }

        public String getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(String OrderCode) {
            this.OrderCode = OrderCode;
        }

        public String getShipperCode() {
            return ShipperCode;
        }

        public void setShipperCode(String ShipperCode) {
            this.ShipperCode = ShipperCode;
        }

        public String getLogisticCode() {
            return LogisticCode;
        }

        public void setLogisticCode(String LogisticCode) {
            this.LogisticCode = LogisticCode;
        }

        public String getOriginCode() {
            return OriginCode;
        }

        public void setOriginCode(String OriginCode) {
            this.OriginCode = OriginCode;
        }

        public String getDestinatioCode() {
            return DestinatioCode;
        }

        public void setDestinatioCode(String DestinatioCode) {
            this.DestinatioCode = DestinatioCode;
        }

        public String getKDNOrderCode() {
            return KDNOrderCode;
        }

        public void setKDNOrderCode(String KDNOrderCode) {
            this.KDNOrderCode = KDNOrderCode;
        }

        @Override
        public String toString() {
            return "OrderBean{" +
                    "OrderCode='" + OrderCode  +
                    ", ShipperCode='" + ShipperCode  +
                    ", LogisticCode='" + LogisticCode  +
                    ", MarkDestination='" + MarkDestination  +
                    ", OriginCode='" + OriginCode  +
                    ", OriginName='" + OriginName  +
                    ", DestinatioCode='" + DestinatioCode  +
                    ", DestinatioName='" + DestinatioName  +
                    ", SortingCode='" + SortingCode  +
                    ", PackageCode='" + PackageCode  +
                    ", KDNOrderCode='" + KDNOrderCode  +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EbusinessOrderOnLineHandle{" +
                "EBusinessID='" + EBusinessID  +
                ", Order=" + Order +
                ", Success=" + Success +
                ", ResultCode='" + ResultCode  +
                ", Reason='" + Reason  +
                ", UniquerRequestNumber='" + UniquerRequestNumber  +
                ", EstimatedDeliveryTime='" + EstimatedDeliveryTime  +
                ", Callback='" + Callback  +
                '}';
    }
}
