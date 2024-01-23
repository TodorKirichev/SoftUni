package JavaAdvanced.DefiningClassesLab.Car;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public Car (String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {
        this(brand);
        this.model = model;
        this.horsepower = horsepower;
    }

    public String carInfo() {
         return "The car is: " + getBrand() + " " + getModel() + " - " + getHorsepower() + " " + "HP.";
    }
    @Override
    public String toString() {
        return "The car is: " + getBrand() + " " + getModel() + " - " + getHorsepower() + " " + "HP.";
    }
}
