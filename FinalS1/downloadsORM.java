import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class downloadsORM extends ORM<Downloads> {
    public downloadsORM() {
        tableName = "downloads";
    }

    // create
    public Downloads add(Downloads d) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, d.getUsers().getId());
            stmt.setInt(2, d.getBooks().getId());
            stmt.setTimestamp(3, d.getDownloaded_at());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                d.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return d;
    }

    // read
    public ArrayList<Downloads> listAll() {
        ArrayList<Downloads> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Downloads(rs.getInt(1),
                        new Users(rs.getInt(2), null, null, null, null, null, null, null, null),
                        new Books(rs.getInt(3), null, null, null, null, null), rs.getTimestamp(4)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Downloads d) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET book_id = ? , copies = ? , srcurl = ? , create_at = ? WHERE id = ? ")) {
            stmt.setInt(1, d.getUsers().getId());
            stmt.setInt(2, d.getBooks().getId());
            stmt.setTimestamp(3, d.getDownloaded_at());
            stmt.setInt(4, d.getId());
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
        downloadsORM orm = new downloadsORM();

        // create
        Downloads d = new Downloads(0, new Users(1, null, null, null, null, null,
                null, null, null),
                new Books(1, null, null, null, null, null), new Timestamp(new Date().getTime()));
        orm.add(d);

        // update
        // Downloads d = new Downloads(1, new Users(5, null, null, null, null, null,
        // null, null, null),
        // new Books(4, null, null, null, null, null), new Timestamp(new
        // Date().getTime()));
        // orm.update(d);

        // display
        // for (var d1 : orm.listAll()) {
        // System.out.println("ID: " + d1.getId());
        // System.out.println("User ID: " + d1.getUsers().getId());
        // System.out.println("Book ID: " + d1.getBooks().getId());
        // System.out.println("Downloaded at : " + d1.getDownloaded_at());
        // }

        // delete
        // orm.remove(1);

    }
}
