package www.zhouyan.project.modle.daoarea;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/12 17:10
 * 修改人: zhouyan
 * 修改时间: 2017/6/12 17:10
 * 修改备注:
 */

public class DaoSession extends AbstractDaoSession {


    private final DaoConfig areaCodeDaoConfig;


    private final AreaCodeDao areaCodeDao;


    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        areaCodeDaoConfig = daoConfigMap.get(AreaCodeDao.class).clone();
        areaCodeDaoConfig.initIdentityScope(type);

        areaCodeDao = new AreaCodeDao(areaCodeDaoConfig, this);

        registerDao(AreaCode.class, areaCodeDao);
    }

    public void clear() {
        areaCodeDaoConfig.clearIdentityScope();

    }

    public AreaCodeDao getAreaCodeDao() {
        return areaCodeDao;
    }


}
