import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SuppliersORM extends ORM<Suppliers> {
    public SuppliersORM() {
        tableName = "suppliers";
    }

    // create
    public Suppliers add(Suppliers s) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getPhone());
            stmt.setString(3, s.getAddress());

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
    public ArrayList<Suppliers> listAll() {
        ArrayList<Suppliers> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Suppliers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Suppliers s) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName
                        + " SET name = ? , phone = ? , address = ? WHERE id = ? ;")) {
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getPhone());
            stmt.setString(3, s.getAddress());

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
        SuppliersORM orm = new SuppliersORM();

        // Suppliers s = new Suppliers(0, "Tona", "017178888", "btb");
        // orm.add(s);

        for (var s1 : orm.listAll()) {
            System.out.println("ID: " + s1.getId());
            System.out.println("Name: " + s1.getName());
            System.out.println("Phone: " + s1.getPhone());
            System.out.println("Address: " + s1.getAddress());
        }
    }
}
