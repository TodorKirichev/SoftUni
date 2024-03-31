package SoftUni.JavaAdvanced.OOP.DesignPatternsExercises.factoryExercise;

public class CakeFactory {
    public static Cake createCake(String cakeType) {
        Cake cake = null;
        switch (cakeType) {
            case "WhiteCake":
                cake = new WhiteCake(10, 10, 10);
                break;
            case "ChocolateCake":
                cake = new ChocolateCake(10, 10, 10);
                break;
            case "SpinachCake":
                cake = new SpinachCake(10, 10, 10);
                break;
            case "BiscuitCake":
                cake = new BiscuitCake(10, 10, 10);
                break;
        }
        return cake;
    }
}
