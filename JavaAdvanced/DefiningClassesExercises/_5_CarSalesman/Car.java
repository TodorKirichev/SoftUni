package JavaAdvanced.DefiningClassesExercises._5_CarSalesman;

public class Car {
    String carModel;
    String engineModel;
    String weight = "n/a";
    String color = "n/a";

    public Car(String carModel, String engineModel) {
        this.carModel = carModel;
        this.engineModel = engineModel;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
