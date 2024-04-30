package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.common.ExceptionMessages.CLIENT_NAME_NULL_OR_EMPTY;

public class ClientImpl implements Client {
    private String name;
    private Collection<String> clientOrders;

    public ClientImpl(String name) {
        setName(name);
        clientOrders = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CLIENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getClientOrders() {
        return clientOrders;
    }

    @Override
    public String getName() {
        return name;
    }
}
