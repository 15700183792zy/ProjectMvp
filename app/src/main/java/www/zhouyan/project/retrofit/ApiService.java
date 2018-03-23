package www.zhouyan.project.retrofit;


import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;
import www.zhouyan.project.modle.*;

/**
 * Title : 接口地址
 */
public interface ApiService {
    //微信登录

    //拿到openid
    @GET("oauth2/access_token")
    Call<WXAccessTokenInfo> access_token(@Query("appid") String appid,
                                         @Query("secret") String secret,
                                         @Query("code") String code,
                                         @Query("grant_type") String grant_type);


    //获取用户信息
    //拿到openid
    @GET("userinfo")
    Call<WXUserInfo> userinfo(@Query("access_token") String access_token,
                              @Query("openid") String openid);

    //上传图片
    @Multipart
    @POST("Save")
    Observable<GlobalResponse<ArrayList<PicturePostBack>>> upload(@Part("description") RequestBody description,
                                                                  @Query("mid") int mid,
                                                                  @Query("sysid") int sysid,
                                                                  @Part MultipartBody.Part file);


    //获取手机号归属地 GetMobileAddress http://apis.juhe.cn/mobile/get?phone=15514516206&key=e7ba5e6e98b3d5f0ae1c1afc4cba59a0
    @GET("mobile/get")
    Call<MobileAddress> GetMobileAddress(@Query("phone") String phone,
                                         @Query("key") String key);

    //注册同步
    //登录
    @POST("app/Login")
    Observable<GlobalResponse<LoginResponse>> Login(@Body LoginPost loginPost);

    //检测更新版本
    @POST("app/VersionVertify")
    Observable<GlobalResponse<UpdateResponse>> VersionVertify(@Query("ostype") String ostype
            , @Query("version") String version);


    //获取手机验证码
    @GET("app/GetIdentityCode")
    Observable<GlobalResponse> GetIdentityCode(@Query("mobile") String mobile);

    //app/UpDateUserWXInfo 更新微信信息
    @POST("app/UpDateUserWXInfo")
    Observable<GlobalResponse> UpDateUserWXInfo(@Body UpDateUserWXInfo upDateUserWXInfo);

    //app/GetUserWXInfo 获得用户的微信信息
    @GET("app/GetUserWXInfo")
    Observable<GlobalResponse<UpDateUserWXInfo>> GetUserWXInfo(@Query("mobile") String mobile);

    //app/UpDateGTClientID 更新个推的客户号信息
    //判断接收个推clientid与登录拿到的cliendId的是否一致，不一致更新接口
    @GET("app/UpDateGTClientID")
    Observable<GlobalResponse> UpDateGTClientID(@Query("mobile") String mobile,
                                                @Query("clientid") String clientid);

    //忘记密码 ForgetPwd
    @POST("app/ForgetPwd")
    Observable<GlobalResponse> ForgetPwd(@Body ForgetChange forgetChange);

    //忘记密码 ForgetPwd
    @POST("app/PwdChange")
    Observable<GlobalResponse> PwdChange(@Body PwdChange forgetChange);


    //	行业分类列表 CategoryList
    @GET("app/CategoryList")
    Observable<GlobalResponse<ArrayList<CategoryList>>> CategoryList();

    //创建一个公司 CreateCompany
    @POST("app/CreateCompany")
    Observable<GlobalResponse> CreateCompany(
            @Body Company company
    );


    //同步信息 SyncData
    @GET("app/SyncData")
    Observable<GlobalResponse<SyncData>> SyncData(@Query("areatime") String areatime,
                                                  @Query("cid") String cid,
                                                  @Query("synctime") String synctime);

    //删除员工
    @GET("app/DeleteUser")
    Observable<GlobalResponse> DeleteUser(@Query("mobile") String mobile);

    //新建员工
    @POST("app/adduser")
    Observable<GlobalResponse> adduser(@Body UserInfo addUser);


    //初始化行政区划, 直接返回sqlite库 InitAreaCode
    @GET("app/InitAreaCode")
    Observable<Response<ResponseBody>> InitAreaCode();

