package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String catBreed;

    public Cat(String animalType, String animalName, Double animalWeight,String livingRegion, String catBreed) {
        super(animalType, animalName, animalWeight,livingRegion);
        this.catBreed = catBreed;
    }

    public String getCatBreed() {
        return catBreed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]"
                ,getAnimalType()
                ,getAnimalName()
                ,getCatBreed()
                ,decimalFormat.format(getAnimalWeight())
                ,getLivingRegion()
                ,getFoodEaten());
    }
}
