package www.zhouyan.project.modle;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 14:46
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 14:46
 * 修改备注: 修改公司手机号
 */

public class ModifyCompanyMobile {
    private String icode;
    private String oldmobile;
    private String newmobile;

    public ModifyCompanyMobile(String icode, String oldmobile, String newmobile) {
        this.icode = icode;
        this.oldmobile = oldmobile;
        this.newmobile = newmobile;
    }
}
