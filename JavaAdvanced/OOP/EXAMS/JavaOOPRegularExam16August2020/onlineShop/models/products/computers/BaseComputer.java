package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.BaseProduct;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.components.Component;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;


    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double componentsAverageOP = components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
        return super.getOverallPerformance() + componentsAverageOP;
    }

    @Override
    public double getPrice() {
        double totalPrice = super.getPrice();
        totalPrice += components.stream().mapToDouble(Component::getPrice).sum();
        totalPrice += peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return totalPrice;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component expectedComponent = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst().orElse(null);
        if (components.isEmpty() || expectedComponent == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, getClass().getSimpleName(), getId()));
        }
        components.remove(expectedComponent);
        return expectedComponent;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p -> p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral expectedPeripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);
        if (peripherals.isEmpty() || expectedPeripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, getClass().getSimpleName(), getId()));
        }
        peripherals.remove(expectedPeripheral);
        return expectedPeripheral;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",getOverallPerformance(), getPrice(),getClass().getSimpleName(), getManufacturer(), getModel(), getId())).append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", components.size())).append(System.lineSeparator());
        components.forEach(c -> sb.append(String.format("  %s",c)).append(System.lineSeparator()));
        double averageOP = peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0);
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", peripherals.size(), averageOP))
                .append(System.lineSeparator());
        peripherals.forEach(p -> sb.append(String.format("  %s",p)).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
