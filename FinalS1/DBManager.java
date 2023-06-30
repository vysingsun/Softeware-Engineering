import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    Connection conn;
    // Statement stmt;
    private static DBManager instance;

    private DBManager() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalexams1",
                    "root", null);
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public void createDatabaseAndTables() throws ClassNotFoundException {

        try {
            Statement stmt;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalexams1", "root", null);
            stmt = conn.createStatement();
            stmt.executeUpdate("create database IF NOT EXISTS `finalexams1`;");
            stmt.executeUpdate("use `finalexams1`");
            stmt.executeUpdate("""
                    create table if not exists roles(
                        id int auto_increment primary key,
                        rolename varchar(100) not null
                    );""");
            stmt.executeUpdate("""
                    create table if not exists groups(
                        id int auto_increment primary key,
                        groupname varchar(100) not null
                        );""");
            stmt.executeUpdate("""
                    create table if not exists users(
                        id int auto_increment primary key,
                        username varchar(100) not null,
                        pwd varchar(50),
                        role_id INT REFERENCES roles(id),
                        token VARCHAR(256) not null,
                        group_id INT REFERENCES groups(id),
                        remote_addr VARCHAR (16) NOT NULL,
                        forward_addr VARCHAR (16) NOT NULL,
                        image VARCHAR(256) not null
                        );
                        """);
            stmt.executeUpdate("""
                    create table if not exists addresses(
                        id int auto_increment primary key,
                        houseno varchar(150) not null,
                        streetno varchar(150) not null,
                        streesname varchar(150) not null,
                        villagename varchar(150) not null,
                        districtname varchar(150) not null,
                        communename varchar(150) not null,
                        provincename varchar(150) not null,
                        cityname varchar(150) not null,
                        countyname varchar(150) not null,
                        iscurrent TINYINT NOT NULL DEFAULT 0
                    );
                        """);
            stmt.executeUpdate("""
                    create table if not exists publishers(
                        id int auto_increment primary key,
                        publishername varchar(50),
                        address_id INT REFERENCES addresses(id)
                        );
                        """);
            stmt.executeUpdate("""
                    create table if not exists categories(
                        id int auto_increment primary key,
                        categoryname varchar(256) not null
                    );
                        """);
            stmt.executeUpdate("""
                    create table if not exists books(
                        id int auto_increment primary key,
                        title varchar(256) not null,
                        path varchar(256) not null,
                        user_id INT REFERENCES users(id),
                        group_id INT REFERENCES groups(id),
                        publisher_id INT REFERENCES publishers(id)
                        );
                        """);
            stmt.executeUpdate("""
                    create table if not exists book_categories(
                        book_id int auto_increment primary key,
                        category_id INT REFERENCES categories(id)
                    );
                        """);
            stmt.executeUpdate("""
                    create table if not exists inventories(
                        id int auto_increment primary key,
                        book_id INT REFERENCES books(id),
                        copies INT,
                        srcurl varchar(256) not null,
                        created_at TIMESTAMP
                    );
                        """);
            stmt.executeUpdate("""
                    create table if not exists downloads(
                        id int auto_increment primary key,
                        user_id INT REFERENCES users(id),
                        book_id INT REFERENCES books(id),
                        downloaded_at TIMESTAMP
                    );
                        """);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
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

    public static void main(String[] args) throws ClassNotFoundException {
        DBManager db = new DBManager();
        db.createDatabaseAndTables();

    }
}
