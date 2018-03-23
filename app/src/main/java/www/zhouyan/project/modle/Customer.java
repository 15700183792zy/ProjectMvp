package www.zhouyan.project.modle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 15:35
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 15:35
 * 修改备注:
 */
@Entity(nameInDb = "ClientInfoes")
public class Customer implements Serializable {

    @Id
    @Property(nameInDb = "guid")
    private String guid;//id
    @Property(nameInDb = "lguid")
    private String lguid;//客户等级

    private String lname;//客户等级

    @Property(nameInDb = "rebate")
    private int rebate;//折扣

    private String cguid;//公司id
    @Property(nameInDb = "mobile")
    private String mobile;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "shortspell")
    private String shortspell;
    @Property(nameInDb = "areacode")
    private String areacode;
    @Property(nameInDb = "areaname")
    private String areaname;
    private String postcode;//邮编
    private String address;
    @Property(nameInDb = "contract")
    private String contract;//联系人
    @Property(nameInDb = "contractmobile")
    private String contractmobile;


    @Property(nameInDb = "firstletter")
    private String firstletter="0";
    @Property(nameInDb = "areanamefull")
    private String areanamefull;

    @Property(nameInDb = "clienttype")
    private int clienttype;
    private String remark;
    private int totalcount;
    private double totalamount;
    private int currcount;
    private double curramount;
    private double balance;
    private double initamount;
    private String spell;

    private String openbank;
    private String bankname;
    private String bankaccount;
    private String alipay;
    private String createtime;
    private String updatetime;
    private String weixin;//微信
    private String tel;//电话
    private boolean deleteflag;
    private int id;
    private boolean isstop;
    public boolean flag;

    private String lasttime;

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    @Generated(hash = 1386038786)
    public Customer() {
    }

    public String getFirstletter() {
        return firstletter;
    }

    public void setFirstletter(String firstletter) {
        this.firstletter = firstletter;
    }

    //shops
    private ArrayList<ClientShopList> shops;

    public ArrayList<ClientShopList> getShops() {
        return shops;
    }

    public void setShops(ArrayList<ClientShopList> shops) {
        this.shops = shops;
    }

    public double getInitamount() {
        return initamount;
    }

    public void setInitamount(double initamount) {
        this.initamount = initamount;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getClienttype() {
        return clienttype;
    }

    public void setClienttype(int clienttype) {
        this.clienttype = clienttype;
    }

    public boolean isstop() {
        return isstop;
    }

    public void setIsstop(boolean isstop) {
        this.isstop = isstop;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getLguid() {
        return lguid;
    }

    public void setLguid(String lguid) {
        this.lguid = lguid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getRebate() {
        return rebate;
    }

    public void setRebate(int rebate) {
        this.rebate = rebate;
    }

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getContractmobile() {
        return contractmobile;
    }

    public void setContractmobile(String contractmobile) {
        this.contractmobile = contractmobile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public int getCurrcount() {
        return currcount;
    }

    public void setCurrcount(int currcount) {
        this.currcount = currcount;
    }

    public double getCurramount() {
        return curramount;
    }

    public void setCurramount(double curramount) {
        this.curramount = curramount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getShortspell() {
        return shortspell;
    }

    public void setShortspell(String shortspell) {
        this.shortspell = shortspell;
    }

    public String getOpenbank() {
        return openbank;
    }

    public void setOpenbank(String openbank) {
        this.openbank = openbank;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "rebate=" + rebate +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", firstletter='" + firstletter + '\'' +
                '}';
    }
}
