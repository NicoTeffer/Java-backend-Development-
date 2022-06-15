package json;

import com.google.gson.Gson;

import java.util.List;

public class ConvertJSON {
    public static MainClass getMainClass(MainClass mainClass) {
        mainClass.setName("nameMAINCLASS");
        mainClass.setStringList(List.of("String1", "String2", "String3"));
        mainClass.setAnInt(5);
        mainClass.setaBoolean(true);
        mainClass.setSecondClass(
                new SecondClass
                        ("nameSECONDCLASS", List.of("secondClassSTRING1", "secondClassSTRING2", "secondClassSTRING3"),
                                10, false));
        mainClass.setThirdClass(
                new ThirdClass
                        ("nameTHIRDCLASS", List.of("thirdClassSTRING1", "thirdClassSTRING2", "thirdClassSTRING3"),
                                15, true));
        return mainClass;
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        getMainClass(mainClass);
        System.out.println("The JSON representation of Object mainClass is: ");
        System.out.println(new Gson().toJson(mainClass));
    }
}
