import java.util.Scanner;

public class D_hundredsCounter {
    public static void main(String[] args) {
        System.out.println("Program for counting the number of hundreds");
        Scanner num = new Scanner(System.in);
        System.out.printf("Please input a positive number: ");
        int number = num.nextInt();

        int hundreds;
        hundreds = number / 100;

        System.out.printf("There are %d hundreds in number %d", hundreds, number);
    }
}
