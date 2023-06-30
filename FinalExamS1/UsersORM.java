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
                + " VALUES(NULL,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getConfirm_password());
            stmt.setString(4, u.getProfile());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                u.setId(rs.getInt(1));
            }
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
                arr.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Users u) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName
                        + " SET name = ? , password = ? , confirm_password = ? , profile = ? WHERE id = ? ;")) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getConfirm_password());
            stmt.setString(4, u.getProfile());
            stmt.setInt(5, u.getId());
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

        Users u = new Users(0, "MarTy", "asdf", "asdf", "profileUser.png");
        orm.add(u);

        // for (var u1 : orm.listAll()) {
        // System.out.println("ID: " + u1.getId());
        // System.out.println("Name: " + u1.getName());
        // System.out.println("Passowrd: " + u1.getPassword());
        // System.out.println("Confirm password: " + u1.getConfirm_password());
        // System.out.println("Profile: " + u1.getProfile());
        // }
    }
}
