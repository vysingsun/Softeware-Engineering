import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksORM extends ORM<Books> {
    public BooksORM() {
        tableName = "books";
    }

    // create
    public Books add(Books b) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getPath());
            stmt.setInt(3, b.getUsers().getId());
            stmt.setInt(4, b.getGroups().getId());
            stmt.setInt(5, b.getPublishers().getId());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                b.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return b;
    }

    // read
    public ArrayList<Books> listAll() {
        ArrayList<Books> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Books(rs.getInt(1), rs.getString(2), rs.getString(3),
                        new Users(rs.getInt(4), null, null, null, null, null, null, null, null),
                        new Groups(rs.getInt(5), null), new Publishers(rs.getInt(6), null, null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Books b) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET title = ? , path = ? , user_id = ? , group_id = ? , publisher_id = ? WHERE id = ? ")) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getPath());
            stmt.setInt(3, b.getUsers().getId());
            stmt.setInt(4, b.getGroups().getId());
            stmt.setInt(5, b.getPublishers().getId());
            stmt.setInt(6, b.getId());
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
        BooksORM orm = new BooksORM();

        // create
        // Books b = new Books(0, "none", "none", new Users(1, null, null, null, null,
        // null, null, null, null),
        // new Groups(1, null), new Publishers(1, null, null));
        // orm.add(b);

        // update
        // Books b = new Books(1, "NONE", "NONE", new Users(1, null, null, null, null,
        // null, null, null, null),
        // new Groups(1, null), new Publishers(1, null, null));
        // orm.update(b);

        // display
        for (var b1 : orm.listAll()) {
            System.out.println("ID: " + b1.getId());
            System.out.println("Title: " + b1.getTitle());
            System.out.println("Path: " + b1.getPath());
            System.out.println("Use ID: " + b1.getUsers().getId());
            System.out.println("Group ID: " + b1.getGroups().getId());
            System.out.println("Publisher ID: " + b1.getPublishers().getId());

        }

        // delete
        // orm.remove(1);
    }
}
