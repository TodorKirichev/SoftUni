package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables.interfaces.Table;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Table table) {
        models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        return models.stream().filter(t -> t.getTableNumber() == number).findFirst().orElse(null);
    }
}
