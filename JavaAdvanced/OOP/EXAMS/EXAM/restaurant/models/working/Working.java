package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.working;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client.Client;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
