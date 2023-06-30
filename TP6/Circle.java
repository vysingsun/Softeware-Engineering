public class Circle {
    private Point center, p;

    public Circle(Point center, Point p) {
        this.center = center;
        this.p = p;
    }

    public double radius() {
        return center.distance(p);
    }

    public double perimeter() {
        // P=2*PI*R
        return 2 * Math.PI * radius();
    }

    public double surface() {
        // S=PI*R^2
        return Math.PI * radius() * radius();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }
}