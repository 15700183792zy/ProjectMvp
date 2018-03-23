package www.zhouyan.project.modle;

/**
 * Created by zhouyan on 17/8/1.
 */

public class UISetSave {
    private int index;
    private String uijson;

    public UISetSave(int index, String uijson) {
        this.index = index;
        this.uijson = uijson;
    }

    public UISetSave() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUijson() {
        return uijson;
    }

    public void setUijson(String uijson) {
        this.uijson = uijson;
    }
}
