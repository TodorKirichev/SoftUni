package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientRepository implements Repository<Client> {
    private Collection<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(clients);
    }

    @Override
    public void add(Client client) {
        clients.add(client);
    }

    @Override
    public boolean remove(Client client) {
        return clients.remove(client);
    }

    @Override
    public Client byName(String name) {
        return clients.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }
}
