package abstraction.lab04HotelReservation;

public enum DiscountType {
    VIP (0.2),
    SECOND_VISIT (0.1),
    NONE (0.0);

    private final double discount;

    DiscountType (double discount) {
        this.discount = discount;
    }

    public double getDiscount () {
        return this.discount;
    }

    public static DiscountType discount (String discountType) {

        switch (discountType) {

            case "VIP":
                return DiscountType.VIP;

            case "SecondVisit":
                return DiscountType.SECOND_VISIT;

            case "None":

                return DiscountType.NONE;

            default:
                return null;
        }

    }


}
