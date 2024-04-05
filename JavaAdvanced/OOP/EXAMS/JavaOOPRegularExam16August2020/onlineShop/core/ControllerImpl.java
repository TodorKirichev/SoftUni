package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.components.*;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers.Computer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers.DesktopComputer;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers.Laptop;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.common.constants.ExceptionMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Computer> computers;
    private Collection<Component> components;
    private Collection<Peripheral> peripherals;

    public ControllerImpl() {
        computers = new ArrayList<>();
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = computers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (computer != null) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Peripheral peripheral = peripherals.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (peripheral != null) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        Computer computer = getComputer(computerId);
        computer.addPeripheral(peripheral);
        peripherals.add(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = getComputer(computerId);
        Peripheral peripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);
        computer.removePeripheral(peripheralType);
        peripherals.remove(peripheral);
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Component component = components.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (component != null) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        Computer computer = getComputer(computerId);
        computer.addComponent(component);
        components.add(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = getComputer(computerId);
        Component component = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        computer.removeComponent(componentType);
        components.remove(component);
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = getComputer(id);
        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = computers.stream().filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparing(Computer::getOverallPerformance)).orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = getComputer(id);
        return computer.toString();
    }

    private Computer getComputer(int computerId) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        return computer;
    }
}
