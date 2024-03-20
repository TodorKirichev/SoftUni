package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    private static final double INITIAL_WEIGHT = 5.50;
    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_WEIGHT, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + 5.70);
    }
}
