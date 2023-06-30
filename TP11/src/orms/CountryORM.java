import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// import java.util.Scanner;

public class CountryORM extends ORM<Country> {
    public CountryORM() {
        // super();
        tableName = "countries";
    }

    // list All from DB
    public ArrayList<Country> listAll() {
        ArrayList<Country> ar = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                ar.add(new Country(rs.getInt("id"), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return ar;
    }

    // add to DB
    public Country add(Country t) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, t.getCountry());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                t.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    // delete
    public boolean remove(int id) {
        if (count(id) == 1) {
            try (var stmt = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ? ;")) {
                stmt.setInt(1, id);
                stmt.execute();
                System.out.println("The data has been deleted by ID = " + id);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The ID = " + id + " wasn't in Database!");
        }
        return false;
    }

    // update by id
    public void update(Country c) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET country = ?" + " WHERE id = ?")) {
            stmt.setString(1, c.getCountry());
            stmt.setInt(2, c.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List by query
    public ArrayList<Country> rawQueryList(String query) {
        ArrayList<Country> ar = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ar.add(new Country(rs.getInt("id"), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ar;
    }

    public static void main(String[] args) {
        CountryORM orm = new CountryORM();
        // Scanner sc = new Scanner(System.in);

        // System.out.print("1. Insert data to DB: ");
        // op = sc.nextLine();
        // if (op.equals("1")) {
        // System.out.print("Enter a country: ");
        // co = sc.nextLine();
        // // Country c = new Country(0, co);
        // // orm.add(c);
        // }

        // add
        Country c = new Country(0, "Korea");
        orm.add(c);
        System.out.println("New added country id: " + c.getId());

        // System.out.println("ID: " + c.getId() + "; Name: " + c.getCountry());

        // listAll
        for (var c2 : orm.listAll()) {
            System.out.println("ID: " + c2.getId() + "; Name: " + c2.getCountry());
        }

        // update
        // Country c = new Country(2, "Camboge");
        // orm.update(c);

        // remove from datebase
        // orm.remove(4);

        // list by row query
        // for (var ct : orm.rawQueryList("SELECT * FROM countries WHERE id = 2;")) {
        // System.out.println("ID: " + ct.getId() + "; Country: " + ct.getCountry());
        // }
    }
}
