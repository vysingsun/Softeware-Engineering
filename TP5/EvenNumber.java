import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a start number: ");
        int num = sc.nextInt();
        if (num > 0 && num < 500) {
            System.out.printf("Even start from %d number: ", num);
            for (int i = num; i <= 500; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println("\nPlease enter a number between 0 and 500.");
        }
    }
}
