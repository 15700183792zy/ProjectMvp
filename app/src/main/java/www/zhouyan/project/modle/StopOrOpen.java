package www.zhouyan.project.modle;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/15 11:26
 * 修改人: zhouyan
 * 修改时间: 2017/6/15 11:26
 * 修改备注: 商店 = 1, 客户 = 2, 供应商 = 3, 科目 = 4, 商品 = 5,
 */

public class StopOrOpen {
   private String  guid;//		是	相应功能的guid
    private int  typeid	;//	是	typeid值见备注修改备注: 商店 = 1, 客户 = 2, 供应商 = 3, 科目 = 4, 商品 = 5,
    private boolean   isstop	;//	是

    public StopOrOpen(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public boolean isstop() {
        return isstop;
    }

    public void setIsstop(boolean isstop) {
        this.isstop = isstop;
    }
}
