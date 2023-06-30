import javax.xml.crypto.Data;

public class PurchaseDetail extends Model {
    private int quantity;
    private double total_price;
    private Data datePurchase;
    private Products products;
    private Purchases purchases;

    public PurchaseDetail(int id, int quantity, double total_price, Data datePurchase, Products products,
            Purchases purchases) {
        super(id);
        this.quantity = quantity;
        this.total_price = total_price;
        this.datePurchase = datePurchase;
        this.products = products;
        this.purchases = purchases;
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

    public Data getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Data datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Purchases getPurchases() {
        return purchases;
    }

    public void setPurchases(Purchases purchases) {
        this.purchases = purchases;
    }

}
