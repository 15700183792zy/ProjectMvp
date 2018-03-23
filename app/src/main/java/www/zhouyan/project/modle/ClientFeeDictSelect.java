package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/7/7.
 */

public class ClientFeeDictSelect {

    /**
     * guid : 00000000-0000-0000-0000-000000000000
     * name : null
     * deleteflag : false
     * id : 0
     */

    private String guid;
    private String  name;
    private boolean deleteflag;
    private int id;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

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
}
