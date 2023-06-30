import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.DBException;

public class DBManager {
    Connection conn;
    private static DBManager instance;

    private DBManager(String db, String user, String pass, int port, String host) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass);
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            throw new DBException(e);
        }
    }

    private DBManager(String db, String user, String pass, int port) {
        this(db, user, pass, port, "localhost");
    }

    private DBManager(String db, String user, String pass) {
        this(db, user, pass, 3306);
    }

    private DBManager(String db, String user) {
        this(db, user, null);
    }

    private DBManager(String db) {
        this(db, "root");
    }

    private DBManager() {
        this("i4c");
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }

    private String[] createTables = { """
            create table if not exists countries(
                id int auto_increment primary key,
                country varchar(50) not null
            )
            """,
            """
                    create table if not exists cities(
                        id int auto_increment primary key,
                        city varchar(50) not null,
                        countryid INT REFERENCES countries(id),
                        ucity varchar(60) not null unique
                    )
                    """,
            """
                    create table if not exists hotels(
                        id int auto_increment primary key,
                        hotels varchar(100) not null,
                        countryid int refereNCes countries(id),
                        cityid INT REFERENCES cities(id),
                        stars TINYINT NOT NULL DEFAULT 0,
                        cost DOUBLE(10,2) NOT NULL DEFAULT 0,
                        info TEXT
                    )
                    """,
            """
                    CREATE TABLE IF NOT EXISTS images(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        hotelid INT REFERENCES hotels(id),
                        imagepath VARCHAR(256) NOT NULL
                    )
                    """,
            """
                    CREATE TABLE IF NOT EXISTS roles(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        role VARCHAR(20) NOT NULL UNIQUE
                    )
                    """,
            """
                    create table if not exists users(
                        id int auto_increment primary key,
                        username varchar(30) not null,
                        pass varchar(80) not null,
                        email varchar(128) not null,
                        roleid int references roles(id),
                        discount tinyint NOT NULL DEFAULT 0,
                        avatar varchar(265)
                    )
                    """ };
    private String[] dropTables = {
            "DROP TABLE IF EXISTS users",
            "DROP TABLE IF EXISTS roles",
            "DROP TABLE IF EXISTS images",
            "DROP TABLE IF EXISTS hotels",
            "DROP TABLE IF EXISTS cities",
            "DROP TABLE IF EXISTS countries",
    };

    public static void main(String[] args) throws SQLException {
        DBManager dbManager = new DBManager();
        for (String sql : dbManager.dropTables) {
            var stmt = dbManager.conn.createStatement();
            stmt.execute(sql);
        }
        for (String sql : dbManager.createTables) {
            var stmt = dbManager.conn.createStatement();
            stmt.execute(sql);
        }
        dbManager.conn.close();
    }
}
