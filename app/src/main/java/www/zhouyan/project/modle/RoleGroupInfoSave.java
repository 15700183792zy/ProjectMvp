package www.zhouyan.project.modle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mac on 17/10/24.
 */

public class RoleGroupInfoSave implements Serializable{
    private int id;
    private String name;
    private String mobile;
    public boolean issys;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ArrayList<GroupsBean> groups;

    public ArrayList<GroupsBean> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<GroupsBean> groups) {
        this.groups = groups;
    }

    public static class GroupsBean implements Serializable{

        private String name;
        private String value;
        private ArrayList<RightsBean> rights;
        private boolean select;//check,被选入，select 选中当前行
        private int check; //0 未选择，1 半选中，2选中

        public int getCheck() {
            return check;
        }

        public void setCheck(int check) {
            this.check = check;
        }

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public ArrayList<RightsBean> getRights() {
            return rights;
        }

        public void setRights(ArrayList<RightsBean> rights) {
            this.rights = rights;
        }

        public static class RightsBean implements Serializable{
            private boolean right;
            private String name;
            private String value;

            public boolean isRight() {
                return right;
            }

            public void setRight(boolean right) {
                this.right = right;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
