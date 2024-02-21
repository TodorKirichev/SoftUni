package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;

    protected Mammal(String animalType, String animalName, Double animalWeight,String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]"
        ,getAnimalType()
        ,getAnimalName()
        ,decimalFormat.format(getAnimalWeight())
        ,getLivingRegion()
        ,getFoodEaten());
    }
}
