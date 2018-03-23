package www.zhouyan.project.base;

/**
 * Created by mac on 18/3/21.
 */

public interface IBaseView {
    void showMessage(String msg);
//    void showLoading();
//    void hideLoading();
    void showErrorView();
    void showDialogs(int code,String message);
}
