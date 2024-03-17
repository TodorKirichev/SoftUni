package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.common.ConstantMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.common.ExceptionMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.shop.Shop;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.shop.ShopImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.tool.Tool;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.tool.ToolImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.vehicle.Vehicle;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.vehicle.VehicleImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.worker.FirstShift;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.worker.SecondShift;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.worker.Worker;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.repositories.VehicleRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private VehicleRepository<Vehicle> vehicleRepository;
    private WorkerRepository<Worker> workerRepository;
    private Shop shop;

    public ControllerImpl() {
        vehicleRepository = new VehicleRepository();
        workerRepository = new WorkerRepository();
        shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        switch (type) {
            case "FirstShift":
                worker = new FirstShift(workerName);
                break;
            case "SecondShift":
                worker = new SecondShift(workerName);
                break;
            default:
                throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);
        return String.format(ADDED_WORKER,type,workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName,strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE,vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workerRepository.findByName(workerName);
        if (worker == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);
        worker.addTool(tool);
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> collect = workerRepository.getWorkers().stream().filter(helper -> helper.getStrength() > 70)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }
        int brokenInstruments = 0;
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);
        for (Worker worker : collect) {
            shop.make(vehicle, worker);
            brokenInstruments += (int) worker.getTools().stream().filter(Tool::isUnfit).count();
            if (vehicle.reached()){
                break;
            }
        }
        if (vehicle.reached()) {
            return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!",vehicleRepository.getWorkers()
                .stream().filter(Vehicle::reached).count()));
        sb.append(System.lineSeparator());
        sb.append("Info for workers:");
        sb.append(System.lineSeparator());
        workerRepository.getWorkers().forEach(w -> {
            sb.append(String.format("Name: %s, Strength: %d",w.getName(),w.getStrength()));
            sb.append(System.lineSeparator());
            sb.append(String.format("Tools: %d fit left",w.getTools().stream().filter(t -> !t.isUnfit()).count()));
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