    //公司管理 发送验证码到公司注册人
    @GET("company/GetCompanySmsCode")
    Observable<GlobalResponse> GetCompanySmsCode();

    //初始化数据
    @POST("company/DataInit")
    Observable<GlobalResponse> DataInit(@Body DataInit dataInit);

    //记录用户打印机设置的ip地址
    @POST("company/UserPrintIPSet_V1")
    Observable<GlobalResponse> UserPrintIPSet(@Body ArrayList<UserPrintIPGet> userPrintIPGet);

    @GET("company/UserPrintIPGet_V2")
    Observable<GlobalResponse<ArrayList<UserPrintIPGet>>> UserPrintIPGet();

    @GET("company/UserPrintIPGetByType")
    Observable<GlobalResponse<String>> UserPrintIPGetByType(@Query("printtype") String printtype);

    //打印测试
    @GET("/company/PrintTest")
    Observable<Response<ResponseBody>> PrintTest(@Query("printtype") String printtype);

    //保存公司信息 company/CompanySave
    @POST("company/CompanySave")
    Observable<GlobalResponse> CompanySave(@Body CompanySave companySave);

    //公司简要信息
    @GET("company/CompanySimpleInfo")
    Observable<GlobalResponse<CompanySave>> CompanySimpleInfo();

    //公司信息
    @GET("company/CompanyInfo")
    Observable<GlobalResponse<CompanySave>> CompanyInfo();


    //获取系统设置保存
    @POST("company/CompanyConfigSave")
    Observable<GlobalResponse> CompanyConfigSave(@Body CompanyConfigs companyConfigs, @Query("issure") boolean issure);

    //获得角色列表
    @GET("company/RoleGroupList")
    Observable<GlobalResponse<ArrayList<RoleGroupList>>> RoleGroupList();

    //获得角色的权限信息
    @GET("company/RoleGroupInfo")
    Observable<GlobalResponse<RoleGroupInfoSave>> RoleGroupInfo(@Query("id") String id);

    //删除一个角色
    @GET("company/RoleGroupDelete")
    Observable<GlobalResponse> RoleGroupDelete(@Query("id") String id);

    //角色复制
    @POST("company/RoleGroupCopy")
    Observable<GlobalResponse<RoleGroupInfoSave>> RoleGroupCopy(@Body RoleGroupCopy po);

    //角色权限保存
    @POST("company/RoleGroupSaveRole")
    Observable<GlobalResponse<RoleGroupInfoSave>> RoleGroupSaveRole(@Body RoleGroupInfoSave json);


    //获得用户权限
    @GET("company/UserRoleInfo")
    Observable<GlobalResponse<RoleGroupInfoSave>> UserRoleInfo(@Query("mobile") String mobile);

    //用户权限保存
    @POST("company/UserRoleSave")
    Observable<GlobalResponse<SaveRoleBack>> UserRoleSave(@Body RoleGroupInfoSave json);

    //不同功能的启用、停用商店 = 1, 客户 = 2, 供应商 = 3, 科目 = 4, 商品 = 5,
    @POST("company/StopOrOpen")
    Observable<GlobalResponse> StopOrOpen(@Body StopOrOpen stopOrOpen);


    //门店员工
    //shoplist 获取门店列表
    @GET("shop/shoplist")
    Observable<GlobalResponse<ArrayList<Shop>>> shoplist(@Query("key") String key,
                                                         @Query("querytype") String issale);

    @GET("shop/ShopPrintConfigInfo")
    Observable<GlobalResponse<ShowPrintRemarkInfo>> ShopPrintConfigInfo(@Query("sguid") String sguid,
                                                                        @Query("ordertype") String ordertype);

    @POST("shop/ShopPrintConfigSave")
    Observable<GlobalResponse> ShopPrintConfigSave(@Body ShowPrintRemarkInfo showPrintRemarkInfo);

    //shopinfo 获取门店信息
    @GET("shop/shopinfo")
    Observable<GlobalResponse<ShopInfo>> shopinfo(@Query("guid") String guid);

