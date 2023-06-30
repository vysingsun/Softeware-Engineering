import java.util.Scanner;

public class E_CheaterGame {
    public static void main(String[] args) {
        System.out.println("Program for guessing your luckiness");
        Scanner num = new Scanner(System.in);
        System.out.printf("please input a positive number: ");
        int number = num.nextInt();

        int got;
        got = number + 1;
        System.out.printf("I got %d. I am luckier.", got);
    }
}
