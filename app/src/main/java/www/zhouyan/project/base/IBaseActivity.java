package www.zhouyan.project.base;


import android.os.Bundle;
import android.view.View;

/**
 * Activity接口
 * @author zhouyan
 * @version 1.0
 *
 */
public interface IBaseActivity {
    /**
     * 绑定渲染视图的布局文件
     * @return 布局文件资源id
     */
    int bindLayout();

    /**
     * 初始化控件
     */
    void initView(View view, Bundle savedInstanceState);

    /**
     * 业务处理操作（onCreate方法中调用）
     */
    void doBusiness();
    /**
     * 暂停恢复刷新相关操作（onResume方法中调用）
     */
    void resume();

    /**
     * 销毁、释放资源相关操作（onDestroy方法中调用）
     */
    void destroy();

//    /**
//     * 设置menu资源 0表示不需要menu
//     */
//    int setMenuResId();

//    /**
//     * 是否需要广播
//     */
//    boolean isNeedRefreshBroadcast();

}
