import java.util.Scanner;

public class TP04Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    \n\n-------- Menu ---------
                    1. Prime number
                    2. Lucky number
                    3. Reversing number
                    4. Money exchange
                    5. Max among 8 numbers
                    6. Shipping
                    7. Leap year
                    0. Exit
                        """);
            System.out.printf("Choose an option: ");
            int op = sc.nextInt();

            if (op == 1) {
                PrimeNumber.main(args);
            } else if (op == 2) {
                LuckyNumber.main(args);
            } else if (op == 3) {
                ReversingNumber.main(args);
            } else if (op == 4) {
                MoneyExchanges.main(args);
            } else if (op == 5) {
                Maxamong8Numbers.main(args);
            } else if (op == 6) {
                Shipping.main(args);
            } else if (op == 7) {
                LeapYear.main(args);
            } else if (op == 0) {
                break;
            }
        }
    }
}
