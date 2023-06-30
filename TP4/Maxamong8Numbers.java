import java.util.Scanner;

public class Maxamong8Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Find maximum number of 8 integers.");
        System.out.printf("Enter a number #1: ");
        int n1 = sc.nextInt();
        System.out.printf("Enter a number #2: ");
        int n2 = sc.nextInt();
        System.out.printf("Enter a number #3: ");
        int n3 = sc.nextInt();
        System.out.printf("Enter a number #4: ");
        int n4 = sc.nextInt();
        System.out.printf("Enter a number #5: ");
        int n5 = sc.nextInt();
        System.out.printf("Enter a number #6: ");
        int n6 = sc.nextInt();
        System.out.printf("Enter a number #7: ");
        int n7 = sc.nextInt();
        System.out.printf("Enter a number #8: ");
        int n8 = sc.nextInt();

        if (n1 >= n2 && n1 >= n3 && n1 >= n4 && n1 >= n5 && n1 >= n6 && n1 >= n7 && n1 >= n8) {
            System.out.printf("%d is a maximum number.", n1);
        } else if (n2 >= n1 && n2 >= n3 && n2 >= n4 && n2 >= n5 && n2 >= n6 && n2 >= n7 && n2 >= n8) {
            System.out.printf("%d is a maximum number.", n2);
        } else if (n3 >= n1 && n3 >= n2 && n3 >= n4 && n3 >= n5 && n3 >= n6 && n3 >= n7 && n3 >= n8) {
            System.out.printf("%d is a maximum number.", n3);
        } else if (n4 >= n1 && n4 >= n2 && n4 >= n3 && n4 >= n5 && n4 >= n6 && n4 >= n7 && n4 >= n8) {
            System.out.printf("%d is a maximum number.", n4);
        } else if (n5 >= n1 && n5 >= n2 && n5 >= n3 && n5 >= n4 && n5 >= n6 && n5 >= n7 && n5 >= n8) {
            System.out.printf("%d is a maximum number.", n5);
        } else if (n6 >= n1 && n6 >= n2 && n6 >= n3 && n6 >= n4 && n6 >= n5 && n6 >= n7 && n6 >= n8) {
            System.out.printf("%d is a maximum number.", n6);
        } else if (n7 >= n1 && n7 >= n2 && n7 >= n3 && n7 >= n4 && n7 >= n5 && n7 >= n6 && n7 >= n8) {
            System.out.printf("%d is a maximum number.", n7);
        } else if (n8 >= n1 && n8 >= n2 && n8 >= n3 && n8 >= n4 && n8 >= n5 && n8 >= n6 && n8 >= n7) {
            System.out.printf("%d is a maximum number.", n8);
        }
    }
}
