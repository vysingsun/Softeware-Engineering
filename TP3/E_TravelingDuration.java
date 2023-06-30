import java.util.Scanner;

public class E_TravelingDuration {
    public static void main(String[] args) {
        Scanner jam = new Scanner(System.in);
        System.out.println("Program for calculating duration of travel from ITC to Airport.");
        System.out.printf("Please input traffic jam factor (in percentage [0-100]): ");
        float percentage = jam.nextInt();

        float percentages_of_the_average_speed;
        float t;
        float second;

        percentages_of_the_average_speed = (percentage / 100) * 30;

        t = 7 / percentages_of_the_average_speed;

        second = t * 3600;

        float h, min, s;
        float mod_t;
        h = second / 3600;
        mod_t = second % 3600;
        min = mod_t / 60;
        s = mod_t % 60;

        // System.out.printf("%f\n", percentages_of_the_average_speed);
        // System.out.printf("%f\n", t);
        // System.out.printf("%f\n", second);

        System.out.printf("Travelling Duration = %.0f : %.0f : %.0f", h, min, s);
    }
}
