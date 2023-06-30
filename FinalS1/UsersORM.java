import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersORM extends ORM<Users> {
    public UsersORM() {
        tableName = "users";
    }

    // create
    public Users add(Users u) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPwd());
            stmt.setInt(3, u.getRoles().getId());
            stmt.setString(4, u.getToken());
            stmt.setInt(5, u.getGroups().getId());
            stmt.setString(6, u.getRemote_addr());
            stmt.setString(7, u.getForward_addr());
            stmt.setString(8, u.getImage());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                u.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return u;
    }

    // read
    public ArrayList<Users> listAll() {
        ArrayList<Users> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), new Roles(rs.getInt(4), null),
                        rs.getString(5), new Groups(rs.getInt(6), null), rs.getString(7), rs.getString(8),
                        rs.getString(9)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Users u) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET username = ? , pwd = ? , role_id = ? , token = ? , group_id = ? , remote_addr = ? , forward_addr = ? , image = ?  WHERE id = ? ")) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPwd());
            stmt.setInt(3, u.getRoles().getId());
            stmt.setString(4, u.getToken());
            stmt.setInt(5, u.getGroups().getId());
            stmt.setString(6, u.getRemote_addr());
            stmt.setString(7, u.getForward_addr());
            stmt.setString(8, u.getImage());
            stmt.setInt(9, u.getId());
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
        UsersORM orm = new UsersORM();

        // create
        // Roles = new Roles(1, "member");
        // Users u = new Users(0, "Nong Ta", "1234", new Roles(1, null), "None", new
        // Groups(1, null), "none", "none",
        // "none.png");
        // orm.add(u);

        // display
        // for (var us : orm.listAll()) {
        // System.out.println("ID: " + us.getId());
        // System.out.println("User Name: " + us.getUsername());
        // System.out.println("Password: " + us.getPwd());
        // System.out.println("Role ID: " + us.getRoles().getId());
        // System.out.println("Token: " + us.getToken());
        // System.out.println("Group ID: " + us.getGroups().getId());
        // System.out.println("Remote address: " + us.getRemote_addr());
        // System.out.println("Forward address: " + us.getForward_addr());
        // System.out.println("Image: " + us.getImage());
        // }

        // update
        Users u = new Users(1, "Nong Ta", "1234567", new Roles(1, null), "None", new Groups(1, null), "btb", "btb",
                "none.png");
        orm.update(u);

        // delete
        orm.remove(1);
    }
}
