import java.util.Scanner;

public class A_secondsToTime {
    public static void main(String[] args) {
        System.out.println("Converting second to time");
        Scanner time = new Scanner(System.in);

        System.out.printf("Enter a value of second: ");
        int s = time.nextInt();

        int ti, min, sec;
        int mod_ti, mod_min;

        ti = s / 3600;
        mod_ti = s % 3600;

        min = mod_ti / 60;

        sec = mod_ti % 60;

        System.out.printf("Time corresponding to %dseconds is %d:%d:%d", s, ti, min, sec);
    }
}