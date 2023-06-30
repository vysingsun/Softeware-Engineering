import java.util.Date;

public class SaleDetail extends Model {
    private int quantity;
    private double total_price;
    private Date date_sale;
    private Products products;
    private Sales sales;

    public SaleDetail(int id, int quantity, double total_price, Date date_sale, Products products, Sales sales) {
        super(id);
        this.quantity = quantity;
        this.total_price = total_price;
        this.date_sale = date_sale;
        this.products = products;
        this.sales = sales;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

}
