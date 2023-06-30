import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class RolesORM extends ORM<Roles> {
    public RolesORM() {
        tableName = "roles";
    }

    // create
    public Roles add(Roles r) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, r.getRolename());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                r.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return r;
    }

    // read
    public ArrayList<Roles> listAll() {
        ArrayList<Roles> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Roles(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Roles r) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET rolename = ? WHERE id = ? ")) {
            stmt.setNString(1, r.getRolename());
            stmt.setInt(2, r.getId());
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
        RolesORM orm = new RolesORM();

        // ceate
        // Roles r = new Roles(0, "customer");
        // orm.add(r);

        // display
        // for (var c : orm.listAll()) {
        // System.out.println("ID: " + c.getId() + " Name: " + c.getRolename());
        // }

        // update
        // Roles r = new Roles(1, "member");
        // orm.update(r);

        // delete
        // orm.remove(2);
    }
}
