package www.zhouyan.project.utils;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import www.zhouyan.project.app.MyApplication;
import www.zhouyan.project.manager.ConstantManager;


/**
 * Created by zhouyan on 2016/5/9.
 */
public class ToolPermisstionsUtils {

    private Context content;
    private static final ToolPermisstionsUtils INSTANCE = new ToolPermisstionsUtils();

    //获取单例
    public static ToolPermisstionsUtils getInstance(Context content) {
        ToolPermisstionsUtils.INSTANCE.setContent(content);
        return ToolPermisstionsUtils.INSTANCE;
    }

    public Context getContent() {
        return content;
    }

    public void setContent(Context content) {
        this.content = content;
    }

//    //销售单
//    //查看
//    public  boolean  sellorder_view(){
//        return getPermissions("sellorder_view");
//    }
//    // 开单
//    public  boolean  sellorder_save(){
//        return getPermissions("sellorder_save");
//    }
//    // 退货
//    public  boolean sellorder_return(){
//        return getPermissions("sellorder_return");
//    }
//    //撤销
//    public  boolean  sellorder_cancel(){
//        return getPermissions("sellorder_cancel");
//    }
//    //打印
//    public  boolean sellorder_print(){
//        return getPermissions("sellorder_print");
//    }
//    //临时打印
//    public  boolean sellorder_printtemp(){
//        return getPermissions("sellorder_printtemp");
//    }
//    //分享
//    public  boolean sellorder_share(){
//        return getPermissions("sellorder_share");
//    }
//
//    //采购单
//    //查看
//    public  boolean  buyorder_view(){
//        return getPermissions("buyorder_view");
//    }
//    //开单
//    public  boolean  buyorder_save(){return getPermissions("buyorder_save");}
//    // 退货
//    public  boolean buyorder_return(){
//        return getPermissions("buyorder_return");
//    }
//    //撤销
//    public  boolean  buyorder_cancel(){
//        return getPermissions("buyorder_cancel");
//    }
//    //打印
//    public  boolean buyorder_print(){
//        return getPermissions("buyorder_print");
//    }
//    //临时打印
//    public  boolean buyorder_printtemp(){
//        return getPermissions("buyorder_printtemp");
//    }
//    //分享
//    public  boolean buyorder_share(){
//        return getPermissions("buyorder_share");
//    }
//
//    //盘点单
//    //查看
//    public  boolean  checkorder_view(){
//        return getPermissions("checkorder_view");
//    }
//    //开单
//    public  boolean  checkorder_save(){
//        return getPermissions("checkorder_save");
//    }
//    //打印
//    public  boolean checkorder_print(){
//        return getPermissions("checkorder_print");
//    }
//    //临时打印
//    public  boolean checkorder_printtemp(){
//        return getPermissions("checkorder_printtemp");
//    }
//
//    //调拨单
//    //查看
//    public  boolean  allocationorder_view(){
//        return getPermissions("allocationorder_view");
//    }
//    //开单
//    public  boolean  allocationorder_save(){
//        return getPermissions("allocationorder_save");
//    }
//
//    //撤销
//    public  boolean  allocationorder_cancel(){
//        return getPermissions("allocationorder_cancel");
//    }
//
//    //入库
//    public  boolean allocationorder_accept(){
//        return getPermissions("allocationorder_accept");
//    }
//    //打印
//    public  boolean allocationorder_print(){
//        return getPermissions("allocationorder_print");
//    }
//    //临时打印
//    public  boolean allocationorder_printtemp(){return getPermissions("allocationorder_printtemp");}
//
//
//    //商品
//    //编辑
//    public  boolean  product_edit(){
//        return getPermissions("product_edit");
//    }
//    // 成本价
//    public  boolean  product_costprice(){
//        return getPermissions("product_costprice");
//    }
//    // sku
//    public  boolean product_sku(){
//        return getPermissions("product_sku");
//    }
//    //图片
//    public  boolean  product_image(){
//        return getPermissions("product_image");
//    }
//    //颜色
//    public  boolean product_color(){
//        return getPermissions("product_color");
//    }
//    //尺码
//    public  boolean product_size(){
//        return getPermissions("product_size");
//    }
//    //属性字典
//    public  boolean product_property(){
//        return getPermissions("product_property");
//    }
//
//
//
//
//    //店铺
//    // 查看
//    public  boolean  shop_view(){
//        return getPermissions("shop_view");
//    }
//    //编辑
//    public  boolean  shop_edit(){
//        return getPermissions("shop_edit");
//    }
//
//    // 结算账户
//    public  boolean shop_account(){
//        return getPermissions("shop_account");
//    }
//    //打印设置
//    public  boolean  shop_print(){
//        return getPermissions("shop_print");
//    }
//    //停用
//    public  boolean shop_stop(){
//        return getPermissions("shop_stop");
//    }
//    //所有门店
//    public  boolean shop_all(){
//        return getPermissions("shop_all");
//    }
//
//
//    //店铺
//    // 查看
//    public  boolean  user_view(){
//        return getPermissions("user_view");
//    }
//    //编辑
//    public  boolean  user_edit(){
//        return getPermissions("user_edit");
//    }
//    //权限设置
//    public  boolean  user_right(){
//        return getPermissions("user_right");
//    }
//    //停用
//    public  boolean user_stop(){
//        return getPermissions("user_stop");
//    }
//    //所有门店
//    public  boolean user_all(){
//        return getPermissions("user_all");
//    }
//
//
//
//    //客户
//    //查看
//    public  boolean  customer_view(){
//        return getPermissions("customer_view");
//    }
//    // 开单
//    public  boolean  customer_edit(){
//        return getPermissions("customer_edit");
//    }
//    // 停止
//    public  boolean customer_stop(){
//        return getPermissions("customer_stop");
//    }
//    //等级
//    public  boolean  customer_level(){
//        return getPermissions("customer_level");
//    }
//    //对账
//    public  boolean customer_account(){
//        return getPermissions("customer_account");
//    }
//    //对账 单分享
//    public  boolean customer_share(){
//        return getPermissions("customer_share");
//    }
//    //回款
//    public  boolean customer_fee(){
//        return getPermissions("customer_fee");
//    }
//
//
//    //供应商
//    //查看
//    public  boolean  supply_view(){
//        return getPermissions("supply_view");
//    }
//    // 开单
//    public  boolean  supply_edit(){return getPermissions("supply_edit");}
//    // 停止
//    public  boolean supply_stop(){
//        return getPermissions("supply_stop");
//    }
//    //等级
//    public  boolean  supply_level(){
//        return getPermissions("supply_level");
//    }
//    //对账
//    public  boolean supply_account(){
//        return getPermissions("supply_account");
//    }
//    //对账分享
//    public  boolean supply_share(){
//        return getPermissions("supply_share");
//    }
//    //打款
//    public  boolean supply_fee(){
//        return getPermissions("supply_fee");
//    }
//
//
//    //财务
//    //日结查看
//    public  boolean  finance_datesettleview(){
//        return getPermissions("finance_datesettleview");
//    }
//    // 日结操作
//    public  boolean  finance_datesettleoption(){return getPermissions("finance_datesettleoption");}
//    // 账目类型维护
//    public  boolean finance_accountedit(){
//        return getPermissions("finance_accountedit");
//    }
//    //账务查看
//    public  boolean  finance_accountview(){
//        return getPermissions("finance_accountview");
//    }
//    //记一笔
//    public  boolean finance_feeedit(){
//        return getPermissions("finance_feeedit");
//    }
//
//
//    //报表
//    //销售报表
//    public  boolean  report_sell(){
//        return getPermissions("report_sell");
//    }
//    // 采购报表
//    public  boolean  report_buy(){
//        return getPermissions("report_buy");
//    }
//    // 调拨报表
//    public  boolean report_allocation(){
//        return getPermissions("report_allocation");
//    }
//    //盘点报表
//    public  boolean  report_check(){
//        return getPermissions("report_check");
//    }
//    //库存报表
//    public  boolean report_accountedit(){
//        return getPermissions("report_accountedit");
//    }
//
//
//
//    //系统
//    //公司信息
//    public  boolean  sys_company(){
//        return getPermissions("sys_company");
//    }
//    // 系统设置
//    public  boolean  sys_config(){
//        return getPermissions("sys_config");
//    }

