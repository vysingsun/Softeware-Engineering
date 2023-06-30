import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class CategoryORM extends ORM<Category> {
    public CategoryORM() {
        tableName = "categories";
    }

    // create
    public Category add(Category f) {
        try (var stmt = connection.prepareStatement("INSERT INTO " + tableName
                + " VALUES(NULL,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, f.getName());
            stmt.execute();
            var rs = stmt.getGeneratedKeys();
            if (rs.next())
                f.setId(rs.getInt(1));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return f;
    }

    // read
    public ArrayList<Category> listAll() {
        ArrayList<Category> arr = new ArrayList<>();
        try (var stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from " + tableName);
            while (rs.next()) {
                arr.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return arr;
    }

    // update by id
    public void update(Category ca) {
        try (var stmt = connection.prepareStatement("UPDATE " + tableName + " SET name = ? WHERE id = ? ")) {
            stmt.setNString(1, ca.getName());
            stmt.setInt(2, ca.getId());
            stmt.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
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
        CategoryORM orm = new CategoryORM();

        // Scanner sc = new Scanner(System.in);

        // Category ca = new Category(0, "drink");
        // orm.add(ca);

        // for (var c : orm.listAll()) {
        // System.out.println("ID: " + c.getId() + " Name: " + c.getName());
        // }

        // orm.remove(1);
        //
        // Category ca = new Category(2, "Candy");
        // orm.update(ca);

        String op;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nCategory");
            System.out.println("1. Create a new catrgory");
            System.out.println("2. List all categroy in Datebase");
            System.out.println("3. Update a categroy in Datebase by ID");
            System.out.println("4. Delete a categroy in Datebase by ID");
            System.out.println("5. Close");
            System.out.print("Enter a option: ");
            op = sc.nextLine();
            if (op.equals("1")) {
                System.out.println("\n1. Create a new catrgory");
                System.out.println("The ID of category will be auto increment.");
                System.out.print("Enter a name of category: ");
                String name = sc.nextLine();
                Category ca = new Category(0, name);
                orm.add(ca);
            } else if (op.equals("2")) {
                System.out.println("\n2. List all categroy in Datebase");
                for (var c : orm.listAll()) {
                    System.out.println("ID: " + c.getId() + " Name: " + c.getName());
                }
            } else if (op.equals("3")) {
                System.out.println("\n3. Update a categroy in Datebase by ID");
                System.out.println("You can not update ID of category!");
                System.out.print("Enter a ID of category to update: ");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a new name of category: ");
                String name = sc.nextLine();
                Category ca = new Category(num, name);
                orm.update(ca);
            } else if (op.equals("4")) {
                System.out.println("4. Delete a categroy in Datebase by ID");
                System.out.print("Enter a ID of category to delete: ");
                int num = sc.nextInt();
                sc.nextLine();
                orm.remove(num);
            } else {
                break;
            }
        }
    }
}
