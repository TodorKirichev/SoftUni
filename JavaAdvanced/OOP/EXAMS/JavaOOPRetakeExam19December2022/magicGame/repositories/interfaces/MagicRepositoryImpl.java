package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.repositories.interfaces;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2022.magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        data = new ArrayList<>();
    }


    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        data.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return data.remove(magic);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
