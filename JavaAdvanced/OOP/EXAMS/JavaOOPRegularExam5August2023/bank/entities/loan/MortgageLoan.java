package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.loan;

public class MortgageLoan extends BaseLoan {
    private static final int INTEREST_RATE = 3;
    private static final double AMOUNT = 50000;
    public MortgageLoan() {
        super(INTEREST_RATE, AMOUNT);
    }
}
