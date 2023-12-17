package polymorphism.lab02Shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        Double perimeter = 2 * (this.height + this.width);
        super.setPerimeter(perimeter);

        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        Double area = this.height * this.width;
        super.setArea(area);

        return super.getArea();

    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getWidth() {
        return this.width;
    }


}
