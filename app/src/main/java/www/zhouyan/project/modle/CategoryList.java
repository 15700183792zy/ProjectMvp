package www.zhouyan.project.modle;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * Created by zhouyan on 2017/6/5.
 * 行业分类
 */

public class CategoryList implements IPickerViewData   {


    private String name;
    private boolean deleteflag;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }
}
