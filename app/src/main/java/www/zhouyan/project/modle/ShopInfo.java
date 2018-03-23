package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 14:57
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 14:57
 * 修改备注:
 */

public class ShopInfo {
    private Shop shop;

    private ArrayList<UsersBean> users;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ArrayList<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UsersBean> users) {
        this.users = users;
    }


}
