import java.util.Scanner;

public class B_rectangle {
    public static void main(String[] args) {

        System.out.println("Program for calculate perimeter and surface of a Rectangle.");

        Scanner num = new Scanner(System.in);
        System.out.printf("Please input width(in meter): ");
        int width = num.nextInt();
        System.out.printf("Please input height(in meter): ");
        int height = num.nextInt();

        int perimeter;
        int surface;
        perimeter = (width + height) * 2;
        surface = width * height;

        System.out.printf("(%d + %d) * 2 = %d m\n", width, height, perimeter);
        System.out.printf("%d * %d = %d m^2", width, height, surface);
    }
}
