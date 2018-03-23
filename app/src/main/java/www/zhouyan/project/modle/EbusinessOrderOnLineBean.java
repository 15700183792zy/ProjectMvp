package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/18.
 * <p>
 * 电子面单
 * http://www.kdniao.com/api-eorder
 * 备注：R-必填（Required），O-可选（Optional），C-报文中该参数在一定条件下可选（Conditional）
 */

public class EbusinessOrderOnLineBean {

    /**
     * OrderCode : 012657700387
     * ShipperCode : SF
     * PayType : 1
     * ExpType : 1
     * Cost : 1.0
     * OtherCost : 1.0
     * Sender : {"Company":"LV","Name":"Taylor","Mobile":"15018442396","ProvinceName":"上海","CityName":"上海","ExpAreaName":"青浦区","Address":"明珠路73号"}
     * Receiver : {"Company":"GCCUI","Name":"Yann","Mobile":"15018442396","ProvinceName":"北京","CityName":"北京","ExpAreaName":"朝阳区","Address":"三里屯街道雅秀大厦"}
     * Commodity : [{"GoodsName":"鞋子","Goodsquantity":1,"GoodsWeight":1}]
     * Weight : 1.0
     * Quantity : 1
     * Volume : 0.0
     * Remark : 小心轻放
     * IsReturnPrintTemplate : 1
     */

    private String CallBack;// o 用户自定义回调信息
    private String MemberID;// o 会员标识
    private String CustomerName;//o 	电子面单客户账号（与快递网点申请）
    private String CustomerPwd;//o 电子面单密码
    private String SendSite;//	o 收件网点标识
    private String OrderCode; //R 订单编号
    private String ShipperCode; //R 快递公司编码
    private String LogisticCode;//o 快递单号
    private String ThrOrderCode;//0 三方订单编号
    private String MonthCode;//c	月结编码
    private int PayType; //R 邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
    private int ExpType = 1; //R 快递类型：1-标准快件
    private int IsNotice;// o 是否通知快递员上门揽件：0-通知；1-不通知；不填则默认为0
    private double Cost; //o 寄件费（运费）
    private double OtherCost; // o其他费用
    private SenderBean Sender; //R
    private SenderBean Receiver; //R
    private String StartDate; //o StartDate  EndDate上门取货时间段:"yyyy-MM-dd HH:mm:ss"格式化，本文中所有时间格式相同
    private String EndDate;
    private double Weight;//o 物品总重量kg
    private int Quantity;//o 件数/包裹数
    private double Volume;//o 物品总体积m3
    private String Remark;//0 备注
    private int IsReturnPrintTemplate;//o 返回电子面单模板：0-不需要；1-需要
    private ArrayList<CommodityBean> Commodity;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getThrOrderCode() {
        return ThrOrderCode;
    }

    public void setThrOrderCode(String thrOrderCode) {
        ThrOrderCode = thrOrderCode;
    }

    public String getMonthCode() {
        return MonthCode;
    }

    public void setMonthCode(String monthCode) {
        MonthCode = monthCode;
    }

    public String getCallBack() {
        return CallBack;
    }

    public void setCallBack(String callBack) {
        CallBack = callBack;
    }

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPwd() {
        return CustomerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        CustomerPwd = customerPwd;
    }

    public String getSendSite() {
        return SendSite;
    }

    public void setSendSite(String sendSite) {
        SendSite = sendSite;
    }

    public int getIsNotice() {
        return IsNotice;
    }

