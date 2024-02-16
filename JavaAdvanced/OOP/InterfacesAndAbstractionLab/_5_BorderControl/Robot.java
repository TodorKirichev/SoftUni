package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionLab._5_BorderControl;

public class Robot implements Identifiable{
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getModel() {
        return model;
    }
    @Override
    public String toString() {
        return String.format("%s %s",model,id);
    }
}
