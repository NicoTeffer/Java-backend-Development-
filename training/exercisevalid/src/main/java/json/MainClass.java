package json;

import java.util.List;

public class MainClass {

    private String name;
    private List<String> stringList;
    private int anInt;
    private boolean aBoolean;
    private SecondClass secondClass;
    private ThirdClass thirdClass;

    public MainClass() {
    }

    public MainClass(String name, List<String> stringList, int anInt, boolean aBoolean, SecondClass secondClass, ThirdClass thirdClass) {
        this.name = name;
        this.stringList = stringList;
        this.anInt = anInt;
        this.aBoolean = aBoolean;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
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

    public SecondClass getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public ThirdClass getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }
}
