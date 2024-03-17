package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.shop;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.tool.Tool;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.vehicle.Vehicle;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {

        for (Tool tool : worker.getTools()) {
            while (!tool.isUnfit()) {
                vehicle.making();
                worker.working();
                tool.decreasesPower();
                if (vehicle.reached()) {
                    return;
                }
                if (!worker.canWork()) {
                    return;
                }
            }
        }
    }
}
