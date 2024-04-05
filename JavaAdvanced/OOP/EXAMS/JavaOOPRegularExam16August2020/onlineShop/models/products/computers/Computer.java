package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.Product;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.components.Component;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}