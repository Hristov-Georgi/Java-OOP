package encapsulation.ex01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validateSideLength(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateSideLength(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateSideLength(height, "Height");
        this.height = height;

    }

    private void validateSideLength(double side, String sideType) {
        if (side <= 0) {
            throw new NumberFormatException(sideType + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
      return  calculateLateralSurfaceArea() + 2 * this.length * this.width;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (this.length * this.height + this.width * this.height);
    }

    public double calculateVolume() {
        return  this.length * this.width * this.height;
    }

}
