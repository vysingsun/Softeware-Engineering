import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class testbool {
    public Connection openConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/user",
                    "root", null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean loginUser(String username, String passwd) {
        Connection conn = openConnection();
        if (conn != null) {
            try (PreparedStatement stmt = conn
                    .prepareStatement("SELECT count(*) FROM users WHERE username=? AND passwd=?;")) {
                stmt.setString(1, username);
                stmt.setString(2, passwd);
                var rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return false;
    }

    public static void main(String[] args) {
        testbool t = new testbool();

        System.out.println(t.loginUser("erbetrb", "gverg"));
    }
}
