package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.tables.interfaces.Table;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> entities;

    public TableRepositoryImpl() {
        entities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return entities;
    }

    @Override
    public void add(Table entity) {
        entities.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return entities.stream().filter(e -> e.getTableNumber() == number).findFirst().orElse(null);
    }
}
