
// import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class SaleDetailORM extends ORM<SaleDetail> {
    // public static final SimpleDateFormat format = new
    // SimpleDateFormat("dd/MM/yyyy");
    // public static final SimpleDateFormat dbFormat = new
    // SimpleDateFormat("yyyy-MM-dd");

    public SaleDetailORM() {
        tableName = "sale_detail";
    }

    // create
    public SaleDetail add(SaleDetail s) {
        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, s.getQuantity());
            stmt.setDouble(2, s.getTotal_price());
            stmt.setString(3, dbFormat.format(s.getDate_sale()) + "");
            stmt.setInt(4, s.getProducts().getId());
            stmt.setInt(5, s.getSales().getId());
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
    public ArrayList<SaleDetail> listAll() {
        ArrayList<SaleDetail> arr = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new SaleDetail(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4),
                        new Products(rs.getInt(5), null, 0, 0, 0, null), new Sales(1, 0, null, null)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update
    public void update(SaleDetail sd) {
        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
        try (var stmt = connection.prepareStatement(
                "UPDATE " + tableName
                        + " SET quantity = ? , total_price = ? , date_sell = ? , product_id = ? , sale_id = ? WHERE id = ? ;")) {
            stmt.setInt(1, sd.getQuantity());
            stmt.setDouble(2, sd.getTotal_price());
            stmt.setString(3, dbFormat.format(sd.getDate_sale()));
            stmt.setInt(4, sd.getProducts().getId());
            stmt.setInt(5, sd.getSales().getId());
            stmt.setInt(6, sd.getId());
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

    public static void main(String[] args) throws ParseException {
        SaleDetailORM orm = new SaleDetailORM();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        // System.out.print("Enter a start date(dd/MM/yyyy): ");
        // Date d1 = format.parse(sc.nextLine());

        // SaleDetail s = new SaleDetail(0, 4000, 4089.27, d1, new Products(1, null, 0,
        // 0, 0, null),
        // new Sales(1, 0, null, null));
        // orm.add(s);

        // for (var sd : orm.listAll()) {
        // System.out.println("ID: " + sd.getId());
        // System.out.println("Quantity: " + sd.getQuantity());
        // System.out.println("Total price: " + sd.getTotal_price());
        // System.out.println("Date sale: " + format.format(sd.getDate_sale()));
        // System.out.println("Product ID: " + sd.getProducts().getId());
        // System.out.println("Sale ID: " + sd.getSales().getId());
        // }

        System.out.print("Enter a start date(dd/MM/yyyy): ");
        Date d1 = format.parse(sc.nextLine());

        SaleDetail s = new SaleDetail(4, 4000, 4089.27, d1, new Products(1, null, 0,
                0, 0, null),
                new Sales(1, 0, null, null));
        orm.update(s);
    }
}
