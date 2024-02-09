package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._6_GreedyTimes;

public enum ItemType {
    GOLD,
    GEM,
    CASH;

    public static ItemType parse(String string) {
        if (string.length() == 3) {
            return ItemType.valueOf("CASH");
        } else if (string.length() >= 4 && string.toLowerCase().endsWith("gem")) {
            return ItemType.valueOf("GEM");
        } else if (string.equalsIgnoreCase("Gold")) {
            return ItemType.valueOf("GOLD");
        } else {
            throw new IllegalArgumentException("Unknown Type!");
        }
    }
}