    public void setIsNotice(int isNotice) {
        IsNotice = isNotice;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
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

    public int getPayType() {
        return PayType;
    }

    public void setPayType(int PayType) {
        this.PayType = PayType;
    }

    public int getExpType() {
        return ExpType;
    }

    public void setExpType(int ExpType) {
        this.ExpType = ExpType;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public double getOtherCost() {
        return OtherCost;
    }

    public void setOtherCost(double OtherCost) {
        this.OtherCost = OtherCost;
    }

    public SenderBean getSender() {
        return Sender;
    }

    public void setSender(SenderBean Sender) {
        this.Sender = Sender;
    }

    public SenderBean getReceiver() {
        return Receiver;
    }

    public void setReceiver(SenderBean Receiver) {
        this.Receiver = Receiver;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getVolume() {
        return Volume;
    }

    public void setVolume(double Volume) {
        this.Volume = Volume;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public int getIsReturnPrintTemplate() {
        return IsReturnPrintTemplate;
    }

    public void setIsReturnPrintTemplate(int IsReturnPrintTemplate) {
        this.IsReturnPrintTemplate = IsReturnPrintTemplate;
    }

    public ArrayList<CommodityBean> getCommodity() {
        return Commodity;
    }

    public void setCommodity(ArrayList<CommodityBean> Commodity) {
        this.Commodity = Commodity;
    }

    public static class SenderBean {
        /**
         * Company : LV
         * Name : Taylor
         * Mobile : 15018442396
         * ProvinceName : 上海
         * CityName : 上海
         * ExpAreaName : 青浦区
         * Address : 明珠路73号
         */

        private String Company; // o公司
        private String Name; //R 人
        private String Mobile;//R手机号
        private String PostCode;//0 邮编
        private String tel;//o 电话
        private String ProvinceName;//R省
        private String CityName;//R 市
        private String ExpAreaName;//o 区
        private String Address;//R地址

        public void setPostCode(String postCode) {
            PostCode = postCode;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCompany() {
            return Company;
        }

        public void setCompany(String Company) {
            this.Company = Company;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public String getProvinceName() {
            return ProvinceName;
        }

        public void setProvinceName(String ProvinceName) {
            this.ProvinceName = ProvinceName;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String CityName) {
            this.CityName = CityName;
        }

        public String getExpAreaName() {
            return ExpAreaName;
        }

        public void setExpAreaName(String ExpAreaName) {
            this.ExpAreaName = ExpAreaName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        @Override
        public String toString() {
            return "{'Company':'" + Company + "'," +
                    "'Name':'" + Name + "'," +
                    "'Mobile':'" + Mobile + "'," +
                    "'PostCode':'" + PostCode + "'," +
                    "'tel':'" + tel + "'," +
                    "'ProvinceName':'" + ProvinceName + "'," +
                    "'CityName':'" + CityName + "'," +
                    "'ExpAreaName':'" + ExpAreaName + "'," +
                    "'Address':'" + Address + "'}";
        }
    }


    public static class CommodityBean {
        /**
         * GoodsName : 鞋子
         * Goodsquantity : 1
         * GoodsWeight : 1.0
         */

        private String GoodsName; //R 商品名称
        private int Goodsquantity;//o 数量
        private double GoodsWeight;//o 重量

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String GoodsName) {
            this.GoodsName = GoodsName;
        }

        public int getGoodsquantity() {
            return Goodsquantity;
        }

        public void setGoodsquantity(int Goodsquantity) {
            this.Goodsquantity = Goodsquantity;
        }

        public double getGoodsWeight() {
            return GoodsWeight;
        }

        public void setGoodsWeight(double GoodsWeight) {
            this.GoodsWeight = GoodsWeight;
        }

        @Override
        public String toString() {
            return "{'GoodsName':'" + GoodsName + "'," +
                    "'Goodsquantity':" + Goodsquantity + "," +
                    "' GoodsWeight':" + GoodsWeight + "}";
        }
    }

    @Override
    public String toString() {
        return "{'OrderCode': '" + OrderCode + "'," +
                "'ShipperCode':'" + ShipperCode + "'," +
                "'PayType':" + PayType + "," +
                "'IsNotice':" + IsNotice + "," +
                "'ExpType':" + ExpType + "," +
                "'Cost':" + Cost + "," +
                "'OtherCost':" + OtherCost + "," +
                "'Sender':" + Sender + "," +
                "'Receiver':" + Receiver + "," +
                "'Commodity':" + Commodity + "," +
                "'Weight':" + Weight + "," +
                "'Quantity':" + Quantity + "," +
                "'Volume':" + Volume + "," +
                "'Remark':'" + Remark + "'," +
                "'IsReturnPrintTemplate':" + IsReturnPrintTemplate + "}";
    }
}

