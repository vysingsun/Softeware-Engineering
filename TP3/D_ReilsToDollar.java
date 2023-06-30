import java.util.Scanner;

public class D_ReilsToDollar {
    public static void main(String[] args) {
        Scanner money = new Scanner(System.in);
        System.out.println("Program for converting money in Riels to Dollars.");
        System.out.println("Conversion rate is: 1 USD = 4000 RIELS");
        System.out.printf("Please input money in Riels: ");
        float reils = money.nextFloat();

        float dollar;
        dollar = reils / 4000;

        System.out.printf("%.2f REILS = %.2f USD", reils, dollar);
    }
}