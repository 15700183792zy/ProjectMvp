package www.zhouyan.project.modle;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 14:51
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 14:51
 * 修改备注: 保存公司信息
 */

public class CompanySave {
    private int id;//	是
    private String guid;//	是
    private String name;//	是
    private String remark;//	是
    private String tel;//	是
    private String fax;//	是
    private String email;//	是
    private String mobile;
    private String contract;//	是
    private String contractmob;//	是
    private String areacode;//	是
    private String areaname;//	是
    private String areanamefull;//	是
    private String postcode;//	是
    private String zonecode;//	是
    private String address;//	是
    private String logo;
    public CompanySave() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getContractmob() {
        return contractmob;
    }

    public void setContractmob(String contractmob) {
        this.contractmob = contractmob;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreanamefull() {
        return areanamefull;
    }

    public void setAreanamefull(String areanamefull) {
        this.areanamefull = areanamefull;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
