package www.zhouyan.project.home.view;

import android.view.View;
import android.widget.TextView;

import www.zhouyan.project.R;
import www.zhouyan.project.base.BaseFragmentV4;
import www.zhouyan.project.base.TitleView;

/**
 * Created by mac on 18/3/22.
 */

public class FilesFragment extends BaseFragmentV4 {

    public FilesFragment() {
        super();
    }

    public static FilesFragment newInstance() {
        FilesFragment fragment = new FilesFragment();
        return fragment;
    }

    @Override
    public boolean isActionBusiness() {
        return false;
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_empty;
    }


    @Override
    public void initView(View view) {
        super.initView(view);
        TextView tv_center = (TextView)getTitleView(TitleView.tv_center);
        tv_center.setText("业务管理");
        TextView tv_save = (TextView)getTitleView(TitleView.tv_save);
        tv_save.setText("");
        TextView tv_back = (TextView)getTitleView(TitleView.tv_back);
        tv_back.setVisibility(View.GONE);
    }
}
