package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {
    private static final int EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        setEfficiency(getEfficiency() - 1);
        if (getEfficiency() < 0) {
            setEfficiency(0);
        }
    }
}
