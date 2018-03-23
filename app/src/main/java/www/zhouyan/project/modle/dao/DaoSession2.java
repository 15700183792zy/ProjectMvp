package www.zhouyan.project.modle.dao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

import www.zhouyan.project.modle.CompanyConfigs;
import www.zhouyan.project.modle.CompanyConfigsDao;
import www.zhouyan.project.modle.Customer;
import www.zhouyan.project.modle.CustomerDao;
import www.zhouyan.project.modle.Express;
import www.zhouyan.project.modle.ExpressDao;
import www.zhouyan.project.modle.Goodsinfo;
import www.zhouyan.project.modle.GoodsinfoDao;
import www.zhouyan.project.modle.OrderListTable;
import www.zhouyan.project.modle.OrderListTableDao;
import www.zhouyan.project.modle.Pay;
import www.zhouyan.project.modle.PayDao;
import www.zhouyan.project.modle.PicDictSave;
import www.zhouyan.project.modle.PicDictSaveDao;
import www.zhouyan.project.modle.ProColors;
import www.zhouyan.project.modle.ProColorsDao;
import www.zhouyan.project.modle.ProSizes;
import www.zhouyan.project.modle.ProSizesDao;
import www.zhouyan.project.modle.Shop;
import www.zhouyan.project.modle.ShopDao;
import www.zhouyan.project.modle.Sku;
import www.zhouyan.project.modle.SkuDao;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/12 17:10
 * 修改人: zhouyan
 * 修改时间: 2017/6/12 17:10
 * 修改备注:
 */

public class DaoSession2 extends AbstractDaoSession {
    //配置
    private final DaoConfig companyConfigsDaoConfig;
    private final CompanyConfigsDao companyConfigsDao;

    //商品
    private final DaoConfig goodsinfoDaoConfig;
    private final GoodsinfoDao goodsinfoDao;

    //门店
    private final DaoConfig shopsDaoConfig;
    private final ShopDao shopDao;

    private final DaoConfig customerDaoConfig;
    private final CustomerDao customerDao;

    //支付账户 PayDao
    private final DaoConfig payDaoConfig;
    private final PayDao payDao;

    //单据列表
    private final DaoConfig orderListTableDaoConfig;
    private final OrderListTableDao orderListTableDao;

    //商品 sku
    private final DaoConfig skuDaoConfig;
    private final SkuDao skuDao;

    //商品字典
    private final DaoConfig picDictSaveDaoConfig;
    private final PicDictSaveDao picDictSaveDao;

    //商品颜色
    private final DaoConfig proColorsDaoConfig;
    private final ProColorsDao proColorsDao;

    //尺码
    private final DaoConfig proSizesDaoConfig;
    private final ProSizesDao proSizesDao;

    //物流
    private final DaoConfig proExpressDaoConfig;
    private final ExpressDao expressDao;

    public DaoSession2(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);
        //配置表
        companyConfigsDaoConfig = daoConfigMap.get(CompanyConfigsDao.class).clone();
        companyConfigsDaoConfig.initIdentityScope(type);
        companyConfigsDao = new CompanyConfigsDao(companyConfigsDaoConfig, this);
        registerDao(CompanyConfigs.class, companyConfigsDao);

        //商品表
        goodsinfoDaoConfig = daoConfigMap.get(GoodsinfoDao.class).clone();
        goodsinfoDaoConfig.initIdentityScope(type);
        goodsinfoDao = new GoodsinfoDao(goodsinfoDaoConfig, this);
        registerDao(Goodsinfo.class, goodsinfoDao);

        //门店
        shopsDaoConfig = daoConfigMap.get(ShopDao.class).clone();
        shopsDaoConfig.initIdentityScope(type);
        shopDao = new ShopDao(shopsDaoConfig, this);
        registerDao(Shop.class, shopDao);

        //客户
        customerDaoConfig = daoConfigMap.get(CustomerDao.class).clone();
        customerDaoConfig.initIdentityScope(type);
        customerDao = new CustomerDao(customerDaoConfig, this);
        registerDao(Customer.class, customerDao);

        //门店支付账户
        payDaoConfig = daoConfigMap.get(PayDao.class).clone();
        payDaoConfig.initIdentityScope(type);
        payDao = new PayDao(payDaoConfig, this);
        registerDao(Pay.class, payDao);

        //单据列表
        orderListTableDaoConfig = daoConfigMap.get(OrderListTableDao.class).clone();
        orderListTableDaoConfig.initIdentityScope(type);
        orderListTableDao = new OrderListTableDao(orderListTableDaoConfig, this);
        registerDao(OrderListTable.class, orderListTableDao);

        //商品 sku
        skuDaoConfig = daoConfigMap.get(SkuDao.class).clone();
        skuDaoConfig.initIdentityScope(type);
        skuDao = new SkuDao(skuDaoConfig, this);
        registerDao(Sku.class, skuDao);

        //商品字典
        picDictSaveDaoConfig = daoConfigMap.get(PicDictSaveDao.class).clone();
        picDictSaveDaoConfig.initIdentityScope(type);
        picDictSaveDao = new PicDictSaveDao(picDictSaveDaoConfig, this);
        registerDao(PicDictSave.class, picDictSaveDao);


        //商品颜色
        proColorsDaoConfig = daoConfigMap.get(ProColorsDao.class).clone();
        proColorsDaoConfig.initIdentityScope(type);
        proColorsDao = new ProColorsDao(proColorsDaoConfig, this);
        registerDao(ProColors.class, proColorsDao);

        //商品尺码
        proSizesDaoConfig = daoConfigMap.get(ProSizesDao.class).clone();
        proSizesDaoConfig.initIdentityScope(type);
        proSizesDao = new ProSizesDao(proSizesDaoConfig, this);
        registerDao(ProSizes.class, proSizesDao);


        //物流
        proExpressDaoConfig = daoConfigMap.get(ExpressDao.class).clone();
        proExpressDaoConfig.initIdentityScope(type);
        expressDao = new ExpressDao(proExpressDaoConfig, this);
        registerDao(Express.class, expressDao);
    }

    //清除缓存
    public void clear() {
        companyConfigsDaoConfig.clearIdentityScope();
        goodsinfoDaoConfig.clearIdentityScope();
        shopsDaoConfig.clearIdentityScope();
        customerDaoConfig.clearIdentityScope();
        payDaoConfig.clearIdentityScope();
        orderListTableDaoConfig.clearIdentityScope();
        skuDaoConfig.clearIdentityScope();
        picDictSaveDaoConfig.clearIdentityScope();
        proColorsDaoConfig.clearIdentityScope();
        proSizesDaoConfig.clearIdentityScope();
        proExpressDaoConfig.clearIdentityScope();
    }

    public ExpressDao getExpressDao() {
        return expressDao;
    }

    public ProColorsDao getProColorsDao() {
        return proColorsDao;
    }

    public ProSizesDao getProSizesDao() {
        return proSizesDao;
    }

    public PicDictSaveDao getPicDictSaveDao() {
        return picDictSaveDao;
    }

    public SkuDao getSkuDao() {
        return skuDao;
    }

    public OrderListTableDao getOrderListTableDao() {
        return orderListTableDao;
    }

    public PayDao getPayDao() {
        return payDao;
    }

    public CompanyConfigsDao getCompanyConfigsDao() {
        return companyConfigsDao;
    }

    public GoodsinfoDao getGoodsinfoDao() {
        return goodsinfoDao;
    }

    public ShopDao getShopDao() {
        return shopDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }
}
