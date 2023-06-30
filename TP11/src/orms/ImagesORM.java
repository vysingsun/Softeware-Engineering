import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImagesORM extends ORM<Image> {
    public ImagesORM() {
        tableName = "images";
    }

    // listALL DB
    public ArrayList<Image> listAll() {
        ArrayList<Image> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");
            while (rs.next()) {
                arr.add(new Image(rs.getInt(1), new Hotel(rs.getInt(2), null, null, null, (short) 0, 0, null),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // listBy query
    public ArrayList<Image> rawQueryList(String query) {
        ArrayList<Image> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                arr.add(new Image(rs.getInt(1), new Hotel(rs.getInt(2), null, null, null, (short) 0, 0, null),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // add to DB
    public Image add(Image i) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, i.getHotel().getId());
            stmt.setString(2, i.getImagePath());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                i.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return i;
    }

    // delete in DB
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

    // update in DB
    public void update(Image i) {
        try (var stmt = connection
                .prepareStatement("UPDATE " + tableName + " SET hotelid = ? , imagepath = ? " + " WHERE id = ?")) {
            stmt.setInt(1, i.getHotel().getId());
            stmt.setString(2, i.getImagePath());
            stmt.setInt(3, i.getId());
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ImagesORM orm = new ImagesORM();

        // Add to DB
        Hotel h = new Hotel(4, null, null, null, (short) 0, 0, null);
        Image i = new Image(0, h, "president.png");
        orm.add(i);

        // List ALL in table of DB
        // for (var i1 : orm.listAll()) {
        // System.out.println("ID: " + i1.getId());
        // System.out.println("HotelID: " + i1.getHotel().getId());
        // System.out.println("Image Path: " + i1.getImagePath());
        // }

        // List by rom in DB
        for (var i1 : orm.rawQueryList("SELECT * FROM images WHERE id = 1;")) {
            System.out.println("ID: " + i1.getId());
            System.out.println("HotelID: " + i1.getHotel().getId());
            System.out.println("Image Path: " + i1.getImagePath());
        }

        // update to DB
        // Hotel h = new Hotel(2, null, null, null, (short) 0, 0, null);
        // Image i = new Image(1, h, "JSShotel.png");
        // orm.update(i);

        // delete by id
        // orm.remove(2);
    }
}
