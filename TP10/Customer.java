import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

enum OrderStatus {
    NONE, Waiting_to_order, Waiting_for_food, Ordering
}

public class Customer {
    private Integer number = null; // auto incrment
    private Date date_enter = null;
    private OrderStatus status = OrderStatus.NONE;

    public Customer() {
    }

    public Customer(Integer number, Date date_enter, OrderStatus status) {
        this.number = number;
        this.date_enter = date_enter;
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate_enter() {
        return date_enter;
    }

    public void setDate_enter(Date date_enter) {
        this.date_enter = date_enter;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void inputData() throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:m:s");
        System.out.print("Enter a date(dd/MM/yyyy H:m:s): ");
        try {
            setDate_enter(dateFormat.parse(sc.nextLine()));
        } catch (ParseException e) {
            // TODO: handle exception
            System.out.println("You have been input wrong format!");
        }
        setStatus(OrderStatus.valueOf("Waiting_to_order"));
    }

    public void outputDateFromDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `customers` WHERE number = " + number);
            System.out.println("Connected to Database.");
            if (rs.next()) {
                setNumber(number);
                setDate_enter(rs.getDate("date_enter"));
                setStatus(OrderStatus.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "Customer information: " +
                "\nNumber: " + number +
                "\nDate enter: " + date_enter +
                "\nStatus: " + status + "\n";
    }
}
