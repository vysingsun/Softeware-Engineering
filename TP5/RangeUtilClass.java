import java.util.Scanner;

public class RangeUtilClass {
    private int start;
    private int end;
    private int step;
    private int i;
    Scanner sc = new Scanner(System.in);

    public void getinput() {
        System.out.print("Enter a value of start: ");
        start = sc.nextInt();
        System.out.print("Enter a value of end: ");
        end = sc.nextInt();
        System.out.print("Enter a value of step: ");
        step = sc.nextInt();
    }

    public void findrange() {
        System.out.print("\nType integer: ");
        if (start < end) {
            for (i = start; i <= end; i = i + step) {
                System.out.printf("%d ", i);
            }
        } else {
            for (i = start; i >= end; i = i - step) {
                System.out.printf("%d ", i);
            }
        }
    }

    public void convertToString() {
        System.out.print("\nType a string: ");
        if (start < end) {
            for (i = start; i <= end; i = i + step) {
                String strNum = "" + i;
                System.out.printf("%s ", strNum);
            }
        } else {
            for (i = start; i >= end; i = i - step) {
                String strNum = "" + i;
                System.out.printf("%s ", strNum);
            }
        }
    }
}

class ce1 {
    public static void main(String[] args) {
        RangeUtilClass r1 = new RangeUtilClass();
        r1.getinput();
        r1.findrange();
        r1.convertToString();
    }
}
