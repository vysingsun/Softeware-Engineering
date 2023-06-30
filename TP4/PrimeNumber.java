import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Input number to check whether it is prime number: ");
        int num = input.nextInt();
        isPrime(num);
    }

    public static void isPrime(int num) {
        int i = 2;
        while (i < num) {
            if (num % i == 0) {
                break;
            }
            i++;
        }
        if (i == num) {
            System.out.printf("%d is prime number.", num);
        } else {
            System.out.printf("%d is not prime number, because it is divisible to %d.", num, i);
        }
    }
}