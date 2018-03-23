package www.zhouyan.project.modle;

/**
 * 项目名称: Project
 * 类描述:
 * 创建人: zhouyan
 * 创建时间: 2017/6/10 14:49
 * 修改人: zhouyan
 * 修改时间: 2017/6/10 14:49
 * 修改备注: 修改密码
 */

public class PwdChange {
    private  String username;
    private String oldpwd;
    private String newpwd;

    public PwdChange(String username, String oldpwd, String newpwd) {
        this.username = username;
        this.oldpwd = oldpwd;
        this.newpwd = newpwd;
    }
}
