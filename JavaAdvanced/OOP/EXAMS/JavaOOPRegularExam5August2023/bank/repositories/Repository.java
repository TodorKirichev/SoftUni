package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan.Loan;

public interface Repository {

    void addLoan(Loan loan);

    boolean removeLoan(Loan loan);

    Loan findFirst(String type);
}
