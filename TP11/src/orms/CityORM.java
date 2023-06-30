import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// import java.util.Scanner;

public class CityORM extends ORM<City> {
    public CityORM() {

        tableName = "cities";
    }

    // list All from DB
    public ArrayList<City> listAll() {
        ArrayList<City> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT " + tableName + ".*,countries.country FROM " + tableName
                    + " JOIN countries ON " + tableName + ".countryid = countries.id;");
            while (rs.next()) {
                arr.add(new City(rs.getInt("id"), rs.getString(2),
                        new Country(rs.getInt(3), rs.getString(5))));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // List by query
    public ArrayList<City> rawQueryList(String query) {
        ArrayList<City> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                arr.add(new City(rs.getInt("id"), rs.getString(2),
                        new Country(rs.getInt(3), null)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    // add to DB
    public City add(City t) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, t.getCity());
            stmt.setInt(2, t.getCountry().getId());
            stmt.setString(3, t.getUcity());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                t.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return t;
    }

    // delete
    public boolean remove(int id) {
        if (count(id) == 1) {
            try (var stmt = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?")) {
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
    public void update(City t) {
        // Country country = new Country(NewCountryid, null);
        // City city = new City(id, newName, country);
        // city.setUcity(newName);
        try (var stmt = connection
                .prepareStatement(
                        "UPDATE " + tableName + " SET city = ? , countryid = ? , ucity = ? " + " WHERE id = ?")) {
            stmt.setString(1, t.getCity());
            stmt.setInt(2, t.getCountry().getId());
            stmt.setString(3, t.getUcity());
            stmt.setInt(4, t.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CityORM orm = new CityORM();

        // Scanner sc = new Scanner(System.in);

        // add to DB
        City city = new City(0, "Seoul", new Country(2, null));
        orm.add(city);
        System.out.println("New added city id: " + city.getId());

        // System.out.print("Enter city: ");
        // String ci = sc.nextLine();
        // listAll from DB
        // for (var c : orm.listAll()) {
        // System.out.println("ID: " + c.getId() + "; City: " + c.getCity() +
        // ";countryid: " + c.getCountry().getId()
        // + "; UCity: " + c.getUcity() + "; Country: " + c.getCountry().getCountry());
        // if (ci.equals(c.getCity())) {

        // }
        // }

        // delete
        // orm.remove(12);

        // update
        // Country c = new Country(2, null);
        // City t = new City(4, "Phnom Penh", c);
        // orm.update(t);

        // list row by query
        for (var ci : orm.rawQueryList("SELECT * FROM cities WHERE id = 1;")) {
            System.out
                    .println("ID: " + ci.getId() + "; City: " + ci.getCity() + "; countryid: " +
                            ci.getCountry().getId()
                            + "; UCity: " + ci.getUcity());
        }
    }
}
