package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionLab._4_SayHelloExtended;

public class Chinese extends BasePerson{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
