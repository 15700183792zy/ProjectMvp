package www.zhouyan.project.base;


/** presenter基类
 * Created by Administrator on 2017/8/1 0001.
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }
}
