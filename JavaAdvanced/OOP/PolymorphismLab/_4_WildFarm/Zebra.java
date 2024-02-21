package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight,livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n",getClass().getSimpleName());
        }
    }
}
