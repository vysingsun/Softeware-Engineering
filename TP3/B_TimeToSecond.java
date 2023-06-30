import java.util.Scanner;

public class B_TimeToSecond {
    public static void main(String[] args) {
        Scanner ti = new Scanner(System.in);
        System.out.println("Program for converting time to seconds.");
        System.out.printf("Please input hours: ");
        int time = ti.nextInt();
        System.out.printf("Please input minutes: ");
        int min = ti.nextInt();
        System.out.printf("Please input seconds: ");
        int sec = ti.nextInt();

        int result = (time * 3600) + (min * 60) + sec;

        System.out.printf("Number of seconds = %dx3600 + %dx60 + %d = %d", time, min, sec, result);
    }
}
