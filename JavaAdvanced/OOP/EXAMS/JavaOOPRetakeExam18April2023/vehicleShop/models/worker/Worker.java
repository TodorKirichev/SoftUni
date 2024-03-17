package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.worker;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.tool.Tool;

import java.util.Collection;

public interface Worker {
    void working();

    void addTool(Tool tool);

    boolean canWork();

    String getName();

    int getStrength();

    Collection<Tool> getTools();
}
