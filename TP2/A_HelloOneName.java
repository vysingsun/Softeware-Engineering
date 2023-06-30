import java.util.Scanner;

public class A_HelloOneName {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.printf("Input your name: ");
        String name = n.next();
        System.out.printf("Hello %s!", name);
    }
}