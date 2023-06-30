import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PurchasesORM extends ORM<Purchases> {
    public PurchasesORM() {
        tableName = "purchases";
    }

    // create
    public Purchases add(Purchases p) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, p.getTotal_price());
            stmt.setInt(2, p.getSuppliers().getId());
            stmt.setInt(3, p.getUsers().getId());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                p.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return p;
    }

    // read
    public ArrayList<Purchases> listAll() {
        ArrayList<Purchases> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Purchases(rs.getInt(1), rs.getDouble(2), new Suppliers(rs.getInt(3), null, null, null),
                        new Users(rs.getInt(4), null, null, null, null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Purchases p) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName + " SET total_price = ? , customer_id = ? , user_id = ? WHERE id = ? ;")) {
            stmt.setDouble(1, p.getTotal_price());
            stmt.setInt(2, p.getSuppliers().getId());
            stmt.setInt(3, p.getUsers().getId());
            stmt.setInt(4, p.getId());
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
        PurchasesORM orm = new PurchasesORM();

        // Purchases p = new Purchases(0, 70, new Suppliers(1, null, null, null), new
        // Users(1, null, null, null, null));
        // orm.add(p);

        for (var s1 : orm.listAll()) {
            System.out.println("ID: " + s1.getId());
            System.out.println("Total price: " + s1.getTotal_price());
            System.out.println("Supplier ID: " + s1.getSuppliers().getId());
            System.out.println("User ID: " + s1.getUsers().getId());
        }
    }
}
