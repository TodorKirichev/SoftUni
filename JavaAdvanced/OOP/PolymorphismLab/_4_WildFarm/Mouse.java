package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

public class Mouse extends Mammal{
    public Mouse(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight,livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("Mice are not eating that type of food!%n");
        }
    }
}
