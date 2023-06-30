public class Products extends Model {
    private String name;
    private double cost_price;
    private double sell_price;
    private int unit;
    private Category category;

    public Products(int id, String name, double cost_price, double sell_price, int unit, Category category) {
        super(id);
        this.name = name;
        this.cost_price = cost_price;
        this.sell_price = sell_price;
        this.unit = unit;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost_price() {
        return cost_price;
    }

    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
