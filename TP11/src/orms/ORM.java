
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

// import utils.DBManager;
public class ORM<T> {
    protected Connection connection;
    protected String tableName = null;

    public ORM() {
        connection = DBManager.getInstance().getConn();
    }

    public ArrayList<T> listAll() {
        return new ArrayList<>();
    }

    public T add(T t) {
        return t;
    }

    public boolean delete(int id) {
        return true;
    }

    public void update(T t) {
    }

    public ArrayList<T> rawQueryList(String query) {
        return new ArrayList<>();
    }

    // a method to find a id in a table of databse
    // then take this method to check, if it's equal 1 the id in table will be found
    public int count(int id) {
        int count = -1;
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select Count(*) from " + tableName + " WHERE id = " + id + ";");
            rs.next();
            // number of id will be 1
            count = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // number of those id
        return count;
    }
}
