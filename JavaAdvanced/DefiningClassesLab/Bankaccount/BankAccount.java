package JavaAdvanced.DefiningClassesLab.Bankaccount;

public class BankAccount {
    private static int nextID = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public BankAccount() {
        this.id = nextID;
        nextID++;
    }
    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }
    public double getInterest(int years) {
        return years * balance * interestRate;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
}
