package www.zhouyan.project.manager;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import www.zhouyan.project.R;


/**
 * Title :
 * Description :
 * Author : zhouyan
 * Data : 2016/6/6 0006 09:53
 * Version : 1.0.0
 * Copyright : Copyright(c) 浙江蘑菇加电子商务有限公司 2015 ~ 2016 版权所有
 */
public class ToolBarManager {

    public static void setToolBarCenterTitle(Toolbar toolbar, String title){
        TextView tv_center= (TextView) toolbar.findViewById(R.id.tv_center);
        toolbar.setTitle("");
        tv_center.setText(title);
    }


    public static void setToolBarBack(final AppCompatActivity activity, Toolbar toolbar, String title, int menuId, Toolbar.OnMenuItemClickListener listener) {
        toolbar.setTitle(title);//设置主标题

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//        {
//            toolbar.getLayoutParams().height = activity.getAppBarHeight();
//            toolbar.setPadding(toolbar.getPaddingLeft(),
//                    activity.getStatusBarHeight(),
//                    toolbar.getPaddingRight(),
//                    toolbar.getPaddingBottom());
//        }

        activity.setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.arr_ios_back_w);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        toolbar.setOnMenuItemClickListener(listener);
        toolbar.inflateMenu(menuId);//设置右上角的填充菜单
    }

    public static void setToolBarBack(final AppCompatActivity activity, Toolbar toolbar, String title) {
        toolbar.setTitle(title);//设置主标题

        activity.setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.arr_ios_back_w);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    public static void setToolBarClose(final AppCompatActivity activity,
                                       Toolbar toolbar, String title, int menuId, Toolbar.OnMenuItemClickListener listener) {
        toolbar.setTitle(title);//设置主标题

        activity.setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.arr_ios_back_w);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

        toolbar.setOnMenuItemClickListener(listener);
        toolbar.inflateMenu(menuId);//设置右上角的填充菜单
    }


    public static void setToolBarClose(final AppCompatActivity activity, Toolbar toolbar, String title) {
        toolbar.setTitle(title);//设置主标题

        activity.setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.arr_ios_back_w);//设置导航栏图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
}
