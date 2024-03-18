package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Collection<Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        delicacies = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return delicacies.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return delicacies;
    }

    @Override
    public void add(Delicacy delicacy) {
        delicacies.add(delicacy);
    }
}
