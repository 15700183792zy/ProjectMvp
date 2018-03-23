package www.zhouyan.project.modle;

/**
 * Created by mac on 17/11/27.
 */

public class CodeMode {
    private int key;
    private String name;
    public CodeMode(){

    }
    public CodeMode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CodeMode{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
