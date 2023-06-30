import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductsORM extends ORM<Products> {
    public ProductsORM() {
        tableName = "products";
    }

    // create
    public Products add(Products f) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, f.getName());
            stmt.setDouble(2, f.getCost_price());
            stmt.setDouble(3, f.getSell_price());
            stmt.setInt(4, f.getUnit());
            stmt.setInt(5, f.getCategory().getId());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                f.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;
    }

    // read
    public ArrayList<Products> listAll() {
        ArrayList<Products> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Products(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5),
                        new Category(rs.getInt(6), null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(Products p) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET name = ? , cost_price = ? , sell_price = ? , unit = ? , category_id = ? "
                + " WHERE id = ? ;")) {
            stmt.setString(1, p.getName());
            stmt.setDouble(2, p.getCost_price());
            stmt.setDouble(3, p.getSell_price());
            stmt.setInt(4, p.getUnit());
            stmt.setInt(5, p.getCategory().getId());
            stmt.setInt(6, p.getId());
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
        ProductsORM orm = new ProductsORM();

        // Products p = new Products(0, "MilkyTa", 2.0, 2.5, 30, new Category(2,
        // null));
        // orm.add(p);

        // for (var p1 : orm.listAll()) {
        // System.out.println("ID: " + p1.getId());
        // System.out.println("Name: " + p1.getName());
        // System.out.println("Cost price: " + p1.getCost_price());
        // System.out.println("Sell price: " + p1.getSell_price());
        // System.out.println("Unit: " + p1.getUnit());
        // System.out.println("Category: " + p1.getCategory().getId());
        // }

        Products p = new Products(1, "Milk Tea", 2, 2.5, 10, new Category(1,
                null));
        orm.update(p);
        // orm.remove(1);
    }
}
