public class Purchases extends Model {
    private double total_price;
    private Suppliers suppliers;
    private Users users;

    public Purchases(int id, double total_price, Suppliers suppliers, Users users) {
        super(id);
        this.total_price = total_price;
        this.suppliers = suppliers;
        this.users = users;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
