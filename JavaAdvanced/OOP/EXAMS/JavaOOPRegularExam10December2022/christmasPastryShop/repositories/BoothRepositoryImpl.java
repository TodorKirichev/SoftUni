package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.interfaces.Booth;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Collection<Booth> booths;

    public BoothRepositoryImpl() {
        booths = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return booths.stream().filter(b -> b.getBoothNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return booths;
    }

    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }
}
