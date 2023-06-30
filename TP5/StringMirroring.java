import java.util.Scanner;

public class StringMirroring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String myString = sc.nextLine();
        makePalindrome(myString);
    }

    public static void makePalindrome(String myString) {
        StringBuffer buffer = new StringBuffer(myString);
        buffer.reverse();
        String data = buffer.toString();
        System.out.printf("%s%s", myString, data);
    }
}
