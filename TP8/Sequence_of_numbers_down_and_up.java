import java.util.Scanner;

public class Sequence_of_numbers_down_and_up {

    boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sequence_of_numbers_down_and_up s = new Sequence_of_numbers_down_and_up();
        while (true) {
            System.out.print("Input a positive number: ");
            String num = sc.nextLine();
            if (s.isNum(num)) {
                int n = Integer.valueOf(num);
                if (n > 0) {
                    for (int i = n; i >= 1; i--) {
                        System.out.printf("%02d ", i);
                    }
                    for (int k = 2; k <= n; k++) {
                        System.out.printf("%02d ", k);
                    }
                    System.out.print("\n");
                } else {
                    System.out.println("Enter only positive number.");
                }
            } else {
                System.out.println("Enter only positive number.");
                System.out.print("Input a positive number: ");
                num = sc.nextLine();
                if (s.isNum(num)) {
                    int n = Integer.parseInt(num);
                    for (int i = n; i >= 1; i--) {
                        System.out.printf("%02d ", i);
                    }
                    for (int k = 2; k <= n; k++) {
                        System.out.printf("%02d ", k);
                    }
                    System.out.print("\n");
                }
            }

        }
    }
}