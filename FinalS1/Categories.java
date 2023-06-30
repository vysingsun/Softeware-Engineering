public class Categories extends Model {
    private String categoryname;

    public Categories(int id, String categoryname) {
        super(id);
        this.categoryname = categoryname;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

}
