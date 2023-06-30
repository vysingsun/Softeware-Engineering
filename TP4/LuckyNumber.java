import java.util.Scanner;

public class LuckyNumber {
    Scanner sc = new Scanner(System.in);
    private String number;
    private int threefirst, threelast;

    public static void main(String[] args) {
        LuckyNumber lucky = new LuckyNumber();
        lucky.getInput();
        lucky.display();
    }

    public void getInput() {
        System.out.println("Program for testing for lucky number.");
        System.out.printf("Please input 6 digits number: ");
        number = sc.nextLine();
    }

    public void sumLucky() {
        threefirst = 0;
        threelast = 0;
        for (int i = 0; i < number.length(); i++) {
            int convertor = Character.getNumericValue(number.charAt(i));
            if (i <= 2) {
                threefirst += convertor;
            } else {
                threelast += convertor;
            }
        }
    }

    public boolean isLucky() {
        if (threefirst == threelast) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid() {
        if (number.length() == 6) {
            return true;
        }
        return false;
    }

    public void display() {
        if (isValid()) {
            sumLucky();
            if (isLucky()) {
                System.out.printf("%s is lucky number.", number);
            } else {
                System.out.printf("%s is not lucky number.", number);
            }
        } else {
            System.out.println("Invalid input number, please input only 6 digits number.");
        }
    }
}