    //shopinfo 获取门店信息
    @GET("shop/shopdelete")
    Observable<GlobalResponse<ShopInfo>> shopdelete(@Query("guid") String guid);


    //保存门店信息   需要认证
    @POST("shop/ShopSave")
    Observable<GlobalResponse<ShopInfo>> ShopSave(@Body ShopInfo shopSave);

    //获取用户列表
    @GET("shop/UserList")
    Observable<GlobalResponse<ArrayList<User>>> UserList(@Query("key") String key);

    //更新用户信息
    @POST("shop/UserUpDate")
    Observable<GlobalResponse> UserUpDate(@Body UserInfo addUser);

    //用户信息
    @GET("shop/UserInfo")
    Observable<GlobalResponse<UserInfo>> UserInfo(@Query("mobile") String mobile);

    //门店停用
    @GET("shop/ShopStop")
    Observable<GlobalResponse> ShopStop(@Query("guid") String guid);

    //门店停用
    @GET("shop/ShopStart")
    Observable<GlobalResponse> ShopStart(@Query("guid") String guid);

    //修改员工名称
    @GET("shop/UserChangeName")
    Observable<GlobalResponse> UserChangeName(@Query("name") String name);


    //合作伙伴

    //获取客户等级列表
    @GET("Client/LevelList")
    Observable<GlobalResponse<ArrayList<Level>>> LevelList(@Query("clienttype") String clienttype);

    //获取客户默认等级
    @GET("Client/GetDefaultLevel")
    Observable<GlobalResponse<Level>> GetDefaultLevel(@Query("clienttype") String clienttype); //1客户 2供应商

    //获取客户等级保存
    @POST("Client/LevelSave")
    Observable<GlobalResponse> LevelSave(@Body ArrayList<Level> level);

    //client/LevelCanDelete
    //等级是否能删除
    @GET("Client/LevelCanDelete")
    Observable<GlobalResponse> LevelCanDelete(@Query("guid") String guid);


    //带有高级搜索的 合作伙伴列表 client/ClientList_Advance
    @POST("Client/ClientList_Advance")
    Observable<GlobalResponse<CustomerListSource>> ClientList_Advance(@Body PostClientListSource PostClientListSource);

    //带有高级搜索的 合作伙伴列表 client/ClientList_Advance
    @POST("Client/ClientList_Advance_V1")
    Observable<GlobalResponse<CustomerListSource>> ClientList_Advance_V1(@Body PostClientListSource PostClientListSource);

    //修改合作伙伴的余额、期初金额
    @POST("Client/ClientInitAmountSet")
    Observable<GlobalResponse<ClientInitBack>> ClientInitAmountSet(@Body ClientInitAmountSet clientInitAmountSet);

    //获取客户信息列表 clienttype1,客户，2供应商
    @GET("Client/ClientInfo")
    Observable<GlobalResponse<Customer>> ClientInfo(@Query("guid") String guid, @Query("clienttype") String clienttype);

    //获取客户信息列表 clienttype1,客户，2供应商
    @GET("Client/ClientDelete")
    Observable<GlobalResponse> ClientDelete(@Query("guid") String guid, @Query("clienttype") String clienttype);

    //获取客户保存
    @GET("client/ClientShopList")
    Observable<GlobalResponse<ArrayList<ClientShopList>>> ClientShopList(@Query("clientguid") String clientguid,
                                                                         @Query("clienttype") int clienttype);

    //获得合作伙伴在某个门店的当前信息(期初，余额等)
    @GET("client/ClientShopInfo_V1")
    Observable<GlobalResponse<ClientShopList>> ClientShopInfo_V1(@Query("clientguid") String clientguid,
                                                                 @Query("sguid") String sguid);

    //获取客户保存
    @POST("client/ClientSave")
    Observable<GlobalResponse<Customer>> ClientSave(@Body Customer customer);