    /*
                                     销售单
    sellorder_view,                                 查看 ok
    sellorder_save,                                 开单 ok
    sellorder_return,                               退货 ok
    sellorder_cancel,                               撤销 ok
    sellorder_print,                                打印 ok
    sellorder_printtemp,                            临时打印 ok
    sellorder_share,                                分享 ok
                                     采购单
    buyorder_view,                                  查看ok
    buyorder_save,                                  开单 ok
    buyorder_return,                                退货ok
    buyorder_cancel,                                撤销ok
    buyorder_print,                                 打印ok
    buyorder_printtemp,                             临时打印 ok
    buyorder_share,                                 分享ok
                                     盘点单
    checkorder_view,                                查看ok
    checkorder_save,                                开单 ok
    checkorder_print,                               打印ok
    checkorder_printtemp,                           临时打印 ok
                                     调拨单
    allocationorder_view,                           查看ok
    allocationorder_save,                           开单ok
    allocationorder_cancel,                         撤销ok
    allocationorder_accept,                         入库ok
    allocationorder_print,                          打印ok
    allocationorder_printtemp,                      临时打印 ok

                                     商品
    product_edit,                                   编辑 ok
    product_costprice,                              成本价 true 有成本价
    product_sku,                                    SKU    ok
    product_image,                                  商品图片 ok
    product_color,                                  颜色字典 ok
    product_size,                                   尺码字典 ok
    product_property,                               属性字典 ok
    product_stop,                                   停用 ok
    product_customerpriceset                        客户价格设置
    product_supplierpriceset                        供应商价格设置
                                     店铺
    shop_view,                                      查看
    shop_edit,                                      编辑 ok
    shop_account,                                   结算账户 ok
    shop_print,                                     打印设置 ok
    shop_stop,                                      停用 ok
    shop_all,                                       所有门店
                                     员工
    user_view,                                      查看
    user_edit,                                      编辑 ok
    user_stop,                                      停用 无
    user_all,                                       所有员工
    user_right,                                     权限设置 ok

                                     客户
    customer_view,                                  查看
    customer_edit,                                  编辑 ok
    customer_stop,                                  停用 ok
    customer_level,                                 等级维护 ok
    customer_account,                               对账 ok
    customer_share,                                 对账单分享 ok
    customer_fee,                                   客户回款 ok
    customer_init,                                  期初调整ok
                                     供应商
    supply_view,                                    查看
    supply_edit,                                    编辑 ok
    supply_stop,                                    停用 ok
    supply_level,                                   等级维护 ok
    supply_account,                                 对账 ok
    supply_share,                                   对账单分享 ok
    supply_fee,                                     供应商打款 ok
    supply_init,                                    期初调整 ok
                                     财务
    finance_datesettleview,                         日结查看 ok
    finance_datesettleoption,                       日结操作 ok
    finance_typeedit,                               账目类型维护 ok
    finance_accountedit,                            账户编辑 ok
    finance_accountview,                            账务查看 -> 流水
    finance_feeedit,                                记一笔 ok
                                     报表
    report_sell,                                    销售报表 ok
    report_buy,                                     采购报表 ok
    report_allocation,                              调拨报表 ok
    report_check,                                   盘点报表 ok
    report_store,                                   库存报表 ok
    report_summary,                                 业务汇总 ok

                                     系统
    sys_company,                                    公司信息 ok
    sys_config                                      系统设置 ok
    sys_role                                        角色管理 ok
     */



