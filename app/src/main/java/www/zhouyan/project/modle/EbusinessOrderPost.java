package www.zhouyan.project.modle;

/**
 * Created by mac on 17/12/18.
 * 轨迹查询
 * <p>
 * 备注：R-必填（Required），O-可选（Optional），C-报文中该参数在一定条件下可选（Conditional）
 */


public class EbusinessOrderPost<T> {
    private T RequestData2;//需要 utf-8 编码
    private String RequestData; // R 请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致。
    private String EBusinessID; //R 商户ID，请在我的服务页面查看。
    private String RequestType; //R 1002 及时轨迹查询   1007 电子面单
    private String DataSign; //R md5加密 在需要加密utf-8
    private String DataType = "2"; // o 请求、返回数据类型：只支持JSON格式


    public T getRequestData2() {
        return RequestData2;
    }

    public void setRequestData2(T requestData) {
        RequestData2 = requestData;
    }

    public String getRequestData() {
        return RequestData;
    }

    public void setRequestData(String requestData) {
        RequestData = requestData;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getDataSign() {
        return DataSign;
    }

    public void setDataSign(String dataSign) {
        DataSign = dataSign;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    @Override
    public String toString() {
        return "{'RequestData':'" + RequestData + "'" +
                ", EBusinessID':'" + EBusinessID + "'" +
                ", DataType':'" + DataType + "'" +
                ", DataSign':'" + DataSign + "'" +
                ", RequestType':'" + RequestType + "'}";
    }
}