    //导入通讯录
    @POST("client/ClientImportBatch")
    Observable<GlobalResponse<ArrayList<BulkImport>>> ClientImportBatch(@Body PostClientImportBatch customers);

    //合作伙伴账目类型选择
    @GET("client/ClientFeeDictSelect")
    Observable<GlobalResponse<ArrayList<UsersBean>>> ClientFeeDictSelect(@Query("clienttype") String clienttype);

    //客户对账 供应商对账
    @GET("client/ClientFeeInfoList")
    Observable<GlobalResponse<AccountFlow>> ClientFeeInfoList(@Query("clientguid") String clientguid,
                                                              @Query("clienttype") String clienttype,
                                                              @Query("fguid") String fguid,
                                                              @Query("sguid") String sguid,
                                                              @Query("bdate") String bdate,
                                                              @Query("edate") String edate,
                                                              @Query("pageindex") String pageindex,
                                                              @Query("pagesize") String pagesize,
                                                              @Query("showcancel") String showcancel);

    //合作伙伴对账详情
    @GET("client/ClientFeeInfo")
    Observable<GlobalResponse<ClientFeeInfo>> ClientFeeInfo(@Query("id") String id);


    //产品管理

    //产品列表
    @GET("Product/ProductList")
    Observable<GlobalResponse<ArrayList<Goodsinfo>>> ProductList(@Query("key") String key,
                                                                 @Query("querytype") String querytype,
                                                                 @Query("pageindex") String pageindex,
                                                                 @Query("pagesize") String pagesize);

    //产品列表
    @POST("Product/ProductList_Advance")
    Observable<GlobalResponse<ArrayList<Goodsinfo>>> ProductList_Advance(@Body ProductList searchBean);

    //获取供应商信息保存
    @POST("Product/ProductSave_v1")
    Observable<GlobalResponse<Goodsinfo>> ProductSave(@Body Goodsinfo goodsinfo);

    //获取商品信息列表
    @GET("Product/ProductInfo")
    Observable<GlobalResponse<Goodsinfo>> ProductInfo(@Query("guid") String guid, @Query("querytype") String querytype);

    //商品删除
    @GET("Product/ProductDelete")
    Observable<GlobalResponse> ProductDelete(@Query("guid") String guid);

    // //产品库存信息
    @GET("Product/ProStoreInfo_v1")
    Observable<GlobalResponse<ProStoreInfoV>> ProStoreInfo_v1(@Query("pguid") String pguid,
                                                              @Query("sguid") String sguid,
                                                              @Query("clientguid") String clientguid);

    //产品库存信息
    @POST("Product/ProStore_Advance")
    Observable<GlobalResponse<ProStoreAll>> ProStore_Advance(@Body SearchStock searchBean);

    //	字典列表
    @GET("Product/ProDictList")
    Observable<GlobalResponse<ArrayList<PicDictSave>>> ProDictList(@Query("dtype") String dtype,
                                                                   @Query("querytype") String querytype);

    //	常用的字典列表
    @GET("Product/ProDictCommon")
    Observable<GlobalResponse<PicDictSave>> ProDictCommon(@Query("dtype") String dtype,
                                                          @Query("querytype") String querytype);

    //	获取大类的字典列表
    @GET("Product/GetParentProDicts")
    Observable<GlobalResponse<ArrayList<PicDictSave>>> GetParentProDicts(@Query("dtype") String dtype);

    //	字典保存
    @POST("Product/ProDictSave")
    Observable<GlobalResponse<PicDictSave>> ProDictSave(@Body PicDictSave proDictSave);

    //字典序号调整
    @POST("Product/ProDictOrderSave")
    Observable<GlobalResponse> ProDictOrderSave(@Body ArrayList<ProDictOrderSave> proDictOrderSaves);

    //字典信息删除
    @GET("Product/ProDictDelete")
    Observable<GlobalResponse> ProDictDelete(@Query("guid") String guid);

    //业务，业务管理

    //4:客户，5：供应商
    @GET("bussiness/ClientInfoDefault")
    Observable<GlobalResponse<Customer>> ClientInfoDefault(@Query("configid") String configid);

