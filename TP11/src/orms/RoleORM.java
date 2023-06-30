import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleORM extends ORM<Role> {
    public RoleORM() {
        tableName = "roles";
    }

    // list All
    public ArrayList<Role> listAll() {
        ArrayList<Role> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Role(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return arr;
    }

    // list by row query
    public ArrayList<Role> rawQueryList(String query) {
        ArrayList<Role> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                arr.add(new Role(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return arr;
    }

    // add to DB
    public Role add(Role r) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, r.getRole());
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

    // delete in DB
    public boolean remove(int id) {
        if (count(id) == 1) {
            try (var stmt = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?")) {
                stmt.setInt(1, id);
                stmt.execute();
                System.out.println("The data has been deleted by ID = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The ID = " + id + " wasn't in Database!");
        }
        return false;
    }

    // update in DB
    public void update(Role r) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET role = ?" + " WHERE id = ?")) {
            stmt.setString(1, r.getRole());
            stmt.setInt(2, r.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RoleORM orm = new RoleORM();

        // add to DB
        // Role r = new Role(0, "Admin");
        // orm.add(r);

        // list All
        for (var r1 : orm.listAll()) {
            System.out.println("ID: " + r1.getId() + "; Role: " + r1.getRole());
        }

        // list Rom query
        // for (var r1 : orm.rawQueryList("SELECT * FROM roles WHERE id = 2;")) {
        // System.out.println("ID: " + r1.getId() + "; Role: " + r1.getRole());
        // }

        // update in DB
        // Role r = new Role(1, "admin");
        // orm.update(r);

        // delete in DB
        // orm.remove(2);
    }
}
