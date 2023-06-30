public class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int heigth) {
        this.width = width;
        this.height = heigth;
    }

    public int calculatePerimeter() {
        return (width + height) * 2;
    }

    public int calculateSurface() {
        return width * height;
    }
}