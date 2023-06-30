
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class S {
    private String name;
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Calendar now = Calendar.getInstance();
        Calendar born = Calendar.getInstance();
        born.setTime(dob);
        if (now.compareTo(born) >= 0) {
            this.dob = dob;
        } else {
            // throw new
        }
    }

    public static S dataInput() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        S s = new S();
        System.out.print("Enter name: ");
        s.name = sc.nextLine();
        System.out.print("Enter date of birth(dd/mm/yyyy): ");
        try {
            s.setDob(format.parse(sc.nextLine()));
        } catch (ParseException e) {
            System.out.println("Invalid date of birth.");
        }
        return s;
    }

    public void dataOutput() {
        S s = new S();
        System.out.println("Name: " + s.getName() + ", \nBorn on: " + s.getDob());
    }

    public static void main(String[] args) {
        S st = new S();
        dataInput();
        st.dataOutput();

    }
}
