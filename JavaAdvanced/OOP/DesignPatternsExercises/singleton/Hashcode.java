package SoftUni.JavaAdvanced.OOP.DesignPatternsExercises.singleton;

import java.util.ArrayList;
import java.util.List;

public class Hashcode {
    private List<String> list;
    private static Hashcode instance;

    private Hashcode() {
        list = new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public static Hashcode getInstance() {
        if (instance == null) {
            instance = new Hashcode();
        }
        return instance;
    }
}
