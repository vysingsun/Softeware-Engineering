import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoriesORM extends ORM<Categories> {
    public CategoriesORM() {
        tableName = "categories";
    }

    // create
    public Categories add(Categories r) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, r.getCategoryname());
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
    public ArrayList<Categories> listAll() {
        ArrayList<Categories> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Categories(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Categories r) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET categoryname = ? WHERE id = ? ")) {
            stmt.setNString(1, r.getCategoryname());
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
        CategoriesORM orm = new CategoriesORM();

        // create
        // Categories c = new Categories(0, "War");
        // orm.add(c);

        // update
        // Categories c = new Categories(1, "WAR");
        // orm.update(c);

        // display
        for (var c1 : orm.listAll()) {
            System.out.println("ID: " + c1.getId());
            System.out.println("Category name: " + c1.getCategoryname());
        }

        // delete
        // orm.remove(1);
    }
}
