package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.orders.TakenOrders;

public interface Waiter {
    String getName();

    int getEfficiency();

    boolean canWork();

    TakenOrders takenOrders();


    void work();
}
