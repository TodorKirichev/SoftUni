package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._6_GreedyTimes;

public class Item {
    private ItemType type;
    private String name;
    private long amount;

    public Item(ItemType type, String name, long amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public ItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
