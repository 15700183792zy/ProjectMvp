package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * Created by mac on 17/12/18.
 * * 快递鸟轨迹查询
 * EBusinessID	String	用户ID	R
 * OrderCode	String	订单编号	O
 * ShipperCode	String	快递公司编码	R
 * LogisticCode	String	物流运单号	O
 * Success	Bool	成功与否	R
 * Reason	String	失败原因	O
 * State	String	物流状态：2-在途中,3-签收,4-问题件	R
 * Traces
 * AcceptTime	String	时间	R
 * AcceptStation	String	描述	R
 * Remark	String	备注
 */

public class EbusinessOrderHandle {
    private String LogisticCode;//物流运单号
    private String ShipperCode;//快递公司编码
    private String State; //物流状态：2-在途中,3-签收,4-问题件
    private String EBusinessID; //用户ID
    private boolean Success;//成功与否
    private ArrayList<TracesBean> Traces;
    private String Reason;//失败原因
    private String OrderCode;//订单编号
    private String AcceptTime;//时间
    private String AcceptStation;//描述
    private String Remark;//备注

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String ShipperCode) {
        this.ShipperCode = ShipperCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
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

    public ArrayList<TracesBean> getTraces() {
        return Traces;
    }

    public void setTraces(ArrayList<TracesBean> Traces) {
        this.Traces = Traces;
    }

    public static class TracesBean {
        /**
         * AcceptStation : 已取件，离开 [河南_周口分拨站] 发往 [郑州基地]
         * AcceptTime : 2017-12-11 18:45:19
         */

        private String AcceptStation;
        private String AcceptTime;
        private String Remark;

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String remark) {
            Remark = remark;
        }

        public String getAcceptStation() {
            return AcceptStation;
        }

        public void setAcceptStation(String AcceptStation) {
            this.AcceptStation = AcceptStation;
        }

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }

        @Override
        public String toString() {
            return "TracesBean{" +
                    "AcceptStation='" + AcceptStation + '\'' +
                    ", AcceptTime='" + AcceptTime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EbusinessOrderHandle{" +
                "LogisticCode='" + LogisticCode + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", State='" + State + '\'' +
                ", EBusinessID='" + EBusinessID + '\'' +
                ", Success=" + Success +
                ", Traces=" + Traces +
                '}';
    }
}
