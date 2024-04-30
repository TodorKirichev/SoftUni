package SoftUni.JavaAdvanced.OOP.EXAMS.EXAM.restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {
    private static final int EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        setEfficiency(getEfficiency() - 2);
        if (getEfficiency() < 0) {
            setEfficiency(0);
        }
    }
}
