package json;

import java.util.List;

public class SecondClass {

    private String name;
    private List<String> stringList;
    private int anInt;
    private boolean aBoolean;

    public SecondClass(String name, List<String> stringList, int anInt, boolean aBoolean) {
        this.name = name;
        this.stringList = stringList;
        this.anInt = anInt;
        this.aBoolean = aBoolean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
}
