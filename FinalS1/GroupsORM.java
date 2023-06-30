import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class GroupsORM extends ORM<Groups> {
    public GroupsORM() {
        tableName = "groups";
    }

    // create
    public Groups add(Groups r) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, r.getGroupname());
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
    public ArrayList<Groups> listAll() {
        ArrayList<Groups> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Groups(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Groups r) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET groupname = ? WHERE id = ? ")) {
            stmt.setNString(1, r.getGroupname());
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
        GroupsORM orm = new GroupsORM();

        // create
        // Groups g = new Groups(0, "Shu");
        // orm.add(g);

        // display
        // for (var c : orm.listAll()) {
        // System.out.println("ID: " + c.getId() + " Group Name: " + c.getGroupname());
        // }

        // update
        Groups g = new Groups(1, "JG Group");
        orm.update(g);

        // delete
        orm.remove(1);
    }
}
