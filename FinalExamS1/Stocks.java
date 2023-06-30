public class Stocks extends Model {
    private int quantity;
    private int unit;
    private Products products;

    public Stocks(int id, int quantity, int unit, Products products) {
        super(id);
        this.quantity = quantity;
        this.unit = unit;
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
