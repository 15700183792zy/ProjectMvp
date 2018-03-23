package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 15:18
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 15:18
 * 修改备注: 用户信息
 */

public class UserInfo {
    private  User user;

    private ArrayList<UsersBean> shops;

    public ArrayList<UsersBean> getShops() {
        return shops;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShops(ArrayList<UsersBean> shops) {
        this.shops = shops;
    }
}
