package www.zhouyan.project.modle;

/**
 * Created by mac on 17/10/24.
 * 角色列表
 */

public class RoleGroupList {
    private String cguid;
    private String name;
    private int id;
    public boolean issys;

    public String getCguid() {
        return cguid;
    }

    public void setCguid(String cguid) {
        this.cguid = cguid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
