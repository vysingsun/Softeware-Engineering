import java.lang.reflect.Field;
import java.util.Scanner;

public class PointThreeD {
    private int x, y, z;

    private PointThreeD() {
    }

    public static PointThreeD dataInput() {
        Scanner sc = new Scanner(System.in);
        PointThreeD p = new PointThreeD();
        System.out.print("Enter a value of x:");
        try {
            p.setX(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Change to Integer number.");
        }
        System.out.print("Enter a value of y:");
        try {
            p.setY(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Change to Integer number.");
        }

        System.out.print("Enter a value of z:");
        try {
            p.setZ(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            System.out.println("Change to Integer number.");
        }
        return p;
    }

    public String toString() {
        return "x = " + x + "\ny = " + y + "\nz = " + z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        fieldUtil.checkNull_Empty_blank(String.valueOf(x), "x");
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        fieldUtil.checkNull_Empty_blank(String.valueOf(y), "y");
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        fieldUtil.checkNull_Empty_blank(String.valueOf(z), "z");
        this.z = z;
    }

}