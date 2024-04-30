package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WaiterRepository implements Repository<Waiter> {
    private Collection<Waiter> waiters;

    public WaiterRepository() {
        waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(waiters);
    }

    @Override
    public void add(Waiter waiter) {
        waiters.add(waiter);
    }

    @Override
    public boolean remove(Waiter waiter) {
        return waiters.remove(waiter);
    }

    @Override
    public Waiter byName(String name) {
        return waiters.stream().filter(w -> w.getName().equals(name)).findFirst().orElse(null);
    }
}
