package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.working;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client.Client;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingImpl implements Working {
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        List<Waiter> workingWaiters = waiters.stream().filter(Waiter::canWork).collect(Collectors.toList());
        Iterator<String> clientOrders = client.getClientOrders().iterator();

        for (Waiter waiter : workingWaiters) {
            while (waiter.canWork() && clientOrders.hasNext()) {
                String order = clientOrders.next();
                waiter.work();
                waiter.takenOrders().getOrdersList().add(order);
            }
        }
    }
}
