package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.repositories;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getCollection();

    void add(T entity);

    boolean remove(T entity);

    T byName(String name);
}