    //财务信息汇总
    @POST("bussiness/FinanceTotalInfo")
    Observable<GlobalResponse<FinanceTotalInfo>> FinanceTotalInfo();

    //单据打印
    @GET("bussiness/OrderPrint_V2")
    Observable<Response<ResponseBody>> OrderPrint_V1(@Query("id") String id,
                                                     @Query("oguid") String oguid,
                                                     @Query("printtype") String printtype/*,@Query("remote") String remote*/);

    //单据临时打印
    @POST("bussiness/OrderPrintTemp_V2")
    Observable<Response<ResponseBody>> OrderPrintTemp_V2(@Body InventoryDate inventoryDate,
                                                         @Query("printtype") String printtype);

    //	单据保存
    @POST("bussiness/OrderSave")
    Observable<GlobalResponse<OrderSaveBack>> OrderSave(@Body InventoryDate inventoryDate);

    //欠款客户
    @GET("bussiness/CustomerFinanceInfoList")
    Observable<GlobalResponse<ArrayList<Customer>>> CustomerFinanceInfoList(@Query("pageindex") String pageindex,
                                                                            @Query("pagesize") String pagesize);

    //15天滞销产品
    @GET("bussiness/SlowList")
    Observable<GlobalResponse<ArrayList<Goodsinfo>>> SlowList(@Query("pageindex") String pageindex,
                                                              @Query("pagesize") String pagesize);

    //30天未回购客户
    @GET("bussiness/NotBuyBack")
    Observable<GlobalResponse<ArrayList<Customer>>> NotBuyBack(@Query("pageindex") String pageindex,
                                                               @Query("pagesize") String pagesize);

    //批量上传
    @POST("bussiness/OrderSaveBatch")
    Observable<GlobalResponse> OrderSaveBatch(@Body List<OrderListTable> inventoryDate);

    //	挂单单据保存
    @POST("bussiness/OrderUpSave")
    Observable<GlobalResponse> OrderUpSave(@Body InventoryDate inventoryDate);

    //bussiness/OrderUpList 挂单列表
    @GET("bussiness/OrderUpList")
    Observable<GlobalResponse<ArrayList<OrderUpList>>> OrderUpList(@Query("ordertype") String ordertype);

    //挂单删除
    @GET("bussiness/OrderUpDelete")
    Observable<GlobalResponse> OrderUpDelete(@Query("id") String id);

    //	挂单单据保存
    @GET("bussiness/OrderUpInfo_V2")
    Observable<GlobalResponse<InventoryDate>> OrderUpInfo(@Query("id") String id, @Query("immedit") boolean oguid);

    //单据信息
    @GET("bussiness/OrderUpEditCancel")
    Observable<GlobalResponse> OrderUpEditCancel(@Query("id") String id);


    //	挂单单据保存
    @POST("bussiness/OrderShareSave")
    Observable<GlobalResponse<Integer>> OrderShareSave(@Body InventoryDate inventoryDate);

    //单据信息
    @GET("bussiness/OrderInfo")
    Observable<GlobalResponse<String>> OrderInfo(@Query("id") String id, @Query("oguid") String oguid);

    //单据信息
    @GET("bussiness/OrderInfo_V1")
    Observable<GlobalResponse<InventoryDate>> OrderInfo_V1(@Query("id") String id, @Query("oguid") String oguid);

    //bussiness/OrderPriceUpDate
    @POST("bussiness/OrderPriceUpDate")
    Observable<GlobalResponse<InventoryDate>> OrderPriceUpDate(@Body InventoryDate inventoryDate);

    //单据详情 备注
    @POST("bussiness/OrderRemarkSave")
    Observable<GlobalResponse> OrderRemarkSave(@Body OrderRemarkSave orderRemarkSave);

    //单据信息 判断是否能撤销
    @GET("bussiness/OrderCanOption")
    Observable<GlobalResponse> OrderCanOption(@Query("id") String id, @Query("oguid") String oguid);

