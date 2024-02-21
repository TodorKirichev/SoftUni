package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

public class Tiger extends Felime{
    private String livingRegion;
    public Tiger(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight,livingRegion);
    }


    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf("%ss are not eating that type of food!%n",getClass().getSimpleName());
        }
    }
}
