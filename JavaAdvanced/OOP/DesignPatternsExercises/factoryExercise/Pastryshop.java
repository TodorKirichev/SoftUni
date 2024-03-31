package SoftUni.JavaAdvanced.OOP.DesignPatternsExercises.factoryExercise;

public class Pastryshop {

    public static Cake orderCake(String cakeType) {
        Cake cake = CakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();
        return cake;
    }
}