    //撤销
    @GET("bussiness/OrderCancel")
    Observable<GlobalResponse> OrderCancel(@Query("id") String id);

    //单据列表
    @POST("bussiness/OrderList_Advance")
    Observable<GlobalResponse<ArrayList<OrderList>>> OrderList_Advance(@Body OrderListPost orderListPost);

    //商品客户供应商
    @GET("bussiness/SearchAll")
    Observable<GlobalResponse<ArrayList<SearchAll>>> SearchAll(@Query("key") String key);

    //单据处理

    //调拨单
    //调出，调入列表
    @GET("Order/AllocationList")
    Observable<GlobalResponse<AllocationList>> AllocationList(@Query("ordertype") String ordertype,
                                                              @Query("pageindex") String pageindex,
                                                              @Query("pagesize") String pagesize,
                                                              @Query("fromsguid") String fromsguid,
                                                              @Query("tosguid") String tosguid,
                                                              @Query("bdate") String bdate,
                                                              @Query("edate") String edate);

    //撤销
    @GET("order/AllocationInCancel")
    Observable<GlobalResponse> AllocationInCancel(@Query("orderid") String orderid);

    //调出挂单
    @GET("Order/AllocationList_Up")
    Observable<GlobalResponse<AllocationList>> AllocationList_Up();

    //调出撤销
    @GET("Order/AllocationList_OutCancel")
    Observable<GlobalResponse<AllocationList>> AllocationList_OutCancel(@Query("pageindex") String pageindex,
                                                                        @Query("pagesize") String pagesize,
                                                                        @Query("fromsguid") String fromsguid,
                                                                        @Query("tosguid") String tosguid,
                                                                        @Query("bdate") String bdate,
                                                                        @Query("edate") String edate);

    //调入在途
    @GET("Order/AllocationList_OnWay")
    Observable<GlobalResponse<AllocationList>> AllocationList_OnWay();

    //单据信息
    @GET("Order/AllocationOnWayInfo")
    Observable<GlobalResponse<InventoryDate>> AllocationOnWayInfo(@Query("id") String id);

    //调入备注
    @POST("Order/AllocationRemarkSave")
    Observable<GlobalResponse> AllocationRemarkSave(@Body AllocationRemarkSave FeeDictList);

    //调入撤销
    @GET("Order/AllocationList_InCancel")
    Observable<GlobalResponse<AllocationList>> AllocationList_InCancel(@Query("pageindex") String pageindex,
                                                                       @Query("pagesize") String pagesize,
                                                                       @Query("fromsguid") String fromsguid,
                                                                       @Query("tosguid") String tosguid,
                                                                       @Query("bdate") String bdate,
                                                                       @Query("edate") String edate);

    //财务管理

    //账目类型管理
    //Finance/FeeDictList
    @GET("Finance/FeeDictList")
    Observable<GlobalResponse<ArrayList<FeeDictList>>> FeeDictList(@Query("querytype") String querytype,
                                                                   @Query("isall") boolean isall);

    //费用保存
    @POST("Finance/FeeDictSave")
    Observable<GlobalResponse> FeeDictSave(@Body FeeDictList FeeDictList);

    //费用删除
    @GET("Finance/FeeDictDelete")
    Observable<GlobalResponse> FeeDictDelete(@Query("id") String id);

    //账号列表
    @GET("Finance/AccountList")
    Observable<GlobalResponse<ArrayList<AccountList>>> AccountList();

    // 账号信息 Finance/AccountInfo
    @GET("Finance/AccountInfo")
    Observable<GlobalResponse<AccountInfo>> AccountInfo(@Query("id") String id);

    // 账号期初金额 Finance/AccountInit
    @POST("Finance/AccountInit")
    Observable<GlobalResponse> AccountInit(@Body AccountInit accountInfo);

    // 账号保存 Finance/AccountSave
    @POST("Finance/AccountSave_v1")
    Observable<GlobalResponse> AccountSave(@Body AccountInfo accountInfo);

    // 账号删除 Finance/AccountDelete
    @GET("Finance/AccountDelete")
    Observable<GlobalResponse> AccountDelete(@Query("id") String id);

