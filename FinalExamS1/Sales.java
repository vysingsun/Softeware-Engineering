import java.util.Date;

public class Sales extends Model {
    private double total_price;
    private Customers customers;
    private Users users;

    public Sales(int id, double total_price, Customers customers, Users users) {
        super(id);
        this.total_price = total_price;
        this.customers = customers;
        this.users = users;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
