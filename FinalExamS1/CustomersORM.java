import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomersORM extends ORM<Customers> {
    public CustomersORM() {
        tableName = "customers";
    }

    // create
    public Customers add(Customers c) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getPhone());
            stmt.setString(3, c.getAddress());

            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                c.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return c;
    }

    // read
    public ArrayList<Customers> listAll() {
        ArrayList<Customers> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Customers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Customers c) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName
                        + " SET name = ? , phone = ? , address = ? WHERE id = ? ;")) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getPhone());
            stmt.setString(3, c.getAddress());

            stmt.setInt(4, c.getId());
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
        CustomersORM orm = new CustomersORM();

        Customers c = new Customers(0, "VysingSun", "015674774", "Tong wu");
        orm.add(c);

        // for (var c1 : orm.listAll()) {
        // System.out.println("ID: " + c1.getId());
        // System.out.println("Name: " + c1.getName());
        // System.out.println("Phone: " + c1.getPhone());
        // System.out.println("Address: " + c1.getAddress());
        // }
    }
}
