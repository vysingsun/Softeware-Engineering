import java.util.Scanner;

public class C_callingCost {
    public static void main(String[] args) {
        Scanner ti = new Scanner(System.in);
        System.out.println("Program for calculating cost of a call.");
        System.out.printf("Please input start hours: ");
        int time = ti.nextInt();
        System.out.printf("Please input start minutes: ");
        int min = ti.nextInt();
        System.out.printf("Please input start seconds: ");
        int sec = ti.nextInt();

        System.out.printf("Please input end hours: ");
        int time_end = ti.nextInt();
        System.out.printf("Please input end minutes: ");
        int min_end = ti.nextInt();
        System.out.printf("Please input end seconds: ");
        int sec_end = ti.nextInt();

        int result, result_end;
        result = (time * 3600) + (min * 60) + sec;
        result_end = (time_end * 3600) + (min_end * 60) + sec_end;

        float seconded;
        seconded = result_end - result;

        float minuted;
        minuted = seconded / 60;
        float cost_of_call;
        cost_of_call = minuted * 0.05f;

        int times, mins, ss;
        int mod_tis;

        times = (int) seconded / 3600;
        mod_tis = (int) seconded % 3600;
        mins = mod_tis / 60;
        ss = mod_tis % 60;

        System.out.printf("Total call duration: %dh %dmin %ds\n", times, mins, ss);
        System.out.printf("Total cost of this call: %f $", cost_of_call);
    }

}
