
// import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// import com.mysql.cj.util.DnsSrv.SrvRecord;

public class InventoriesORM extends ORM<Inventories> {
    public InventoriesORM() {
        tableName = "inventories";
    }

    // create
    public Inventories add(Inventories i) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, i.getBooks().getId());
            stmt.setInt(2, i.getCopies());
            stmt.setString(3, i.getSrcurl());
            stmt.setTimestamp(4, i.getCreated_at());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                i.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return i;
    }

    // read
    public ArrayList<Inventories> listAll() {
        ArrayList<Inventories> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Inventories(rs.getInt(1), new Books(rs.getInt(2), null, null, null, null, null),
                        rs.getInt(3), rs.getString(4), rs.getTimestamp(5)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Inventories i) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET book_id = ? , copies = ? , srcurl = ? , create_at = ? WHERE id = ? ")) {
            stmt.setInt(1, i.getBooks().getId());
            stmt.setInt(2, i.getCopies());
            stmt.setString(3, i.getSrcurl());
            stmt.setTimestamp(4, i.getCreated_at());
            stmt.setInt(5, i.getId());
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
        InventoriesORM orm = new InventoriesORM();

        // create
        // Inventories i = new Inventories(0, new Books(1, null, null, null, null,
        // null), 5, "none",
        // new Timestamp(new Date().getTime()));
        // orm.add(i);

        // update
        // Inventories i = new Inventories(1, new Books(3, null, null, null, null,
        // null), 5, "NONE",
        // new Timestamp(new Date().getTime()));
        // orm.update(i);

        // display
        for (var i1 : orm.listAll()) {
            System.out.println("ID: " + i1.getId());
            System.out.println("Book ID: " + i1.getBooks().getId());
            System.out.println("Copies: " + i1.getCopies());
            System.out.println("Srcurl: " + i1.getSrcurl());
            System.out.println("Create at : " + i1.getCreated_at());
        }

        // delete
        // orm.remove(1);
    }
}
