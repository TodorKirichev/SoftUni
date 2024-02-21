package SoftUni.JavaAdvanced.OOP.PolymorphismLab._3_Animals;

public class Cat extends Animal{

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s\n" +
                "MEEOW",getName(),getFavouriteFood());
    }
}
