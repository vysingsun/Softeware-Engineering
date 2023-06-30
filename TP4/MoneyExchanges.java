import java.util.Scanner;

public class MoneyExchanges {

    public static void RielsToDollars(float riel) {
        float dollar;
        dollar = riel / 4000.0f;
        System.out.printf("\n%.2f Riels = %.2f USD\n\n", riel, dollar);
    }

    public static void RielsToThaiBaht(float riel) {
        float thai;
        thai = riel / 133.33f;
        System.out.printf("\n%.2f Riels = %.2f Baht\n\n", riel, thai);
    }

    public static void dollasToRiels(float dollar) {
        float riel;
        riel = dollar * 4000.0f;
        System.out.printf("\n%.2f USD = %.2f Riels\n\n", dollar, riel);
    }

    public static void dollasToBaht(float dollar) {
        float thai;
        thai = dollar * 30.0f;
        System.out.printf("\n%.2f USD = %.2f Baht\n\n", dollar, thai);
    }

    public static void bahtToriels(float thai) {
        float riel;
        riel = thai * 133.33f;
        System.out.printf("\n%.2f Baht = %.2f Riels\n\n", thai, riel);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Welcome to program Money Exchanges!
                1. Riels to Dollar
                2. Riels to Thai Baht
                3. Dollar to Riels
                4. Dollar to Thai Baht
                5. Thai Baht to Riels
                6. Exit
                    """);
        System.out.printf("Choose an option: ");
        int option = sc.nextInt();
        if (option == 1) {
            System.out.println("\n1. Riels to Dollar");
            System.out.printf("Input money in riels: ");
            float riel = sc.nextFloat();
            RielsToDollars(riel);
        } else if (option == 2) {
            System.out.println("\n2. Riels to Thai Baht");
            System.out.printf("Input money in riels: ");
            float riel = sc.nextFloat();
            RielsToThaiBaht(riel);
        } else if (option == 3) {
            System.out.println("\n3. Dollar to Riels");
            System.out.printf("Input money in Dollars: ");
            float dollar = sc.nextFloat();
            dollasToRiels(dollar);
        } else if (option == 4) {
            System.out.println("\n4. Dollar to Thai Baht");
            System.out.printf("Input money in Dollars: ");
            float dollar = sc.nextFloat();
            dollasToBaht(dollar);
        } else if (option == 5) {
            System.out.println("\n5. Thai Baht to Riels");
            System.out.printf("Input money in Baht: ");
            float thai = sc.nextFloat();
            bahtToriels(thai);
        } else if (option == 6) {

        }

    }
}
