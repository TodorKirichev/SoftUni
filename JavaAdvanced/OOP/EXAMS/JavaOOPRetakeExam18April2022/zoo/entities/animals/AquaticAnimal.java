package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private static final double INITIAL_WEIGHT = 2.50;
    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_WEIGHT, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + 7.50);
    }
}
