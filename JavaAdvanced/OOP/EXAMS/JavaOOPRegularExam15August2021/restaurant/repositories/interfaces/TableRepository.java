package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);
}
