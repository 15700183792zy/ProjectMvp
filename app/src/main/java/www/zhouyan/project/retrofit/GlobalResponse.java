package www.zhouyan.project.retrofit;


/**
 * Title : 全局响应
 * Author : zhouyan
 */
public class GlobalResponse<T> {
    public String message;
    public int code;
    public T data;
    public int totalcount;//条目数量

//    ret,		//状态代码	int	1: 成功, 2: 失败, 4: 出错
//    msg,		//返回信息	string
//    code,	//错误代码	int
//    total ,	//数据总量	int	如果有父子级, 只表示根级数量
//    data		//返回数据	json


    @Override
    public String toString() {
        return "GlobalResponse{" +
                "msg='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}