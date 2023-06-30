import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StocksORM extends ORM<Stocks> {
    public StocksORM() {
        tableName = "stocks";
    }

    // create
    public Stocks add(Stocks s) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, s.getQuantity());
            stmt.setInt(2, s.getUnit());
            stmt.setInt(3, s.getProducts().getId());
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
    public ArrayList<Stocks> listAll() {
        ArrayList<Stocks> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Stocks(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        new Products(rs.getInt(4), null, 0, 0, 0, null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Stocks s) {
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName + " SET quantity = ? , unit = ? , product_id = ? WHERE id = ? ;")) {
            stmt.setInt(1, s.getQuantity());
            stmt.setInt(2, s.getUnit());
            stmt.setInt(3, s.getProducts().getId());
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
        StocksORM orm = new StocksORM();
        // Stocks s = new Stocks(0, 10, 10, new Products(1, null, 0, 0, 0, null));
        // orm.add(s);

        Stocks s = new Stocks(1, 24, 10, new Products(1, null, 0, 0, 0, null));
        orm.update(s);
    }
}
