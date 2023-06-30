import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    Connection conn;
    private static DBManager instance;

    private DBManager(String db, String user, String pass, int port, String host) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, user, pass);
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
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
        this("finalexamS1v2");
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
            create database IF NOT EXISTS `finalexamS1v2`

            """,
            """
                    use `finalexamS1v2`

                    """,
            """
                    create table if not exists categories(
                        id int auto_increment primary key,
                        name varchar(50) not null
                    )
                        """,
            """
                    create table if not exists products(
                        id int auto_increment primary key,
                        name varchar(50) not null,
                        cost_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                        sell_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                        unit INT,
                        category_id int REFERENCES categories(id)
                        )
                        """,
            """
                        create table if not exists stocks(
                        	id int auto_increment primary key,
                        	quantity INT,
                        	unit INT,
                       	    product_id int REFERENCES products(id)
                    )
                            """,
            """
                    create table if not exists users(
                        id int auto_increment primary key,
                        name varchar(30) not null,
                        password VARCHAR(180) not null,
                        confirm_password varchar(128) not null,
                        profile varchar(265)
                    )
                        """,
            """
                    create table if not exists customers(
                        id int auto_increment primary key,
                        name varchar(30) not null,
                        phone VARCHAR(180) not null,
                        address TEXT
                    )
                        """,
            """
                    create table if not exists suppliers(
                            id int auto_increment primary key,
                            name varchar(30) not null,
                            phone VARCHAR(15) not null,
                            address TEXT
                        )
                        """,
            """
                    create table if not exists sales(
                            id int auto_increment primary key,
                            total_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                            customer_id int REFERENCES customers(id),
                            user_id int REFERENCES users(id)
                                  )
                                  """,
            """
                    create table if not exists sale_detail(
                        id int auto_increment primary key,
                        quantity INT,
                        total_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                        date_sell DATE,
                        product_id int REFERENCES products(id),
                        sale_id int REFERENCES sales(id)
                        )
                        """,
            """
                    create table if not exists purchases(
                        id int auto_increment primary key,
                        total_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                        supplier_id INT REFERENCES suppliers(id),
                        user_id int REFERENCES users(id)
                    )
                            """,
            """
                    create table if not exists purchase_detail(
                        id int auto_increment primary key,
                        quantity INT,
                        total_price DOUBLE(10,2) NOT NULL DEFAULT 0,
                        datePurchase DATE,
                        product_id int REFERENCES products(id),
                        purchase_id int REFERENCES purchases(id)
                    )
                        """ };
    private String[] dropTables = {
            "DROP TABLE IF EXISTS purchase_detail",
            "DROP TABLE IF EXISTS purchases",
            "DROP TABLE IF EXISTS sale_detail",
            "DROP TABLE IF EXISTS sales",
            "DROP TABLE IF EXISTS suppliers",
            "DROP TABLE IF EXISTS customers",
            "DROP TABLE IF EXISTS users",
            "DROP TABLE IF EXISTS stocks",
            "DROP TABLE IF EXISTS products",
            "DROP TABLE IF EXISTS categories",
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
