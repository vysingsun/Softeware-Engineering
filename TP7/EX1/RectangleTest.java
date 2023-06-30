public class RectangleTest {
    Rectangle rectangle = new Rectangle(2, 2);

    public void displayPerimeter() {
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }

    public void displaySurface() {
        System.out.println("Surface: " + rectangle.calculateSurface());
    }

    public static void main(String[] args) {
        RectangleTest rectangleTest = new RectangleTest();
        rectangleTest.displayPerimeter();
        rectangleTest.displaySurface();
    }
}