    //    //表示是否存在改权限
//    public int getIndex(String permisstionString){
//        if (MyApplication.getInstance().isOffline()) {
//            return -1;
//        }
//        String roleString = ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "rolestring");
//        if (roleString.equals("1")) {
//            return -1;
//        } else {
//            ArrayList<String> permissionIds = ToolGson.jsonToBean(roleString, ArrayList.class);
//            if (permissionIds != null) {
//                int size = permissionIds.size();
//                for (int i = 0; i < size; i++) {
//                    if (permisstionString.toLowerCase().equals(permissionIds.get(i).trim().toLowerCase())) {
//                        return i;
//                    }
//                }
//            }
//        }
//        return -1;
//    }
    public boolean getPermissions(String permisstionString) {
        if (MyApplication.getInstance().isOffline()) {
            return true;
        }
        String roleString = ToolFile.getString(ToolFile.getString(ConstantManager.SP_USER_NAME) + "rolestring");
        if (roleString.equals("1")) {
            return false;
        } else {
            ArrayList<String> permissionIds = ToolGson.jsonToBean(roleString, ArrayList.class);
            if (permissionIds != null)
                for (String str : permissionIds) {
                    if (permisstionString.toLowerCase().equals(str.toString().toLowerCase())) {
                        return true;
                    }
                }
        }


        return false;
    }


}