    //流水详情
    @GET("Finance/FeeInfo")
    Observable<GlobalResponse<FeeInfo>> FeeInfo(@Query("id") String id);

    // 账号保存 Finance/AccountFee
    @POST("Finance/AccountFee")
    Observable<GlobalResponse> AccountFee(@Body FeeInfo accountFee);

    //账户流水列表
    @GET("Finance/AccountFlow")
    Observable<GlobalResponse<AccountFlow>> AccountFlow(@Query("guid") String guid,
                                                        @Query("fguid") String fguid,
                                                        @Query("bdate") String bdate,
                                                        @Query("edate") String edate,
                                                        @Query("pageindex") String pageindex,
                                                        @Query("pagesize") String pagesize,
                                                        @Query("showcancel") String showcancel,
                                                        @Query("timetype") String timetype);

    //记一笔列表
    @GET("Finance/FeeList")
    Observable<GlobalResponse<AccountFlow>> FeeList(@Query("guid") String guid,
                                                    @Query("fguid") String fguid,
                                                    @Query("bdate") String bdate,
                                                    @Query("edate") String edate,
                                                    @Query("pageindex") String pageindex,
                                                    @Query("pagesize") String pagesize);

    // 转账 Finance/AccounAccountMututFee
    @POST("Finance/AccountMutu")
    Observable<GlobalResponse> AccountMutu(@Body AccountMutu accountFee);

    // 客户回款 1, 供应商打款 2 Finance/FeeForCustomer
    @POST("Finance/FeeForCustomer")
    Observable<GlobalResponse<ClientFeeInfo>> FeeForCustomer(@Body FeeForCustomer accountFee);

    //客户对账详情打印
    @POST("Finance/PrintClientFeeInfo")
    Observable<Response<ResponseBody>> PrintClientFeeInfo(@Query("id") String id,
                                                          @Query("printtype") String printtype);

    // 转账 Finance/FeeForSupplier
    @POST("Finance/FeeForSupplier")
    Observable<GlobalResponse<ClientFeeInfo>> FeeForSupplier(@Body FeeForCustomer accountFee);

    //日结

    //结算信息 DateSettleInfo
    @GET("DateSettle/DateSettleInfo")
    Observable<GlobalResponse<DateSummaryInfo>> DateSettleInfo(@Query("sguid") String guid);

    // 结算 DateSettle/DoSettle
    @POST("DateSettle/DoSettle")
    Observable<GlobalResponse> DoSettle(@Body DoSettle accountFee);

    //日结的账户 费用列表
    @GET("DateSettle/AccountFeeList")
    Observable<GlobalResponse<ArrayList<AccountFlow.FeesBean>>> AccountFeeList(@Query("aguid") String aguid,
                                                                               @Query("dguid") String dguid,
                                                                               @Query("pageindex") String pageindex,
                                                                               @Query("pagesize") String pagesize);

    //结算信息 DateSummaryInfo
    @GET("DateSettle/DateSummaryInfo")
    Observable<GlobalResponse<DateSummaryInfo>> DateSummaryInfo(@Query("guid") String guid);

    //结算列表 bussiness/DateSettleList
    @GET("DateSettle/DateSettleList")
    Observable<GlobalResponse<ArrayList<DateSettleListBack>>> DateSettleList(
            @Query("sguid") String sguid,
            @Query("bdate") String bdate,
            @Query("edate") String edate,
            @Query("pageindex") String pageindex,
            @Query("pagesize") String pagesize);

    //日结订单列表
    @GET("DateSettle/DateOrderList")
    Observable<GlobalResponse<DateOrderList>> DateSettleList(
            @Query("dguid") String dguid,
            @Query("ordertype") String ordertype);

    //客户欠款列表 DateSettle/DateClientOwing
    @GET("DateSettle/DateClientOwing")
    Observable<GlobalResponse<DateOrderList>> DateClientOwing(
            @Query("dguid") String dguid,
            @Query("ordertype") String ordertype);

