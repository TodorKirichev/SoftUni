package JavaAdvanced.DefiningClassesExercises._7_Google;

import java.util.List;

public class Car {
    String model;
    String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    @Override
    public String toString() {
        return String.format("%s %s\n",getModel(),getSpeed());
    }
}
