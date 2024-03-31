package SoftUni.JavaAdvanced.OOP.DesignPatternsExercises.singleton;

public class Main {
    public static void main(String[] args) {
        Hashcode hashcode = Hashcode.getInstance();
        Hashcode hashcode1 = Hashcode.getInstance();
        hashcode.getList().add("Ivan");
        hashcode1.getList().add("Ivan");
        System.out.println();
    }
}
