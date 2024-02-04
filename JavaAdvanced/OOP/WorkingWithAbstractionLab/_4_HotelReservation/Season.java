package JavaAdvanced.OOP.WorkingWithAbstractionLab._4_HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),

    SUMMER(4);
    private double pricePerDayCoefficient;
    Season(double pricePerDayCoefficient) {
        this.pricePerDayCoefficient = pricePerDayCoefficient;
    }

    public double getPricePerDayCoefficient() {
        return pricePerDayCoefficient;
    }

}
