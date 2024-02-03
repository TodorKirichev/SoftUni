package JavaAdvanced.DefiningClassesExercises._5_CarSalesman;

public class Engine {
    String engineModel;
    String power;
    String displacement = "n/a";
    String efficiency = "n/a";

    public Engine(String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }
    @Override
    public  String toString() {
        return String.format("%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\n",getEngineModel(),getPower(),getDisplacement(),getEfficiency());
    }
}
