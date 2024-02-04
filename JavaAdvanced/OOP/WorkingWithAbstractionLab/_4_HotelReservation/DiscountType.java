package JavaAdvanced.OOP.WorkingWithAbstractionLab._4_HotelReservation;

public enum DiscountType {
    VIP(0.8),
    SecondVisit(0.9),
    None(1);
    double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
