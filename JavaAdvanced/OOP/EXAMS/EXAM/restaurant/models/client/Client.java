package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();

    String getName();
}
