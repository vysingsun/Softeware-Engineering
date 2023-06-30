import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class testDate {
    private Date startDate;
    private Date endDate;
    private int numberDate;

    public int getNumberDate() {

        return this.numberDate;
    }

    public void setnumberDate(int numberDate) {
        this.numberDate = numberDate;
    }

    public void setNumberDate(Date startday, Date endday) {
        if (startday.compareTo(endday) < 0) {
            int diffTime = (int) (endday.getTime() - startday.getTime());
            int diffDays = diffTime / (1000 * 60 * 60 * 24);
            this.numberDate = diffDays;
        } else {
            this.numberDate = 0;
        }
    }

    public testDate() {
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        if (getStartDate().compareTo(endDate) < 0) {
            this.endDate = endDate;
        }
    }

    public void inputDate() throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input start date by format(dd/mm/yyyy):");
        try {
            setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
        } catch (Exception err) {
            System.out.println("Input wrong format");
        }
        System.out.println("Input end date by formart(dd/mm/yyyy):");
        try {
            setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));

        } catch (Exception err) {
            System.out.println("Input wrong format");
        }
        setNumberDate(getStartDate(), getEndDate());
        createDateBaseAndTable();
        insertDateToDataBase(getStartDate(), getEndDate(), getNumberDate());

    }

    public void increaseDate(Date date, int numberday) {
        if (!String.valueOf(numberday).equals(null)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(date);
            } catch (Exception e) {
                System.out.println("Wrong format");
            }
            cal.add(Calendar.DAY_OF_MONTH, numberday);

            System.out.println("Date after increase:" + sdf.format(cal.getTime()));

        }
    }

    public void getData() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use `i4GIC2020_21`");

            ResultSet result = stmt.executeQuery("select * from Dateutil");
            while (result.next()) {
                System.out.println("{id:" + result.getString("DateId") + ",startdate:" + result.getString("date_start")
                        + ",enddate:" + result.getString("end_date") + ",numberdays:" + result.getInt("n_days") + "}");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertDateToDataBase(Date startdate, Date enddate, int numberdays) {
        Connection conn = null;
        java.sql.Date sqlStartDate = new java.sql.Date(startdate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(enddate.getTime());
        System.out.println(sqlEndDate.toString());
        System.out.println(sqlStartDate.toString());
        if (!String.valueOf(numberdays).equals(null) || !String.valueOf(startdate).equals(null)) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("use `i4GIC2020_21`");
                stmt.executeUpdate("insert into `Dateutil`(`date_start`, `end_date`,`n_days`) values(Date '"
                        + sqlStartDate.toString() + "',DATE '" + sqlEndDate.toString() + "'," + numberdays + ");");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void createDateBaseAndTable() {
        Statement stmt = null;
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecting Database");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null);// please change to
                                                                                             // root and with no
                                                                                             // password to
                                                                                             // testing
            stmt = conn.createStatement();
            stmt.executeUpdate("create database IF NOT EXISTS `i4GIC2020_21`;");
            stmt.executeUpdate("use `i4GIC2020_21`");
            stmt.executeUpdate("create table IF NOT EXISTS `Dateutil`(DateId int not null auto_increment primary key," +
                    "date_start DATE, end_date DATE,n_days int)");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "{" +
                " startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                ", numberDate='" + getNumberDate() + "'" +
                "}";
    }
}

class MainDate {
    public static void main(String[] args) throws Exception {
        int choice;
        DateUtil dateUtil = new DateUtil();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Input Date");
            System.out.println("2. Retrive and display");
            System.out.println("3. Increase date with date number and display");
            System.out.println("4. Display current start date,end date and n_day");
            System.out.println("5.Exit");
            System.out.print("Enter your choice");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                dateUtil.inputDate();
            } else if (choice == 3) {
                System.out.println("Input Date to increase number day(dd/mm/yyyy):");
                Date d = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
                dateUtil.increaseDate(d, dateUtil.getNumberDate());
            } else if (choice == 2) {
                dateUtil.getData();
            } else if (choice == 4) {
                System.out.println(dateUtil.toString());
            } else if (choice == 5) {
                System.out.println("Good bye!");
                break;
            } else {
                System.out.println("Wrong input. Try Again");
            }
        }
    }
}
