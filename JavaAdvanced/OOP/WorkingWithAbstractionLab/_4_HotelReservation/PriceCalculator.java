package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionLab._4_HotelReservation;

public class PriceCalculator {
    public static double calculate(double pricePerDay,int numOfDays,Season season,DiscountType discountType) {
        return pricePerDay * numOfDays * season.getPricePerDayCoefficient() * discountType.getDiscount();
    }
}
