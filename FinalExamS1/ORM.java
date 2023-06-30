import java.sql.Connection;
import java.util.ArrayList;

public class ORM<F> {
    protected Connection connection;
    protected String tableName = null;

    public ORM() {
        connection = DBManager.getInstance().getConn();
    }

    public ArrayList<F> listAll() {
        return new ArrayList<>();
    }

    public F add(F f) throws Exception {
        return f;
    }

    public boolean delete(int id) {
        return true;
    }

    public void update(F f) {

    }
}
