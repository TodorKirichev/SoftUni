package JavaAdvanced.DefiningClassesExercises._4_RawData;

public class Car {
    String model;
    Engine engine;
    Cargo cargo;
    Tire[] tires;
    public Car(String model,int speed,int power,int weight,String type,double t1p,int t1a,double t2p,int t2a,double t3p,int t3a,double t4p,int t4a) {
        this.model = model;
        this.engine = new Engine(speed,power);
        this.cargo = new Cargo(weight,type);
        this.tires = new Tire[]{
                new Tire(t1p,t1a),
                new Tire(t2p,t2a),
                new Tire(t3p,t3a),
                new Tire(t4p,t4a)
        };
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }
    public boolean isFragile() {
        boolean isLowPressure = getTirePressure();
        return cargo.getType().equals("fragile") && isLowPressure;
    }
    public boolean isFlamable() {
        return cargo.getType().equals("flamable") && engine.getPower() > 250;
    }
    private boolean getTirePressure() {
        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
