import java.util.Scanner;

public class ReversingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program for reversing a 4 digits number.");
        System.out.printf("Please input 4 digits number: ");
        int num = sc.nextInt();
        System.out.printf("The reversing number of %d is ", num);
        revers(num);
    }

    public static void revers(int num) {
        int remainder;
        int reversNum = 0;
        int length = (int) (Math.log10(num) + 1); // find lenght of digits
        if (length == 4) {
            while (num > 0) {
                remainder = num % 10;
                num = num / 10;
                reversNum = (reversNum * 10) + remainder;
            }
            System.out.printf("%d\n", reversNum);
        } else {
            System.out.println("Error: invalid number, please input only 4 digits number.");
        }

    }

}
