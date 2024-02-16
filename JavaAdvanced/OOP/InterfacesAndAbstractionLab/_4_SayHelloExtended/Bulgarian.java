package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionLab._4_SayHelloExtended;

public class Bulgarian extends BasePerson{

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
