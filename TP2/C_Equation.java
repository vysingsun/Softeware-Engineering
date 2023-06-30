import java.util.Scanner;

public class C_Equation {
    public static void main(String[] args) {
        System.out.println("Program for calculating equation 1/x = 1/y + 1/z");
        Scanner f = new Scanner(System.in);
        System.out.printf("Please input y: ");
        float y = f.nextFloat();
        System.out.printf("Please input z: ");
        float z = f.nextFloat();

        float x;
        x = (y * z) / (y + z);
        System.out.printf("Result x = %f", x);
    }
}
