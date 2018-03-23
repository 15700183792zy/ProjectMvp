package www.zhouyan.project.modle;


import java.util.ArrayList;

/**
 * 登录信息
 */
public class LoginResponse {

    private String cid;
    private String cguid;
    private String servicetime;
    private String apihost;
    private String mac;//需要保存
    private String sguid;//默认门店id
    private String sname;//默认门店名称
    private String areacodetime;
    private String cname;
    private String uname;
    private ArrayList<CompanyConfigs> configs;
    private String mobile;
    private ArrayList<String> rolestring;
    private String clientid;//个推的clientid

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public ArrayList<String> getRolestring() {
        return rolestring;
    }

    public void setRolestring(ArrayList<String> rolestring) {
        this.rolestring = rolestring;
    }

    public ArrayList<CompanyConfigs> getConfigs() {
        return configs;
    }

    public void setConfigs(ArrayList<CompanyConfigs> configs) {
        this.configs = configs;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setSname(String sname){
        this.sname=sname;
    }

    public String getSname(){return  sname;}


    public String getSguid() {
        return sguid;
    }

    public void setSguid(String sguid) {
        this.sguid = sguid;
    }

    public String getAreacodetime() {
        return areacodetime;
    }

    public void setAreacodetime(String areacodetime) {
        this.areacodetime = areacodetime;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime;
    }

    public String getApihost() {
        return apihost;
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}