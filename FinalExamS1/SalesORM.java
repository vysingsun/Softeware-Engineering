import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesORM extends ORM<Sales> {
    public SalesORM() {
        tableName = "sales";
    }

    // create
    public Sales add(Sales s) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, s.getTotal_price());
            stmt.setInt(2, s.getCustomers().getId());
            stmt.setInt(3, s.getUsers().getId());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                s.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return s;
    }

    // read
    public ArrayList<Sales> listAll() {
        ArrayList<Sales> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Sales(rs.getInt(1), rs.getDouble(2), new Customers(rs.getInt(3), null, null, null),
                        new Users(rs.getInt(4), null, null, null, null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Sales s) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName + " SET total_price = ? , customer_id = ? , user_id = ? WHERE id = ? ;")) {
            stmt.setDouble(1, s.getTotal_price());
            stmt.setInt(2, s.getCustomers().getId());
            stmt.setInt(3, s.getUsers().getId());
            stmt.setInt(4, s.getId());
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // delete
    public void remove(int id) {
        try (var stmt = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ? ;")) {
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SalesORM orm = new SalesORM();

        // Sales s = new Sales(0, 60, new Customers(1, null, null, null), new Users(1,
        // null, null, null, null));
        // orm.add(s);

        for (var s1 : orm.listAll()) {
            System.out.println("ID: " + s1.getId());
            System.out.println("Total price: " + s1.getTotal_price());
            System.out.println("Customer ID: " + s1.getCustomers().getId());
            System.out.println("User ID: " + s1.getUsers().getId());
        }
    }
}
