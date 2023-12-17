package abstraction.ex04TrafficLights;

public class TrafficLight {
    private LightColor lightColor;

    public TrafficLight (LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public void changeColor () {

        switch (this.lightColor) {

            case RED:
                this.lightColor = LightColor.GREEN;
                break;

            case YELLOW:
                this.lightColor = LightColor.RED;
                break;

            case GREEN:
                this.lightColor = LightColor.YELLOW;
                break;
        }

    }

    @Override
    public String toString () {
        return this.lightColor.toString();
    }
}
