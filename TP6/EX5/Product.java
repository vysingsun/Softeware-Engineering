import java.util.ArrayList;

public class Product {
    private String name;
    private float price;
    private int num, amount_inStock;

    public Product(int num, String name, float price, int amount_inStock) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.amount_inStock = amount_inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAmount_inStock() {
        return amount_inStock;
    }

    public void setAmount_inStock(int amount_inStock) {
        this.amount_inStock = amount_inStock;
    }

}