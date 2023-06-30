import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressesORM extends ORM<Addresses> {
    public AddressesORM() {
        tableName = "addresses";
    }

    // create
    public Addresses add(Addresses a) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, a.getHouseno());
            stmt.setString(2, a.getStreetno());
            stmt.setString(3, a.getStreetname());
            stmt.setString(4, a.getVillagename());
            stmt.setString(5, a.getDistrictname());
            stmt.setString(6, a.getCommunename());
            stmt.setString(7, a.getProvincename());
            stmt.setString(8, a.getCityname());
            stmt.setString(9, a.getCountryname());
            stmt.setInt(10, a.getIscurrent());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                a.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return a;
    }

    // update
    public void update(Addresses a) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName
                + " SET houseno = ? , streetno = ? , streesname = ? , villagename = ? , districtname = ? , communename = ? , provincename = ? , cityname = ? , countyname = ? , iscurrent = ? WHERE id = ? ")) {
            stmt.setString(1, a.getHouseno());
            stmt.setString(2, a.getStreetno());
            stmt.setString(3, a.getStreetname());
            stmt.setString(4, a.getVillagename());
            stmt.setString(5, a.getDistrictname());
            stmt.setString(6, a.getCommunename());
            stmt.setString(7, a.getProvincename());
            stmt.setString(8, a.getCityname());
            stmt.setString(9, a.getCountryname());
            stmt.setInt(10, a.getIscurrent());
            stmt.setInt(11, a.getId());
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // read
    public ArrayList<Addresses> listAll() {
        ArrayList<Addresses> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Addresses(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getInt(11)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
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
        AddressesORM orm = new AddressesORM();

        // create
        // Addresses a = new Addresses(0, "13A", "568", "samdach wu", "none", "none",
        // "none", "none", "none", "none", 1);
        // orm.add(a);

        // update
        // Addresses a = new Addresses(1, "13A", "568", "samdach Wu", "none", "none",
        // "none", "none", "Peng", "Qin", 1);
        // orm.update(a);

        // display
        for (var a1 : orm.listAll()) {
            System.out.println("ID: " + a1.getId());
            System.out.println("House no: " + a1.getHouseno());
            System.out.println("Strees no: " + a1.getStreetno());
            System.out.println("Strees name: " + a1.getStreetname());
            System.out.println("Village name: " + a1.getVillagename());
            System.out.println("District name: " + a1.getDistrictname());
            System.out.println("Commune name: " + a1.getCommunename());
            System.out.println("Province name: " + a1.getProvincename());
            System.out.println("City name: " + a1.getCityname());
            System.out.println("Country name:" + a1.getCountryname());
            System.out.println("Is current: " + a1.getIscurrent());
        }
        // delete
        // orm.remove(1);
    }
}