    //日结其他收入
    @GET("DateSettle/DateFeeList")
    Observable<GlobalResponse<ArrayList<DateClientFeeList>>> DateFeeList(
            @Query("dguid") String dguid,
            @Query("feetype") String ordertype);

    //日结其他收入
    @GET("DateSettle/DateClientFeeList")
    Observable<GlobalResponse<ArrayList<DateClientFeeList>>> DateClientFeeList(
            @Query("dguid") String dguid,
            @Query("feetype") String ordertype);

    //https://lsapi.zjwist.com/bussiness/DateSummaryInfoPrint --》DateSettle/DateSummaryInfoPrint
    @POST("DateSettle/DateSummaryInfoPrint")
    Observable<Response<ResponseBody>> DateSummaryInfoPrint(@Query("guid") String guid,
                                                            @Query("printtype") String printtype);


    //报表

    //报表高级查询
    @POST("report/OrderReport_Advance")
    Observable<GlobalResponse<OrderReport>> OrderReport_Advance(@Body OrderReportPost orderReportPost);

    //报表明细
    @POST("report/OrderList_Advance")
    Observable<GlobalResponse<ArrayList<RepOrderList>>> OrderList_Advance(@Body OrderReportPost orderListPost);

    //设置

    //获取界面功能设置
    @GET("LSSet/UISetGet")
    Observable<GlobalResponse<ArrayList<UiSetGet>>> UISetGet(@Query("index") String index);

    //界面的功能保存
    @POST("LSSet/UISetSave")
    Observable<GlobalResponse> UISetSave(@Body UISetSave index);

    //前端同步数据
    @GET("LSSet/SyncDataDB")
    Observable<Response<ResponseBody>> SyncDataDB(@Query("mobile") String mobile);

    //上传图片
    @Multipart
    @POST("LSSet/UpLoadSQLiteDB")
    Observable<GlobalResponse> UpLoadSQLiteDB(@Part("description") RequestBody description,
                                              @Part MultipartBody.Part file);

    //同步信息 SyncDataSQL 前端批量同步数据
    @GET("LSSet/SyncDataSQL")
    Observable<GlobalResponse<ArrayList<String>>> SyncDataSQL(@Query("lastsynctime") String lastsynctime,
                                                              @Query("dbversion") String dbversion,
                                                              @Query("cguid") String cguid);


    //快递

    //物流轨迹即时查询接口  Ebusiness/EbusinessOrderHandle.aspx
//    RequestData	String	请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致。	R
//    EBusinessID	String	商户ID，请在我的服务页面查看。	R
//    RequestType	String	请求指令类型：1002	R
//    DataSign	String	数据内容签名：把(请求内容(未编码)+AppKey)进行MD5加密，然后Base64编码，最后 进行URL(utf-8)编码。详细过程请查看Demo。	R
//    DataType	String	请求、返回数据类型：2-json；
    @FormUrlEncoded
    @POST("Ebusiness/EbusinessOrderHandle.aspx")
    Observable<EbusinessOrderHandle> EbusinessOrderHandle(/*@Body EbusinessOrderPost<EbusinessOrderBean> ebusinessOrderPost*/
                                                          @Field("RequestData") String RequestData,
                                                          @Field("EBusinessID") String EBusinessID,
                                                          @Field("RequestType") String RequestType,
                                                          @Field("DataSign") String DataSign,
                                                          @Field("DataType") String DataType);

    //电子面单
    //请求url, 正式环境地址：http://api.kdniao.cc/api/Eorderservice
    //测试环境地址：http://testapi.kdniao.cc:8081/api/EOrderService
    @FormUrlEncoded
    @POST("api/Eorderservice")
    Observable<EbusinessOrderOnLineHandle> Eorderservice(@Field("RequestData") String RequestData,
                                                         @Field("EBusinessID") String EBusinessID,
                                                         @Field("RequestType") String RequestType,
                                                         @Field("DataSign") String DataSign,
                                                         @Field("DataType") String DataType);

}
