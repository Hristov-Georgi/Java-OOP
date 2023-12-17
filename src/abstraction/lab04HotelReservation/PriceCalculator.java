package abstraction.lab04HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private DiscountType discount;
    private Season season;

    public PriceCalculator (double pricePerDay, int days, DiscountType discount, Season season) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.discount = discount;
        this.season = season;
    }

    public double priceOfHoliday () {

        double priceWithoutDiscount = this.pricePerDay * this.days * this.season.getValue();

        return priceWithoutDiscount - (priceWithoutDiscount * this.discount.getDiscount());
    }

}

