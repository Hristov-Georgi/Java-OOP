package polymorphism.lab02Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        Double perimeter = 2 * Math.PI * this.radius;
        super.setPerimeter(perimeter);

        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        Double area = Math.PI * this.radius * this.radius;
        super.setArea(area);

        return super.getArea();
    }

    public final Double getRadius() {
        return this.radius;
    }


}
