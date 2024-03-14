package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client;

public class Adult extends BaseClient {
    private static final int INTEREST = 4;
    public Adult(String name, String ID, double income) {
        super(name, ID, INTEREST, income);
    }

    @Override
    public void increase() {
        setInterest(getInterest() + 2);
    }
}
