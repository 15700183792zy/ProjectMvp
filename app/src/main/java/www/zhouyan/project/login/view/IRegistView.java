package www.zhouyan.project.login.view;

import java.util.ArrayList;

import www.zhouyan.project.base.IBaseView;
import www.zhouyan.project.modle.CategoryList;

/**
 * Created by mac on 18/3/21.
 */

public interface IRegistView extends IBaseView{
    void toMainAct();//去主界面

    void setCategoryList(ArrayList<CategoryList> categoryLists);//设置行业id

    void getCode(boolean code);//获取验证妈



}
