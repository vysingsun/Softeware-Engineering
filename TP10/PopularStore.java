import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PopularStore {
    Scanner sc = new Scanner(System.in);
    private Deque<CustomerOrder> customerOrder = new LinkedList<>();

    public Deque<CustomerOrder> getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomerOrder(Deque<CustomerOrder> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void creatDatabaseAndCreateTable() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("create database if not exists `tp10java`;");
            stmt.executeUpdate("use `tp10java`;");
            stmt.executeUpdate("create table if not exists `customers`(customer_no int auto_increment primary key," +
                    "start_serving DATETIME, end_serving DATETIME, status VARCHAR(100),food VARCHAR(100), price decimal(13,2), duration DATETIME;");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("I can't connect to database!");
        }
    }

    public void insertToDatabse(CustomerOrder cus) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("use `tp10java`;");
            stmt.executeUpdate(
                    "INSERT INTO `customer`(start_serving, end_serving, status, food, price, duration) VALUE(" +
                            cus.getStartServe() + ", DATETIME '" +
                            cus.getServDate() + "'," +
                            cus.getCustomer().getStatus().toString() + "," +
                            cus.getFood() + "," +
                            cus.getPrice() + ", DATETIME '" +
                            cus.getDurationServe() + "')");
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public void load_and_displayFromDatabase() throws ParseException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", null)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            System.out.println("Connected to Database.");
            System.out.println("\nAll of information from Database:");
            System.out.println("_________________________________");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("customer_no"));
                System.out.println(
                        "Start Date: " + new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(rs.getString("start_serving")));
                System.out.println(
                        "During Date: " + new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(rs.getString("duration")));
                System.out.println(
                        "End Date: " + new SimpleDateFormat("yyyy-MM-dd H:m:s").parse(rs.getString("end_serving")));
                System.out.println("Status: " + OrderStatus.valueOf(rs.getString("statut")));
                System.out.println("Food: " + rs.getString("food"));
                System.out.println("Price: " + rs.getDouble("price"));
            }
            if (!rs.next()) {
                System.out.println("There aren't data in record!");
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}

class MainPopularStore {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int op;
        PopularStore store = new PopularStore();
        CustomerQueue customerQ = new CustomerQueue();
        CustomerOrder customerO = new CustomerOrder();
        while (true) {
            System.out.println("1. Add customer to waiting list (queue) for serving");
            System.out.println("2. Display list of customers in queue");
            System.out.println("3. List all served customers (orders history)");
            System.out.println("4. Remove a customer from queue");
            System.out.println("5. Exit ");
            System.out.print("Enter the choice: ");
            op = sc.nextInt();
            if (op == 1) {
                customerO.recordData();
                store.creatDatabaseAndCreateTable();
                store.insertToDatabse(customerO);
            } else if (op == 2) {
                customerQ.displayCustomerInQueue();
            } else if (op == 3) {
                store.load_and_displayFromDatabase();
            } else if (op == 4) {
                customerQ.removeCustomer();
            } else {
                break;
            }
        }
    }
}
