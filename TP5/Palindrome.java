import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please gives a word to check: ");
        String myString = sc.nextLine();
        System.out.printf("Choose method (REV, LOOP): ");
        String op = sc.nextLine();

        if (op.equals("REV")) {
            reverse(myString);
        } else if (op.equals("LOOP")) {
            loopRev(myString);
        }
    }

    public static void reverse(String myString) {
        StringBuffer buffer = new StringBuffer(myString);
        buffer.reverse();
        String data = buffer.toString();
        if (myString.equals(data)) {
            System.out.printf("%s String is palindrome.", myString);
        } else {
            System.out.printf("%s String is not palindrome.", myString);
        }
    }

    public static void loopRev(String myString) {
        String data = "";
        for (int i = myString.length() - 1; i >= 0; i--) {
            data = data + myString.charAt(i);
        }
        if (myString.equals(data)) {
            System.out.printf("%s String is palindrome.", myString);
        } else {
            System.out.printf("%s String is not palindrome.", myString);
        }
    }
}
