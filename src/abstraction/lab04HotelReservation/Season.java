package abstraction.lab04HotelReservation;

public enum Season {
    AUTUMN (1),
    SPRING (2),
    WINTER (3),
    SUMMER (4);

    private final int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Season season (String season) {

        switch (season) {

            case "Autumn" :
                return Season.AUTUMN;

            case "Spring":
                return Season.SPRING;

            case "Winter":
                return Season.WINTER;

            case "Summer":
                return Season.SUMMER;

        }
        return null;
    }
}
