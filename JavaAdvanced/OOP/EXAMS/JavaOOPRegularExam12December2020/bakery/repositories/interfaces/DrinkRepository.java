package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories.interfaces;

public interface DrinkRepository<T> extends Repository<T> {
    T getByNameAndBrand(String drinkName,String drinkBrand);
}
