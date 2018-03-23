package www.zhouyan.project.modle;

import java.util.ArrayList;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/19 8:57
 * 修改人: zhouyan
 * 修改时间: 2017/6/19 8:57
 * 修改备注:
 */

public class ProDictOrderSave {
    private String guidgroup;
    private ArrayList<String> dictguid;

    public String getGuidgroup() {
        return guidgroup;
    }

    public void setGuidgroup(String guidgroup) {
        this.guidgroup = guidgroup;
    }

    public ArrayList<String> getDictguid() {
        return dictguid;
    }

    public void setDictguid(ArrayList<String> dictguid) {
        this.dictguid = dictguid;
    }
}
