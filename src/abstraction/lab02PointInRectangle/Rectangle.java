package abstraction.lab02PointInRectangle;

public class Rectangle {
    private final Point B;  //top right point
    private final Point C;  //bottom left point

    public Rectangle(Point B, Point C) {
        this.B = B;
        this.C = C;
    }

    public boolean contains(Point point) {

        if (point.getX() < this.C.getX() || point.getX() > this.B.getX()) {
            return false;
        }

        if (point.getY() > this.B.getY() || point.getY() < this.C.getY()) {
            return false;
        }

        return true;
    }

}
