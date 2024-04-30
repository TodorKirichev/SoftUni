package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client.Client;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client.ClientImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.FullTimeWaiter;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.HalfTimeWaiter;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.Waiter;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.working.Working;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.working.WorkingImpl;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.repositories.ClientRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.repositories.Repository;
import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.repositories.WaiterRepository;

import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Client> clientRepository;
    private Repository<Waiter> waiterRepository;
    private int servedClients;

    public ControllerImpl() {
        clientRepository = new ClientRepository();
        waiterRepository = new WaiterRepository();
        servedClients = 0;
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        switch (type) {
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        Client client = clientRepository.byName(clientName);
        Collection<Waiter> waiters = waiterRepository.getCollection();
        if (waiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Working working = new WorkingImpl();
        working.takingOrders(client, waiters);
        servedClients++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_CLIENTS_COUNT, servedClients)).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());
        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());
            sb.append("Taken orders: ");
            Collection<String> takenOrders = waiter.takenOrders().getOrdersList();
            if (takenOrders.isEmpty()) {
                sb.append("None");
            } else {
                String orders = String.join(", ", takenOrders);
                sb.append(orders);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
