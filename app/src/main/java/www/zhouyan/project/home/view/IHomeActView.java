package www.zhouyan.project.home.view;

import www.zhouyan.project.base.IBaseView;

/**
 * Created by mac on 18/3/22.
 */

public interface IHomeActView extends IBaseView {
    void toMainOrder();//开单
    void checkClientId();
    void checkVersion();
    void sql();
    void  upload();//上传数据
}
