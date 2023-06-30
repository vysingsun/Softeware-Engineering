import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.util.DnsSrv.SrvRecord;

public class PublishersORM extends ORM<Publishers> {
    public PublishersORM() {
        tableName = "publishers";
    }

    // create
    public Publishers add(Publishers p) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getPublishername());
            stmt.setInt(2, p.getAddresses().getId());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                p.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return p;
    }

    // read
    public ArrayList<Publishers> listAll() {
        ArrayList<Publishers> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Publishers(rs.getInt(1), rs.getString(2),
                        new Addresses(rs.getInt(3), null, null, null, null, null, null, null, null, null, 0)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Publishers p) {
        try (var stmt = connection
                .prepareStatement("UPDATE " + tableName + " SET publishername = ? , address_id = ? WHERE id = ? ")) {
            stmt.setString(1, p.getPublishername());
            stmt.setInt(2, p.getAddresses().getId());
            stmt.setInt(3, p.getId());
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
        PublishersORM orm = new PublishersORM();

        // create
        // Publishers p = new Publishers(0, "None",
        // new Addresses(1, null, null, null, null, null, null, null, null, null, 0));
        // orm.add(p);

        // display
        for (var p1 : orm.listAll()) {
            System.out.println("ID: " + p1.getId());
            System.out.println("Publisher name: " + p1.getPublishername());
            System.out.println("Address ID: " + p1.getAddresses().getId());
        }

        // update
        // Publishers p = new Publishers(1, "none",
        // new Addresses(1, null, null, null, null, null, null, null, null, null, 0));
        // orm.update(p);

        // delete
        // orm.remove(1);
    }
}
